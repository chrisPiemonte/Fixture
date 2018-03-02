package com.database.systems.fixture.controller.rest;

import com.database.systems.fixture.common.entity.Biglietto;
import com.database.systems.fixture.common.entity.util.Analytics;
import com.database.systems.fixture.service.serviceInterface.IBigliettoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Controller
@RequestMapping("api")
public class BigliettoController {

    @Autowired
    private IBigliettoService bigliettoService;

    @GetMapping("biglietti")
    public ResponseEntity<List<Biglietto>> getAllBiglietti() {
        List<Biglietto> list = bigliettoService.getAllBiglietti();
        return new ResponseEntity<List<Biglietto>>(list, HttpStatus.OK);
    }

    @GetMapping("biglietto/{id}")
    public ResponseEntity<Biglietto> getBigliettoById(@PathVariable("id") int id) {
        Biglietto biglietto = bigliettoService.getBigliettoById(id);
        return new ResponseEntity<Biglietto>(biglietto, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("biglietto")
    public ResponseEntity<Biglietto> addBiglietto(@RequestBody Biglietto biglietto, UriComponentsBuilder builder) {
        ObjectMapper mapper = new ObjectMapper();
        String logstashURL = "http://logstash:31311";
        biglietto.setOraAcquisto(new Timestamp(System.currentTimeMillis()));
        Biglietto insBiglietto = bigliettoService.addBiglietto(biglietto);

        try {
            Analytics.sendJson(mapper.writeValueAsString(insBiglietto));
        }catch(Exception e){ e.printStackTrace(); }
        return new ResponseEntity<Biglietto>(insBiglietto, HttpStatus.OK);
    }

    @PutMapping("biglietto")
    public ResponseEntity<Biglietto> updateBiglietto(@RequestBody Biglietto biglietto) {
        bigliettoService.updateBiglietto(biglietto);
        return new ResponseEntity<Biglietto>(biglietto, HttpStatus.OK);
    }

    @DeleteMapping("biglietto/{id}")
    public ResponseEntity<Void> deleteBiglietto(@PathVariable("id") int id) {
        bigliettoService.deleteBiglietto(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
