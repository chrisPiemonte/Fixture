
CREATE DATABASE fixture11;

CREATE USER fixture11 WITH PASSWORD 'fix' CREATEDB;

ALTER DATABASE fixture11 OWNER TO fixture11;

\c fixture11


/* ---------------- TYPES ---------------- */

/*
CREATE TYPE t_stagione AS (
	anno CHAR(5)
);

CREATE TYPE t_squadra AS (
	nome VARCHAR(20),
	citta VARCHAR(20)
);

CREATE TYPE t_partita AS (
	id CHAR(5),
	numero SMALLINT,
	data DATE,
	molt NUMERIC(3,2),
	stagione CHAR(5),
	squadra_avversaria VARCHAR(20)
);

*/
CREATE TYPE t_area AS (
	id CHAR(3),
	nome VARCHAR(20),
	prezzo_base NUMERIC(5,2)
);

/*
CREATE TYPE t_tipo_posto AS ENUM (
	'NORMALE',
	'PRESIDENTE',
	'DISABILI'
);

CREATE TYPE t_tipo_spettatore AS ENUM (
	'PASSHOLDER',
	'SPETTATORE'
);

*/

/*
CREATE TYPE t_generalita AS (
	nome VARCHAR(20),
	cognome VARCHAR(20),
	data_nascita DATE,
	luogo_nascita VARCHAR(20),
	telefono text
);
*/

/*
CREATE TYPE t_persona AS (
	cf CHAR(16),
	generalita t_generalita
);
*/

/* trigger che se inserisci un passholder vede se c'è una persona e la toglie */



/* ---------------- TABLES ---------------- */

CREATE TABLE stagione (
	anno CHAR(4) PRIMARY KEY
);

CREATE TABLE squadra_avversaria (
	nome VARCHAR(20) PRIMARY KEY,
	citta VARCHAR(20) NOT NULL
);

CREATE TABLE partita (
	stagione CHAR(4) REFERENCES stagione,
	numero SMALLINT NOT NULL,
	data DATE NOT NULL,
	molt NUMERIC(3,2) DEFAULT 1.00,
	squadra_avversaria VARCHAR(20) REFERENCES squadra_avversaria NOT NULL,
	PRIMARY KEY (stagione, numero)
);


CREATE TABLE settore OF t_area (
	PRIMARY KEY (id)
);
ALTER TABLE settore ALTER COLUMN prezzo_base SET DEFAULT 1.00;


CREATE TABLE anello OF t_area (
	PRIMARY KEY (id)
);
ALTER TABLE anello ALTER COLUMN prezzo_base SET DEFAULT 1.00;

/* trigger prezzo magari una funz*/
CREATE TABLE posto (
	numero SMALLINT,
	settore CHAR(3) REFERENCES settore,
	anello CHAR(3) REFERENCES anello,
	tipo VARCHAR(20) DEFAULT 'NORMALE',
	prezzo NUMERIC(5,2) DEFAULT NULL, /* ---------------------NOT NULL, */
	PRIMARY KEY (numero, settore, anello)
);

/* trigger che controlla che chi compra è un passholder */
CREATE TABLE persona (
	cf CHAR(16) PRIMARY KEY,
	tipo VARCHAR(20) DEFAULT 'SPETTATORE',
	nome VARCHAR(20),
	cognome VARCHAR(20),
	data_nascita DATE,
	luogo_nascita VARCHAR(20),
	telefono text
);

/* 
CREATE TABLE Passholder (
	id_tessera CHAR (7) PRIMARY KEY,
	CHECK(cf IS NOT NULL)
) INHERITS (Persona);
*/

/* trigger prezzo e check timestamp*/
/* trigger che controlla che chi compra è un passholder */
CREATE TABLE biglietto (
	id SERIAL PRIMARY KEY,
	prezzo_totale NUMERIC(5,2) DEFAULT NULL,
	ora_acquisto TIMESTAMP WITH TIME ZONE,
	stagione CHAR(4) NOT NULL,
	partita SMALLINT NOT NULL,
	posto SMALLINT NOT NULL,
	settore CHAR(3) NOT NULL,
	anello CHAR(3) NOT NULL,
	spettatore CHAR(16) REFERENCES persona NOT NULL,
	compratore CHAR(16) REFERENCES persona NOT NULL,
	FOREIGN KEY (posto, settore, anello) REFERENCES posto(numero, settore, anello),
	FOREIGN KEY (stagione, partita) REFERENCES partita(stagione, numero)
);


