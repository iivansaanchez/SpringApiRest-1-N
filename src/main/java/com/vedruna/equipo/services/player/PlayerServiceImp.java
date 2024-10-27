package com.vedruna.equipo.services.player;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.equipo.dto.PlayerDTO;
import com.vedruna.equipo.persistance.models.Player;
import com.vedruna.equipo.persistance.models.Team;
import com.vedruna.equipo.persistance.repository.PlayerRepository;
import com.vedruna.equipo.persistance.repository.TeamRepository;

@Service
public class PlayerServiceImp implements PlayerServiceI{

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Override
    public List<PlayerDTO> showAllPlayer() {
        List<Player> listPlayers = playerRepository.findAll();
        List<PlayerDTO> listPlayerDTOs = new ArrayList<>();
        for(Player player : listPlayers){
            if(player.getTeam() == null){
                PlayerDTO playerDTO = new PlayerDTO(player.getPlayerName(), player.getAge());
                listPlayerDTOs.add(playerDTO);
            }else{
                PlayerDTO playerDTO = new PlayerDTO(player.getPlayerName(), player.getAge(),player.getTeam().getTeamName());
                listPlayerDTOs.add(playerDTO);
            }
        }
        return listPlayerDTOs;
    }

    @Override
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void addPlayerToTeam(Integer idPlayer, Integer idTeam) {
        Player player = playerRepository.findById(idPlayer).orElse(null);
        Team team = teamRepository.findById(idTeam).orElse(null);
        if(player!=null){
            player.setTeam(team);
            playerRepository.save(player);
        }
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<PlayerDTO> findByIdTeam(Team team) {
        //Rescatamos la lista de jugadores de ese equipo
        List<Player> listPlayers = playerRepository.findByTeam(team);
        //Una vez que la tenemos creamos una lista de PlayersDTO
        List<PlayerDTO> listPlayerDTOs = new ArrayList<>();
        //Recorremos el array de players
        for(Player player : listPlayers){
            //Creamos un DTO por cada player
            PlayerDTO playerDTO = new PlayerDTO(player.getPlayerName(), player.getAge(),player.getTeam().getTeamName());
            //Lo añadimos al array DTO
            listPlayerDTOs.add(playerDTO);
        }
        return listPlayerDTOs;
    }

    
}
