package com.database.systems.fixture.controller.rest;

import com.database.systems.fixture.common.entity.Stagione;
import com.database.systems.fixture.service.serviceInterface.IStagioneService;
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
public class StagioneController {

    @Autowired
    private IStagioneService stagioneService;

    @GetMapping("stagioni")
    public ResponseEntity<List<Stagione>> getAllStagioni() {
        List<Stagione> list = stagioneService.getAllStagioni();
        return new ResponseEntity<List<Stagione>>(list, HttpStatus.OK);
    }

    @GetMapping("stagione/{anno}")
    public ResponseEntity<Stagione> getStagioneById(@PathVariable("anno") String anno) {
        Stagione stagione = stagioneService.getStagioneById(anno);
        return new ResponseEntity<Stagione>(stagione, HttpStatus.OK);
    }

    @PostMapping("stagione")
    public ResponseEntity<Void> addStagione(@RequestBody Stagione stagione, UriComponentsBuilder builder) {
        boolean flag = stagioneService.addStagione(stagione);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/stagione/{anno}").buildAndExpand(stagione.getAnno()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("stagione")
    public ResponseEntity<Stagione> updateStagione(@RequestBody Stagione stagione) {
        stagioneService.updateStagione(stagione);
        return new ResponseEntity<Stagione>(stagione, HttpStatus.OK);
    }

    @DeleteMapping("stagione/{anno}")
    public ResponseEntity<Void> deleteStagione(@PathVariable("anno") String anno) {
        stagioneService.deleteStagione(anno);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
