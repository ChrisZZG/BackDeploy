
package com.portfolio.cgp20.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHyS {
    
    @NotBlank
    private String nombre;

    public dtoHyS() {
    }

    public dtoHyS(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
