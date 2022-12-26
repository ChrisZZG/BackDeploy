
package com.portfolio.cgp20.Repository;

import com.portfolio.cgp20.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
    
    //Puede existir o no la persona
    public Optional<Persona> findByNombre(String nombre);
    
    //Boleano para ver si existe la persona
    public boolean existsByNombre(String nombre);
}
