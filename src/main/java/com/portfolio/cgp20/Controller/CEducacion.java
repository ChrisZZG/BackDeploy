
package com.portfolio.cgp20.Controller;

import com.portfolio.cgp20.Dto.dtoEducacion;
import com.portfolio.cgp20.Entity.Educacion;
import com.portfolio.cgp20.Security.SecurityController.Mensaje;
import com.portfolio.cgp20.Service.SEducacion;
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
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfoliocg-df90e.web.app")
public class CEducacion {
    
    @Autowired
    SEducacion sEducacion;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
        return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion Eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getTituloE())){
            return new ResponseEntity(new Mensaje("El Titulo es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByTituloE(dtoeducacion.getTituloE())){
            return new ResponseEntity(new Mensaje("Ese Titulo ya existe"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(dtoeducacion.getTituloE(),
                                            dtoeducacion.getInstitucionE(),
                                            dtoeducacion.getDescripcionE(),
                                             dtoeducacion.getUrlE());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion Creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,
                                    @RequestBody dtoEducacion dtoeducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existsByTituloE(dtoeducacion.getTituloE())&& sEducacion.getByTituloE(dtoeducacion.getTituloE()).get().getId()!=id){
            return new  ResponseEntity(new Mensaje("Ese Titulo ya Existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getTituloE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        
        educacion.setTituloE(dtoeducacion.getTituloE());
        educacion.setInstitucionE(dtoeducacion.getInstitucionE());
        educacion.setDescripcionE(dtoeducacion.getDescripcionE());
        educacion.setUrlE(dtoeducacion.getUrlE());
        
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion Actualizada"), HttpStatus.OK);
    }
}
