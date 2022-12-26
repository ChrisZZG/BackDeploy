
package com.portfolio.cgp20.Service;

import com.portfolio.cgp20.Entity.HyS;
import com.portfolio.cgp20.Repository.IRepoHyS;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHyS {
    
    @Autowired
    IRepoHyS iRepoHyS;
    
    public List<HyS> list(){
        return iRepoHyS.findAll();
    }
    
    public Optional<HyS> getOne(int id){
        return iRepoHyS.findById(id);
    }
    
    public Optional<HyS> getByNombre(String nombre){
        return iRepoHyS.findByNombre(nombre);
    }
    
    public void save(HyS skill){
        iRepoHyS.save(skill);
    }
    
    public void delete(int id){
        iRepoHyS.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iRepoHyS.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iRepoHyS.existsByNombre(nombre);
    }
}
