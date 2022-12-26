
package com.portfolio.cgp20.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habilidades {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String laborales;
    private String sociales;

    public Habilidades() {
    }

    public Habilidades(String laborales, String sociales) {
        this.laborales = laborales;
        this.sociales = sociales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
