
package com.portfolio.cgp20.Repository;

import com.portfolio.cgp20.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer>{
    
    public Optional<Educacion> findByTituloE(String tituloE);
    
    public boolean existsByTituloE(String tituloE);
}
