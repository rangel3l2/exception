package com.neogedom.exceptionhandling.controller;

import com.neogedom.exceptionhandling.exception.InvalidCharacterException;
import com.neogedom.exceptionhandling.model.OlaMundo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olamundo")
public class OlaMundoController {

    @GetMapping(value = "/{name}")
    public String getOlaMundo(@PathVariable String name){
        if (!name.chars().anyMatch(Character::isDigit)) {
            var olaMundo = new OlaMundo(name);
            return olaMundo.getSaudacao();
        } else {
            throw new InvalidCharacterException("Não é permitido números no nome!");
        }
    }
}
