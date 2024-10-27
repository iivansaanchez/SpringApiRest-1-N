package com.vedruna.equipo.services.team;
import java.util.List;

import com.vedruna.equipo.dto.TeamDTO;
import com.vedruna.equipo.persistance.models.Team;

public interface TeamServiceI {
    //Aqui haremos todos las funciones necesrias para manejar los equipos:
    /*
    1. Consultar todos los equipos (Deben verse sus jugadores)
    2. Consultar un solo equipo (Deben verse sus jugadores)
    3. Crear nuevo equipo
    4. Inscribir a un jugador en un equipo
    5. Borrar equipo (No deben borrarse sus jugadores)
    */

    //Función para obtener todos los equipos
    List<TeamDTO> showAllTeam();

    //Función para consultar un solo equipo
    TeamDTO showTeamById(Integer idTeam);

    //Función para crear un equipo
    void addTeam(Team team);

    //Función para borrar equipo completo
    void deleteTeam(Integer id);
}
