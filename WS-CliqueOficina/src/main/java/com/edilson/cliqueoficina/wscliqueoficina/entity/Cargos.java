package com.edilson.cliqueoficina.wscliqueoficina.entity;

import com.edilson.cliqueoficina.wscliqueoficina.util.Propriedades;

import javax.persistence.*;

@Entity
@Table( name = Propriedades.TABELA_CARGOS )
public class Cargos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "cag_id" )
    private Integer id;

    @Column( name = "cag_nome", nullable = false )
    private String nome;

    public Cargos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cargo: id = " + id + ", nome = " + nome;
    }
}
