package com.vedruna.equipo.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.equipo.persistance.models.Player;
import com.vedruna.equipo.persistance.models.Team;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
    //Metodo para obtener todos los jugadores de un equipo
    List<Player> findByTeam(Team team);
}
