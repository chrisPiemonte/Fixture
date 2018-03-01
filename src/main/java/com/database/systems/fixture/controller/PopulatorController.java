package com.database.systems.fixture.controller;

import com.database.systems.fixture.repository.repositoryInterface.IStagioneRepository;
import com.database.systems.fixture.service.applicationService.PopulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chris on 2/22/18.
 */

@Controller
@RequestMapping("api")
public class PopulatorController {

    @Autowired
    private PopulatorService populatorService;

    @Autowired
    private IStagioneRepository stagioneRepository;

    @GetMapping("populate")
    public String populate() {
        boolean alreadyPopulated = stagioneRepository.stagioneExists("0001");
        if (!alreadyPopulated) {
            populatorService.populateStagione();
            populatorService.populateSquadraAvversaria();
            populatorService.populatePartita();
            populatorService.populateSettore();
            populatorService.populateAnello();
            populatorService.populatePosto();
            populatorService.populatePersona();
            populatorService.populateBiglietto();
            // HttpHeaders headers = new HttpHeaders();
            return "Done";
        }
        return "Already populated";
    }
}
