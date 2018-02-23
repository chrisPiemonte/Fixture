package com.database.systems.fixture.controller.rest;

import com.database.systems.fixture.common.entity.Posto;
import com.database.systems.fixture.common.entity.composite.PostoId;
import com.database.systems.fixture.service.serviceInterface.IPostoService;
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
public class PostoController {

    @Autowired
    private IPostoService postoService;

    @GetMapping("posti")
    public ResponseEntity<List<Posto>> getAllPosti() {
        List<Posto> list = postoService.getAllPosti();
        return new ResponseEntity<List<Posto>>(list, HttpStatus.OK);
    }

    @GetMapping("posto/{numero}/{settore}/{anello}")
    public ResponseEntity<Posto> getPostoById(@PathVariable("numero") int numero,
                                              @PathVariable("settore") String settore,
                                              @PathVariable("anello") String anello) {
        PostoId postoId = new PostoId(numero, settore, anello);
        Posto posto = postoService.getPostoById(postoId);
        return new ResponseEntity<Posto>(posto, HttpStatus.OK);
    }

    @PostMapping("posto")
    public ResponseEntity<Void> addPosto(@RequestBody Posto posto, UriComponentsBuilder builder) {
        boolean flag = postoService.addPosto(posto);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> uriParams = new HashMap<String, String>();
        uriParams.put("numero", String.valueOf(posto.getNumeroSettoreAnello().getNumero()));
        uriParams.put("settore", posto.getNumeroSettoreAnello().getSettore());
        uriParams.put("anello", posto.getNumeroSettoreAnello().getAnello());
        headers.setLocation(builder.path("/posto/{numero}/{settore}/{anello}")
                .buildAndExpand(uriParams).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("posto")
    public ResponseEntity<Posto> updatePosto(@RequestBody Posto posto) {
        postoService.updatePosto(posto);
        return new ResponseEntity<Posto>(posto, HttpStatus.OK);
    }

    @DeleteMapping("posto/{numero}/{settore}/{anello}")
    public ResponseEntity<Void> deletePosto(@PathVariable("numero") int numero,
                                            @PathVariable("settore") String settore,
                                            @PathVariable("anello") String anello) {
        PostoId postoId = new PostoId(numero, settore, anello);
        postoService.deletePosto(postoId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
