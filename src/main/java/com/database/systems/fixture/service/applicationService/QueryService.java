package com.database.systems.fixture.service.applicationService;

import com.database.systems.fixture.common.entity.Biglietto;
import com.database.systems.fixture.common.entity.Persona;
import com.database.systems.fixture.common.entity.bean.Stats;
import com.database.systems.fixture.repository.query.BigliettoQueryRepository;
import com.database.systems.fixture.repository.query.GenericQueryRepository;
import com.database.systems.fixture.repository.query.PersonaQueryRepository;
import com.database.systems.fixture.repository.query.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by chris on 2/23/18.
 */

@Service
public class QueryService {

    @Autowired
    private BigliettoQueryRepository bigliettoqueryRepository;
    @Autowired
    private PersonaQueryRepository personaQueryRepository;
    @Autowired
    private QueryRepository queryRepository;

    public boolean isPostoOccupato(int partita, String stagione, int posto, String settore, String anello) {
        List<Biglietto> l = bigliettoqueryRepository.isPostoOccupato(partita, stagione, posto, settore, anello);
        return l.size() > 0;
    }

    public List<Persona> getPersoneFromPartitaSettore(int partita, String settore, String stagione) {
        List<Persona> persone = personaQueryRepository.getPersoneFromPartitaSettore(partita, settore, stagione);
        return persone;
    }

    public List<Stats> getStatsStagione(String stagione) {
        return queryRepository.getStatsStagione(stagione);
    }
}
