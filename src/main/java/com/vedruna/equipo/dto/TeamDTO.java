package com.vedruna.equipo.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {

    private String teamName;
    private List<PlayerDTO> listPlayers;

}
