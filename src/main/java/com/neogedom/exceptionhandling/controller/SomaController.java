package com.neogedom.exceptionhandling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.neogedom.exceptionhandling.model.Soma;

@RestController
@RequestMapping("/sum")
public class SomaController {
    @GetMapping(value = "/{num1}/{num2}")
    public Float getResultado(@PathVariable String num1, @PathVariable String num2){
        
        try  {
            var numb1=Float.parseFloat(num1);
            var numb2=Float.parseFloat(num2);
            Soma soma = new Soma(numb1, numb2);
            
            return soma.getResultado();
        } catch(NumberFormatException e) {
             throw new NumberFormatException("Não é permitido letra na url!");
             
         }
    }
    
}
