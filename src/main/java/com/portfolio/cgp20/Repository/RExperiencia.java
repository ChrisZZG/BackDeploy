
package com.portfolio.cgp20.Repository;

import com.portfolio.cgp20.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    
    public Optional<Experiencia> findByNombreE(String nombreE);
    
    public boolean existsByNombreE(String nombreE);
}
