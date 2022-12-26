package com.portfolio.cgp20.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHabilidades {

    @NotBlank
    private String laborales;
    @NotBlank
    private String sociales;

    public dtoHabilidades() {
    }

    public dtoHabilidades(String laborales, String sociales) {
        this.laborales = laborales;
        this.sociales = sociales;
    }

    public String getLaborales() {
        return laborales;
    }

    public void setLaborales(String laborales) {
        this.laborales = laborales;
    }

    public String getSociales() {
        return sociales;
    }

    public void setSociales(String sociales) {
        this.sociales = sociales;
    }
    
    
}
