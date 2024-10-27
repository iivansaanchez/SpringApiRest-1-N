package com.vedruna.equipo.persistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="jugadores")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idjugador")
    private Integer id;

    @Column(name="nombre")
    private String playerName;

    @Column(name="edad")
    private Integer age;

    @ManyToOne
    @JoinColumn(name="equipos_idequipo", nullable = true)
    private Team team;
}
