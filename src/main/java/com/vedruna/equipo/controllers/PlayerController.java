package com.vedruna.equipo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.equipo.dto.PlayerDTO;
import com.vedruna.equipo.persistance.models.Player;
import com.vedruna.equipo.persistance.models.Team;
import com.vedruna.equipo.services.player.PlayerServiceI;

@RestController
@RequestMapping("api/v1/player")
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerServiceI playerService;

    //CHECK
    @GetMapping
    public List<PlayerDTO> getAllPlayer(){
        return playerService.showAllPlayer();
    }

    //CHECK
    @GetMapping("/getPlayersToTeam")
    public List<PlayerDTO> getPlayersToTeam(@RequestBody Team team){
        return playerService.findByIdTeam(team);
    }

    //CHECK
    @PostMapping("/addPlayer")
    public String addPlayer(@RequestBody Player player){
        playerService.addPlayer(player);
        return "Jugador añadido con exito!";
    }

    //CHECK
    @PutMapping("/editPlayer/{id}")
    public String editPlayer(@PathVariable Integer id, @RequestBody Team idTeam){
        playerService.addPlayerToTeam(id, idTeam.getId());
        return "Se ha asignado un equipo al jugador con exito";
    }

    //CHECK
    @DeleteMapping("/deletePlayer/{id}")
    public String deletePlayer(@PathVariable Integer id){
        playerService.deletePlayer(id);
        return "Jugador borrado con exito";
    }
}