/* ---------------- TRIGGER ---------------- */

/* trigger that runs ANALYZE (STATISTICS - PROFILE) every once in a while */

	/* trigger prezzo magari una funz*/
	/* trigger che controlla che chi compra è un passholder */
/* update e delete biglietto per reindirizzato sulle aprtizioni */
	/* trigger prezzo e ---check timestamp*/
	/* trigger che crea automaticamente la partizione di biglietti all'inserimento di una nuova stagione */
	/* trigger che inserisce il biglietto nella giusta partizione invece che nella tabella principale */


/* trigger che controlla che chi compra è un passholder */
CREATE OR REPLACE FUNCTION check_compratore_passholder() 
RETURNS TRIGGER AS $$
DECLARE
	tipo_compratore persona.tipo%TYPE;
BEGIN
	SELECT tipo INTO tipo_compratore
	FROM persona
	WHERE NEW.compratore = persona.cf;
	IF tipo_compratore <> 'PASSHOLDER' THEN
		RAISE NOTICE 'check_compratore_passholder il compratore non è un passholder';
		RAISE EXCEPTION foreign_key_violation;
	END IF;
	RETURN NEW;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER check_compratore_passholder_trigger
    BEFORE INSERT ON biglietto
    FOR EACH ROW
    EXECUTE PROCEDURE check_compratore_passholder();


/* ----------------------------------------------------- */


/* check if (stagione, partita) exists in partita table */
CREATE OR REPLACE FUNCTION check_partita_fk() 
RETURNS TRIGGER AS $$
DECLARE
	exists INTEGER;   /* partita.molt%type */
BEGIN
	SELECT COUNT(*)  INTO exists
	FROM partita
	WHERE partita.numero = NEW.partita AND partita.stagione = NEW.stagione;
	
	RAISE NOTICE 'i want to print check_partita_fk';
	IF exists <> 1 THEN
		RAISE EXCEPTION foreign_key_violation;
	END IF;
	RETURN NEW;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER check_partita_fk_trigger
    BEFORE INSERT ON biglietto
    FOR EACH ROW
    EXECUTE PROCEDURE check_partita_fk();


/* ----------------------------------------------------- */

/* check if (numero, settore, anello) exists in posto table */
CREATE OR REPLACE FUNCTION check_posto_fk() 
RETURNS TRIGGER AS $$
DECLARE
	exists INTEGER;   /* partita.molt%type */
BEGIN
	SELECT COUNT(*)  INTO exists
	FROM posto
	WHERE posto.numero = NEW.posto AND posto.settore = NEW.settore AND posto.anello = NEW.anello;
	
	RAISE NOTICE 'i want to print check_posto_fk';
	IF exists <> 1 THEN
		RAISE EXCEPTION foreign_key_violation;
	END IF;
	RETURN NEW;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER check_posto_fk_trigger
    BEFORE INSERT ON biglietto
    FOR EACH ROW
    EXECUTE PROCEDURE check_posto_fk();

/* ----------------------------------------------------- */


/* trigger che crea automaticamente la partizione di biglietti all'inserimento di una nuova stagione */
CREATE OR REPLACE FUNCTION create_partition_table() 
RETURNS TRIGGER AS $$
BEGIN
	EXECUTE format('CREATE TABLE IF NOT EXISTS biglietto_' || NEW.anno || '(
						CHECK ( stagione = ''' || NEW.anno || ''' )
					) INHERITS (biglietto);');
	RETURN NEW;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER create_partition_biglietto_trigger
    AFTER INSERT ON stagione
    FOR EACH ROW
    EXECUTE PROCEDURE create_partition_table();



/* ----------------------------------------------------- */




/* trigger prezzo e ---check timestamp*/
CREATE OR REPLACE FUNCTION calcola_prezzo()
RETURNS TRIGGER AS $$
DECLARE
	prezzo_posto NUMERIC(5,2);   /* partita.molt%type */
	molt_partita NUMERIC(3,2);
