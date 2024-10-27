package com.vedruna.equipo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private String name;
    private Integer age;
    private String teamName;

    public PlayerDTO(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
