package com.portfolio.cgp20.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExperiencia {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String positionE;
    @NotBlank
    private String descriptionE;
    @NotBlank
    private String urlE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String positionE, String descriptionE, String urlE) {
        this.nombreE = nombreE;
        this.positionE = positionE;
        this.descriptionE = descriptionE;
        this.urlE = urlE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getPositionE() {
        return positionE;
    }

    public void setPositionE(String positionE) {
        this.positionE = positionE;
    }

    public String getDescriptionE() {
        return descriptionE;
    }

    public void setDescriptionE(String descriptionE) {
        this.descriptionE = descriptionE;
    }

    public String getUrlE() {
        return urlE;
    }

    public void setUrlE(String urlE) {
        this.urlE = urlE;
    }
    
    
}