BEGIN
	SELECT prezzo INTO prezzo_posto
	FROM posto
	WHERE posto.numero = NEW.posto AND posto.settore = NEW.settore;

	SELECT molt INTO molt_partita
	FROM partita
	WHERE partita.stagione = NEW.stagione AND partita.numero = NEW.partita;

	NEW.prezzo_totale := prezzo_posto * molt_partita;
	RAISE NOTICE 'i want to print calcola_prezzo % and %', NEW.prezzo_totale, molt_partita;
	RETURN NEW;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER calcola_prezzo_trigger
    BEFORE INSERT ON biglietto
    FOR EACH ROW
    WHEN (NEW.prezzo_totale IS NULL)
    EXECUTE PROCEDURE calcola_prezzo();



/* ----------------------------------------------------- */



/* trigger che inserisce il biglietto nella giusta partizione invece che nella tabella principale */
CREATE OR REPLACE FUNCTION insert_biglietto()
RETURNS TRIGGER AS $$
DECLARE
    rowsAffected INTEGER := 0;
BEGIN
    EXECUTE format('INSERT INTO biglietto_' || NEW.stagione ||' VALUES ($1.*);') USING NEW;
    RAISE NOTICE 'i want to print insert_biglietto';
    GET DIAGNOSTICS rowsAffected = ROW_COUNT;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;


CREATE TRIGGER insert_biglietto_trigger
    BEFORE INSERT ON biglietto
    FOR EACH ROW EXECUTE PROCEDURE insert_biglietto();



CREATE OR REPLACE FUNCTION delete_from_master()
RETURNS trigger AS $$
BEGIN
	DELETE FROM ONLY biglietto;
	RETURN NULL;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER delete_from_master_trigger
    AFTER INSERT ON biglietto
    FOR EACH ROW EXECUTE PROCEDURE delete_from_master();

/* ----------------------------------------------------- */


/* trigger che calcolaprezzo posto che se è null(default) lo calcola da anello e settore*/
CREATE OR REPLACE FUNCTION prezzo_posto() 
RETURNS TRIGGER AS $$
DECLARE
	prezzo_settore NUMERIC(5,2);
	prezzo_anello  NUMERIC(5,2);
BEGIN
	SELECT prezzo_base INTO prezzo_settore
	FROM settore
	WHERE settore.id = NEW.settore;

	SELECT prezzo_base INTO prezzo_anello
	FROM anello
	WHERE anello.id = NEW.anello;

	NEW.prezzo := prezzo_settore + prezzo_anello;
	RETURN NEW;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER prezzo_posto_trigger
    BEFORE INSERT ON posto
    FOR EACH ROW
    WHEN (NEW.prezzo IS NULL)
    EXECUTE PROCEDURE prezzo_posto();




CREATE SEQUENCE hibernate_sequence START 1;
CREATE SEQUENCE my_seq_gen START 1;

/* ----------------------------------------------------- */





/* ---------------- QUERY ---------------- */
SELECT * FROM Stagione;


SELECT b.tableoid, b.id
FROM ONLY biglietto b;


SELECT molt
	FROM partita
	WHERE partita.stagione = '0001' AND partita.numero = 1;



SET constraint_exclusion = on;
EXPLAIN SELECT count(*) FROM biglietto WHERE stagione = '0001';

SET constraint_exclusion = off;
EXPLAIN SELECT count(*) FROM biglietto WHERE stagione = '0001';


/* INDEXES */

EXPLAIN SELECT * FROM posto ORDER BY numero, posto, anello;

EXPLAIN SELECT * FROM biglietto ORDER BY id;

EXPLAIN SELECT * FROM biglietto, persona WHERE biglietto.spettatore = persona.cf;


CREATE INDEX nome_index ON posto USING btree(numero, settore, anello);
CREATE INDEX nome_index2 ON persona USING hash(cf);

CREATE DATABASE ciao;
\c ciao
DROP DATABASE fixture12;
CREATE DATABASE fixture12;
\c fixture12
DROP DATABASE ciao;