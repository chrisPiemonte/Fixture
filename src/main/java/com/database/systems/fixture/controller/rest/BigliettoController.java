package com.database.systems.fixture.controller.rest;

import com.database.systems.fixture.common.entity.Biglietto;
import com.database.systems.fixture.common.entity.Partita;
import com.database.systems.fixture.service.serviceInterface.IBigliettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<HashMap> addBiglietto(@RequestBody Biglietto biglietto, UriComponentsBuilder builder) {
        HashMap<String, String> map = new HashMap<>();
        biglietto.setOraAcquisto(new Timestamp(System.currentTimeMillis()));
        boolean flag = bigliettoService.addBiglietto(biglietto);
        if (!flag) {
            map.put("key", "value");
            map.put("foo", "bar");
            map.put("aa", "bb");
            return new ResponseEntity<HashMap>(map, HttpStatus.OK);
        }
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/biglietto/{id}").buildAndExpand(biglietto.getId()).toUri());
        return new ResponseEntity<HashMap>(map, HttpStatus.OK);
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
