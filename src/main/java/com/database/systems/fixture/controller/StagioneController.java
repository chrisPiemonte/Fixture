package com.database.systems.fixture.controller;

import com.database.systems.fixture.common.entity.Stagione;
import com.database.systems.fixture.service.IStagioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Controller
@RequestMapping("/")
public class StagioneController {

    @Autowired
    private IStagioneService stagioneService;

    @GetMapping("articles")
    public ResponseEntity<List<Stagione>> getAllArticles() {
        List<Stagione> list = stagioneService.getAllStagioni();
        return new ResponseEntity<List<Stagione>>(list, HttpStatus.OK);
    }
}
