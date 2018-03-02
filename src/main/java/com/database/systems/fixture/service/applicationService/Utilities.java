package com.database.systems.fixture.service.applicationService;

import com.database.systems.fixture.common.entity.Anello;
import com.database.systems.fixture.common.entity.Settore;
import com.database.systems.fixture.common.entity.SquadraAvversaria;
import com.database.systems.fixture.common.entity.Stagione;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * Created by chris on 2/22/18.
 */
public class Utilities {

    private static Random rnd = new Random();
    private static int counter = 0;
    private static final String alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static SecureRandom srnd = new SecureRandom();
    private static String pathNames = Paths.get(".", "src", "main", "resources", "misc", "population", "names.txt")
            .toAbsolutePath().normalize().toString();
    private static String pathSurnames = Paths.get(".","src","main","resources", "misc", "population", "surnames.txt")
            .toAbsolutePath().normalize().toString();
    private static List<String> names = new LinkedList<>();
    private static List<String> surnames = new LinkedList<>();


    protected static Stagione[] stagioni = {
            new Stagione("0001"), new Stagione("0102"), new Stagione("0203"), new Stagione("0304"),
            new Stagione("0405"), new Stagione("0506"), new Stagione("0607"), new Stagione("0708"),
            new Stagione("0809"), new Stagione("0910")};


    protected static  Anello[] anelli = {
            new Anello("001", "Primo inferiore", 4.00), new Anello("002", "Secondo inferiore", 5.00),
            new Anello("003", "Primo superiore", 6.00), new Anello("004", "Secondo superiore", 7.00),
            new Anello("005", "Terzo superiore", 8.00)};

    protected static  Settore[] settori = {
            new Settore("001", "Curva Nord Est", 10.00), new Settore("002", "Curva Nord Ovest", 10.00),
            new Settore("003", "Curva Sud Est", 10.00), new Settore("004", "Curva Sud Ovest", 10.00),
            new Settore("005", "Tribuna Est", 15.00), new Settore("006", "Tribuna Centro", 15.00),
            new Settore("007", "Tribuna Ovest", 15.00), new Settore("008", "Gradinata Est", 13.00),
            new Settore("009", "Gradinata Centro", 13.00), new Settore("010", "Gradinata Ovest", 13.00)};

    protected static  SquadraAvversaria[] squadre = {
            new SquadraAvversaria("Pisa", "Pisa"), new SquadraAvversaria("Foggia", "Foggia"),
            new SquadraAvversaria("Milan", "Milano"), new SquadraAvversaria("Inter", "Milano"),
            new SquadraAvversaria("Juventus", "Torino"), new SquadraAvversaria("Bologna", "Bologna"),
            new SquadraAvversaria("Hellas Verona", "Verona"), new SquadraAvversaria("Chievo Verona", "Verona"),
            new SquadraAvversaria("Torino", "Torino"), new SquadraAvversaria("Roma", "Roma"),
            new SquadraAvversaria("Lazio", "Roma"), new SquadraAvversaria("Genoa", "Genova"),
            new SquadraAvversaria("Napoli", "Napoli"), new SquadraAvversaria("Ancona", "Ancona"),
            new SquadraAvversaria("Fiorentina", "Firenze"), new SquadraAvversaria("Sampdoria", "Genova"),
            new SquadraAvversaria("Atalanta", "Bergamo"), new SquadraAvversaria("Udinese", "Udine"),
            new SquadraAvversaria("Brescia", "Brescia"), new SquadraAvversaria("Ternana", "Terni")};


    public static LocalDate getRandomDate(int year, int month, int day){
        long minDay = LocalDate.of(year, month, day).toEpochDay();
        long maxDay = LocalDate.of(2017, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public static int getRandomIndex(int i){
        return rnd.nextInt(i);
    }

    public static int getRandomNumber(int max){
        int min = 1;
        return rnd.nextInt(max - min + 1) + min;
    }

    public static String getRandomCf(){
        String c = String.valueOf(counter);
        int len = 16 - c.length();
        StringBuilder sb = new StringBuilder(len);
            for(int i = 0; i < len; i++ )
                sb.append(alphaNumeric.charAt(srnd.nextInt(alphaNumeric.length()) ) );

        counter++;
        return sb.toString() + c;
    }

    public static void readNames(){
        try (Stream<String> stream = Files.lines(Paths.get(pathNames))) {
            stream.forEach(names::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readSurnames(){
        try (Stream<String> stream = Files.lines(Paths.get(pathSurnames))) {
            stream.forEach(surnames::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRandomName(){
        return names.get(rnd.nextInt(names.size()));
    }

    public static String getRandomSurname(){
        return surnames.get(rnd.nextInt(surnames.size()));
    }

    public static String getRandomCitta(){
        return squadre[getRandomIndex(squadre.length)].getCitta();
    }

    public static Timestamp getRandomTimestamp(){
        long offset = Timestamp.valueOf("2000-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        return new Timestamp(offset + (long)(Math.random() * diff));
    }


    /*public static void main(String[] args){
        Timestamp n = Timestamp.valueOf("2000-01-01 00:00:00");
        System.out.println(n);

    }*/

}
