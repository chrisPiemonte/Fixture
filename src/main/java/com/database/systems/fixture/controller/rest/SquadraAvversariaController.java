package com.database.systems.fixture.controller.rest;

import com.database.systems.fixture.common.entity.SquadraAvversaria;
import com.database.systems.fixture.service.serviceInterface.ISquadraAvversariaService;
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
public class SquadraAvversariaController {

    @Autowired
    private ISquadraAvversariaService squadraAvversariaService;

    @GetMapping("squadreavversarie")
    public ResponseEntity<List<SquadraAvversaria>> getAllSquadreAvversarie() {
        List<SquadraAvversaria> list = squadraAvversariaService.getAllSquadreAvversarie();
        return new ResponseEntity<List<SquadraAvversaria>>(list, HttpStatus.OK);
    }

    @GetMapping("squadraavversaria/{nome}")
    public ResponseEntity<SquadraAvversaria> getSquadraAvversariaById(@PathVariable("nome") String nome) {
        SquadraAvversaria squadraAvversaria = squadraAvversariaService.getSquadraAvversariaById(nome);
        return new ResponseEntity<SquadraAvversaria>(squadraAvversaria, HttpStatus.OK);
    }

    @PostMapping("squadraavversaria")
    public ResponseEntity<Void> addSquadraAvversaria(@RequestBody SquadraAvversaria squadraAvversaria,
                                                     UriComponentsBuilder builder) {
        boolean flag = squadraAvversariaService.addSquadraAvversaria(squadraAvversaria);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/squadraavversaria/{nome}")
                .buildAndExpand(squadraAvversaria.getNome()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("squadraavversaria")
    public ResponseEntity<SquadraAvversaria> updateSquadraAvversaria(@RequestBody SquadraAvversaria squadraAvversaria) {
        squadraAvversariaService.updateSquadraAvversaria(squadraAvversaria);
        return new ResponseEntity<SquadraAvversaria>(squadraAvversaria, HttpStatus.OK);
    }

    @DeleteMapping("squadraavversaria/{nome}")
    public ResponseEntity<Void> deleteSquadraAvversaria(@PathVariable("nome") String nome) {
        squadraAvversariaService.deleteSquadraAvversaria(nome);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
