package com.database.systems.fixture.controller.rest;

import com.database.systems.fixture.common.entity.Settore;
import com.database.systems.fixture.service.serviceInterface.ISettoreService;
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
public class SettoreController {

    @Autowired
    private ISettoreService settoreService;

    @GetMapping("settori")
    public ResponseEntity<List<Settore>> getAllSettori() {
        List<Settore> list = settoreService.getAllSettori();
        return new ResponseEntity<List<Settore>>(list, HttpStatus.OK);
    }

    @GetMapping("settore/{id}")
    public ResponseEntity<Settore> getSettoreById(@PathVariable("id") String id) {
        Settore settore = settoreService.getSettoreById(id);
        return new ResponseEntity<Settore>(settore, HttpStatus.OK);
    }

    @PostMapping("settore")
    public ResponseEntity<Void> addSettore(@RequestBody Settore settore, UriComponentsBuilder builder) {
        boolean flag = settoreService.addSettore(settore);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/settore/{id}").buildAndExpand(settore.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("settore")
    public ResponseEntity<Settore> updateSettore(@RequestBody Settore settore) {
        settoreService.updateSettore(settore);
        return new ResponseEntity<Settore>(settore, HttpStatus.OK);
    }

    @DeleteMapping("settore/{id}")
    public ResponseEntity<Void> deleteSettore(@PathVariable("id") String id) {
        settoreService.deleteSettore(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
