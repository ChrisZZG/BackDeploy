/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.cgp20.Service;

import com.portfolio.cgp20.Entity.Educacion;
import com.portfolio.cgp20.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    
    @Autowired
    IEducacionRepository iEducacionRepository;
    
    public List<Educacion> list(){
        return iEducacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return iEducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByTituloE(String tituloE){
        return iEducacionRepository.findByTituloE(tituloE);
    }
    
    public void save(Educacion educacion){
        iEducacionRepository.save(educacion);
    }
    
    public void delete(int id){
        iEducacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iEducacionRepository.existsById(id);
    }
    
    public boolean existsByTituloE(String tituloE){
        return iEducacionRepository.existsByTituloE(tituloE);
    }
}
