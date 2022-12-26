
package com.portfolio.cgp20.Repository;

import com.portfolio.cgp20.Entity.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoHabilidades extends JpaRepository<Habilidades, Integer>{
    
}
