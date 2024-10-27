package com.vedruna.equipo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.equipo.dto.TeamDTO;
import com.vedruna.equipo.persistance.models.Team;
import com.vedruna.equipo.services.team.TeamServiceI;

@RestController
@RequestMapping("api/v1/team")
@CrossOrigin
public class TeamController {
    
    @Autowired
    TeamServiceI teamService;

    @GetMapping
    public List<TeamDTO> showAllTeam(){
        return teamService.showAllTeam();
    }

    @GetMapping("/{id}")
    public TeamDTO showTeamById(@PathVariable Integer id){
        return teamService.showTeamById(id);
    }

    @PostMapping("/addTeam")
    public String addTeam(@RequestBody Team team){
        teamService.addTeam(team);
        return "Equipo añadido con exito";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Integer id){
        teamService.deleteTeam(id);
        return "Equipo borrado con exito";
    }
}
