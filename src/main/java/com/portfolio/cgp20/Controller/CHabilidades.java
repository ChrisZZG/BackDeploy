
package com.portfolio.cgp20.Controller;

import com.portfolio.cgp20.Dto.dtoHabilidades;
import com.portfolio.cgp20.Entity.Habilidades;
import com.portfolio.cgp20.Security.SecurityController.Mensaje;
import com.portfolio.cgp20.Service.SHabilidades;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidades")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://portfoliocg-df90e.web.app")
public class CHabilidades {
    
    @Autowired
    SHabilidades sHabilidades;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list() {
        List<Habilidades> list = sHabilidades.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id) {
        if (!sHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Habilidades habilidad = sHabilidades.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        sHabilidades.delete(id);

        return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidades dtohabilidades) {
        if (StringUtils.isBlank(dtohabilidades.getLaborales())) {
            return new ResponseEntity(new Mensaje("El detalle es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Habilidades habilidad = new Habilidades(dtohabilidades.getLaborales(),dtohabilidades.getSociales());

        sHabilidades.save(habilidad);

        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidades dtohabilidades) {
        if (!sHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtohabilidades.getLaborales())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Habilidades habilidad = sHabilidades.getOne(id).get();
        habilidad.setLaborales(dtohabilidades.getLaborales());
        habilidad.setSociales(dtohabilidades.getSociales());

        sHabilidades.save(habilidad);

        return new ResponseEntity(new Mensaje("Habilidad Actualizada"), HttpStatus.OK);
    }

}
