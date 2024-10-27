package com.vedruna.equipo.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.equipo.persistance.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
    
}
