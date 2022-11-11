package com.neogedom.exceptionhandling.model;

import lombok.Data;

@Data
public class Soma {
    
    private Float resultado;
    
    public  Soma(Float num1, Float num2) {
        this.resultado = num1 + num2;
    }
 
    public Float getResultado() {
        return resultado;
        
    }   
}
