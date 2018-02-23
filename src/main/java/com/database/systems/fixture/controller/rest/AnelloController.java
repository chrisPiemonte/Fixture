package com.database.systems.fixture.controller.rest;

import com.database.systems.fixture.common.entity.Anello;
import com.database.systems.fixture.service.serviceInterface.IAnelloService;
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
public class AnelloController {

    @Autowired
    private IAnelloService anelloService;

    @GetMapping("anelli")
    public ResponseEntity<List<Anello>> getAllAnelli() {
        List<Anello> list = anelloService.getAllAnelli();
        return new ResponseEntity<List<Anello>>(list, HttpStatus.OK);
    }

    @GetMapping("anello/{id}")
    public ResponseEntity<Anello> getAnelloById(@PathVariable("id") String id) {
        Anello anello = anelloService.getAnelloById(id);
        return new ResponseEntity<Anello>(anello, HttpStatus.OK);
    }

    @PostMapping("anello")
    public ResponseEntity<Void> addAnello(@RequestBody Anello anello, UriComponentsBuilder builder) {
        boolean flag = anelloService.addAnello(anello);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/anello/{id}").buildAndExpand(anello.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("anello")
    public ResponseEntity<Anello> updateAnello(@RequestBody Anello anello) {
        anelloService.updateAnello(anello);
        return new ResponseEntity<Anello>(anello, HttpStatus.OK);
    }

    @DeleteMapping("anello/{id}")
    public ResponseEntity<Void> deleteAnello(@PathVariable("id") String id) {
        anelloService.deleteAnello(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
