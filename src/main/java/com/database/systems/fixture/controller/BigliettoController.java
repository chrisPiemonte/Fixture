package com.database.systems.fixture.controller;

import com.database.systems.fixture.common.entity.Biglietto;
import com.database.systems.fixture.service.serviceInterface.IBigliettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping("biglietto")
    public ResponseEntity<Void> addBiglietto(@RequestBody Biglietto biglietto, UriComponentsBuilder builder) {
        boolean flag = bigliettoService.addBiglietto(biglietto);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/biglietto/{id}").buildAndExpand(biglietto.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
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
