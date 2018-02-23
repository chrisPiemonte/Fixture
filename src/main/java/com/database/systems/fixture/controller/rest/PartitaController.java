package com.database.systems.fixture.controller.rest;

import com.database.systems.fixture.common.entity.Partita;
import com.database.systems.fixture.common.entity.composite.PartitaId;
import com.database.systems.fixture.service.serviceInterface.IPartitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chris on 2/21/18.
 */

@Controller
@RequestMapping("api")
public class PartitaController {

    @Autowired
    private IPartitaService partitaService;

    @GetMapping("partite")
    public ResponseEntity<List<Partita>> getAllPartite() {
        List<Partita> list = partitaService.getAllPartite();
        return new ResponseEntity<List<Partita>>(list, HttpStatus.OK);
    }

    @GetMapping("partita/{numero}/{stagione}")
    public ResponseEntity<Partita> getPartitaById(@PathVariable("numero") int numero,
                                                  @PathVariable("stagione") String stagione) {
        PartitaId partitaId = new PartitaId(numero, stagione);
        Partita partita = partitaService.getPartitaById(partitaId);
        return new ResponseEntity<Partita>(partita, HttpStatus.OK);
    }

    @PostMapping("partita")
    public ResponseEntity<Void> addPartita(@RequestBody Partita partita, UriComponentsBuilder builder) {
        boolean flag = partitaService.addPartita(partita);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> uriParams = new HashMap<String, String>();
        uriParams.put("numero", String.valueOf(partita.getNumeroAndStagione().getNumero()));
        uriParams.put("stagione", partita.getNumeroAndStagione().getStagione());
        headers.setLocation(builder.path("/partita/{numero}/{stagione}")
                .buildAndExpand(uriParams).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("partita")
    public ResponseEntity<Partita> updatePartita(@RequestBody Partita partita) {
        partitaService.updatePartita(partita);
        return new ResponseEntity<Partita>(partita, HttpStatus.OK);
    }

    @DeleteMapping("partita/{numero}/{stagione}")
    public ResponseEntity<Void> deletePartita(@PathVariable("numero") int numero,
                                              @PathVariable("stagione") String stagione) {
        PartitaId partitaId = new PartitaId(numero, stagione);
        partitaService.deletePartita(partitaId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
