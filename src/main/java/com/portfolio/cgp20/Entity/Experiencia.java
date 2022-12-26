
package com.portfolio.cgp20.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String positionE;
    private String descriptionE;
    private String urlE;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String positionE, String descriptionE, String urlE) {
        this.nombreE = nombreE;
        this.positionE = positionE;
        this.descriptionE = descriptionE;
        this.urlE = urlE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
