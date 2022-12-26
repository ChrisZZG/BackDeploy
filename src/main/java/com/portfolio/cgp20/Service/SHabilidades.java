
package com.portfolio.cgp20.Service;

import com.portfolio.cgp20.Entity.Habilidades;
import com.portfolio.cgp20.Repository.IRepoHabilidades;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidades {
    
    @Autowired
    IRepoHabilidades iRepoHabilidades;
    
    public List<Habilidades> list(){
        return iRepoHabilidades.findAll();
    }
    
    public Optional<Habilidades> getOne(int id){
        return iRepoHabilidades.findById(id);
    }
    
    public void save(Habilidades habilidad){
        iRepoHabilidades.save(habilidad);
    }
    
    public void delete(int id){
        iRepoHabilidades.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iRepoHabilidades.existsById(id);
    }
    
    
}
