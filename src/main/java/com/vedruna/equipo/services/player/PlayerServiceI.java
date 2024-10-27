package com.vedruna.equipo.services.player;
import java.util.List;

import com.vedruna.equipo.dto.PlayerDTO;
import com.vedruna.equipo.persistance.models.Player;
import com.vedruna.equipo.persistance.models.Team;

public interface PlayerServiceI {

    //Aqui crearemos todos los metodos necesarios para manejar los siguientes datos de jugador:
    /*
    1. Consultar todos los jugadores (Debe verse solo el nombre del equipo, pero no el objeto equipo entero)
    2. Crear nuevo jugador
    3. Inscribir a un jugador en un equipo
    4. Borrar jugador (No debe borrarse su equipo)
    */

    //Función para consultar todos los jugadores
    List<PlayerDTO> showAllPlayer();

    //Función para crear un nuevo jugador
    void addPlayer(Player player);

    //Funcion para extraer todos los jugadores de un equipo
    List<PlayerDTO> findByIdTeam(Team team);

    //Funcion para asignarle un equipo a un jugador
    void addPlayerToTeam(Integer IdPlayer, Integer idTeam);

    //Funcion para borrar un jugador
    void deletePlayer(Integer id);
    
}
