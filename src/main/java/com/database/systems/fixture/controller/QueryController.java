package com.database.systems.fixture.controller;

import com.database.systems.fixture.common.entity.Persona;
import com.database.systems.fixture.common.entity.bean.Stats;
import com.database.systems.fixture.service.applicationService.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by chris on 2/23/18.
 */

@Controller
@RequestMapping("api")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @GetMapping("esiste/{partita}/{stagione}/{posto}/{anello}/{settore}")
    public ResponseEntity<Boolean> isPostoOccupato(@PathVariable("stagione") String stagione,
                                                   @PathVariable("partita") int partita,
                                                   @PathVariable("settore") String settore,
                                                   @PathVariable("anello") String anello,
                                                   @PathVariable("posto") int posto) {

        boolean exists = queryService.isPostoOccupato(partita, stagione, posto, settore, anello);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
    }

    @GetMapping("presenze/{partita}/{stagione}/{settore}")
    public ResponseEntity<List<Persona>> getPersoneFromPartitaSettore(@PathVariable("partita") int partita,
                                                                      @PathVariable("stagione") String stagione,
                                                                      @PathVariable("settore") String settore) {
        List<Persona> list = queryService.getPersoneFromPartitaSettore(partita, settore, stagione);
        return new ResponseEntity<List<Persona>>(list, HttpStatus.OK);
    }

    @GetMapping("stats/{stagione}")
    public ResponseEntity<List<Stats>> getStatsStagione(@PathVariable("stagione") String stagione) {
        List<Stats> list = queryService.getStatsStagione(stagione);
        return new ResponseEntity<List<Stats>>(list, HttpStatus.OK);
    }



}
