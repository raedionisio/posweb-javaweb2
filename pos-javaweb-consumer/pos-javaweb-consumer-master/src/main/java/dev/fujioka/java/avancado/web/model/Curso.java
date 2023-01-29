package dev.fujioka.java.avancado.web.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Curso implements Serializable {

    private Integer id;

    private String nome;

    private String areaCurso;

}