package com.edilson.cliqueoficina.wscliqueoficina.entity;

import com.edilson.cliqueoficina.wscliqueoficina.util.Propriedades;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table( name = Propriedades.TABELA_USUARIOS )
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "usu_id" )
    private Integer id;

    @Column( name = "usu_nome", nullable = false )
    private String nome;

    @Column( name = "usu_sobrenome", nullable = false )
    private String sobrenome;

    @Column( name = "usu_email", nullable = false )
    private String email;

    @Column( name = "usu_senha", nullable = false )
    private String senha;

    @Column( name = "usu_id_cargo", nullable = false )
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY )
    private Integer id_cargo;

    @ManyToOne
    @JoinColumn( name = "usu_id_cargo", referencedColumnName = "cag_id", insertable = false, updatable = false )
    private Cargos cargo;

    public Usuarios() {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Integer id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        String tostring_cargo = cargo == null ? "Indefinido" : cargo.toString();

        return "Usuario: " +
                "  id = " + id +
                ", nome = " + nome +
                ", sobrenome = " + sobrenome +
                ", email = " + email +
                ", senha = " + senha +
                ", id_cargo = " + id_cargo +
                ", cargo = " + tostring_cargo;
    }
}
