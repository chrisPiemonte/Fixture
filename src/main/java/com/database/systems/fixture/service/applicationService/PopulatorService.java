package com.database.systems.fixture.service.applicationService;

import com.database.systems.fixture.common.entity.*;
import com.database.systems.fixture.common.entity.composite.PartitaId;
import com.database.systems.fixture.common.entity.composite.PostoId;
import com.database.systems.fixture.common.entity.util.Analytics;
import com.database.systems.fixture.repository.repositoryInterface.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static com.database.systems.fixture.service.applicationService.Utilities.*;

/**
 * Created by chris on 2/22/18.
 */

@Service
public class PopulatorService {

    @Autowired
    private IAnelloRepository anelloRepository;
    @Autowired
    private IBigliettoRepository bigliettoRepository;
    @Autowired
    private IPartitaRepository partitaRepository;
    @Autowired
    private IPersonaRepository personaRepository;
    @Autowired
    private IPostoRepository postoRepository;
    @Autowired
    private ISettoreRepository settoreRepository;
    @Autowired
    private ISquadraAvversariaRepository squadraAvversariaRepository;
    @Autowired
    private IStagioneRepository stagioneRepository;

    private List<Persona> persone = new LinkedList<Persona>();
    private List<Persona> passholders = new LinkedList<Persona>();
    private List<Posto> posti = new LinkedList<Posto>();
    private List<Partita> partite = new LinkedList<Partita>();

    public void populateAnello() {
        Arrays.stream(Utilities.anelli).forEach(anl ->
                anelloRepository.addAnello(anl));

    }

    public void populateBiglietto() {
        ObjectMapper mapper = new ObjectMapper();
        partite.forEach(prt -> {
            Arrays.stream(Utilities.settori).forEach(str -> {
                Arrays.stream(Utilities.anelli).forEach(anl -> {
                    IntStream.range(1, Utilities.getRandomNumber(4)).forEach(num -> {
                        Biglietto bglt = new Biglietto(
                                Utilities.getRandomTimestamp(),
                                prt.getNumeroAndStagione().getStagione(),
                                prt.getNumeroAndStagione().getNumero(),
                                num,
                                str.getId(),
                                anl.getId(),
                                persone.get(getRandomIndex(persone.size())).getCf(),
                                passholders.get(getRandomIndex(passholders.size())).getCf()
                        );
                        Biglietto insBiglietto = bigliettoRepository.addBiglietto(bglt);
                        try {
                            Analytics.sendJson(mapper.writeValueAsString(insBiglietto));
                        } catch (Exception e) { e.printStackTrace(); }
                    });
                });
            });
        });
    }

    public void populatePartita() {
        Arrays.stream(Utilities.stagioni).forEach(stg -> {
            IntStream.range(1, 20).forEach(
                    num -> {
                        Partita prt = new Partita(
                                new PartitaId(num, stg.getAnno()),
                                Utilities.getRandomDate(2000, 1, 1),
                                1.0,
                                Utilities.squadre[getRandomIndex(Utilities.squadre.length)].getNome()
                        );
                        partite.add(prt);
                        partitaRepository.addPartita(prt);
                    });
        });
    }

    public void populatePersona() {
        Utilities.readNames();
        Utilities.readSurnames();
        IntStream.range(1, 700).forEach(
                num -> {
                    Persona prs = new Persona(
                            getRandomCf(), "SPETTATORE", Utilities.getRandomName(), Utilities.getRandomSurname(),
                            Utilities.getRandomDate(1900, 1, 1), Utilities.getRandomCitta(), "0881001122"
                    );
                    persone.add(prs);
                    personaRepository.addPersona(prs);
                });

        IntStream.range(1, 700).forEach(
                num -> {
                    Persona prs = new Persona(
                            getRandomCf(), "PASSHOLDER", Utilities.getRandomName(), Utilities.getRandomSurname(),
                            Utilities.getRandomDate(1900, 1, 1), Utilities.getRandomCitta(), "0881001122"
                    );
                    passholders.add(prs);
                    personaRepository.addPersona(prs);
                });
    }

    public void populatePosto() {
        Arrays.stream(Utilities.settori).forEach(str ->
                Arrays.stream(Utilities.anelli).forEach(anl -> {
                    IntStream.range(1, 200).forEach(
                            num -> {
                                Posto pst = new Posto(
                                        new PostoId(num, str.getId(), anl.getId()),
                                        "NORMALE"
                                );
                                posti.add(pst);
                                postoRepository.addPosto(pst);
                            }
                    );
                })
        );

    }

    public void populateSettore() {
        Arrays.stream(Utilities.settori).forEach(str ->
                settoreRepository.addSettore(str));
    }

    public void populateSquadraAvversaria() {
        Arrays.stream(Utilities.squadre).forEach(sqdr ->
                squadraAvversariaRepository.addSquadraAvversaria(sqdr));
    }

    public void populateStagione() {
        Arrays.stream(Utilities.stagioni).forEach(stg ->
                stagioneRepository.addStagione(stg));
    }
}
