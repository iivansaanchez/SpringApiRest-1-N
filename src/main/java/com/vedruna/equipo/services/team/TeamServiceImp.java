package com.vedruna.equipo.services.team;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.equipo.dto.PlayerDTO;
import com.vedruna.equipo.dto.TeamDTO;
import com.vedruna.equipo.persistance.models.Player;
import com.vedruna.equipo.persistance.models.Team;
import com.vedruna.equipo.persistance.repository.PlayerRepository;
import com.vedruna.equipo.persistance.repository.TeamRepository;
import com.vedruna.equipo.services.player.PlayerServiceI;

@Service
public class TeamServiceImp implements TeamServiceI{

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerServiceI playerService;

    @Override
    public List<TeamDTO> showAllTeam() {
        //Rescatamos todos los equipos
        List<Team> listTeam = teamRepository.findAll();
        //Creamos una lista de TeamDTO
        List<TeamDTO> listTeamDTOs = new ArrayList<>();

        //Recorremos el array de equipos
        for(Team team: listTeam){
            //Por cada equipo rescatamos sus jugadores
            List<PlayerDTO> listPlayerDTO = playerService.findByIdTeam(team);
            //Ahora creamos el TeamDTO
            TeamDTO teamDTO = new TeamDTO(team.getTeamName(), listPlayerDTO);
            //Lo añadimos al array
            listTeamDTOs.add(teamDTO);
        }
        return listTeamDTOs;
    }

    @Override
    public TeamDTO showTeamById(Integer idTeam) {
        //Creamos una lista vacia para los DTO
        List<PlayerDTO> listPlayersDTO = new ArrayList<>();;
        //Rescatamos el equipo por su id
        Team team = teamRepository.findById(idTeam).orElse(null);
        //Una vez rescatado el equipo rescatamos los jugadores
        List<Player> listPlayers = playerRepository.findByTeam(team);
        //Recorremos la lista para ir creando los DTO
        for(Player player : listPlayers){
            if(player.getTeam() == null){
                PlayerDTO playerDTO = new PlayerDTO(player.getPlayerName(), player.getAge());
                listPlayersDTO.add(playerDTO);
            }else{
                PlayerDTO playerDTO = new PlayerDTO(player.getPlayerName(), player.getAge(),player.getTeam().getTeamName());
                listPlayersDTO.add(playerDTO);
            }
        }
        //Tenemos el equipo y la lista de jugadores de ese equipo ahora creamos el DTO para devolverlo
        TeamDTO teamDTO = new TeamDTO();
        if(team != null){
            teamDTO.setTeamName(team.getTeamName());
            teamDTO.setListPlayers(listPlayersDTO);
        }

        return teamDTO;
    }

    @Override
    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }
    
}
