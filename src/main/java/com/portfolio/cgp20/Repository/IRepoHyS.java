
package com.portfolio.cgp20.Repository;

import com.portfolio.cgp20.Entity.HyS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoHyS extends JpaRepository<HyS, Integer>{
    
    public Optional<HyS> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
}
