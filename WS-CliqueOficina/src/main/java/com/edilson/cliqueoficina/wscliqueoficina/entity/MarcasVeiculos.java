package com.edilson.cliqueoficina.wscliqueoficina.entity;

import com.edilson.cliqueoficina.wscliqueoficina.util.Propriedades;
import javax.persistence.*;

@Entity
@Table( name = Propriedades.TABELA_MARCAS_VEICULOS )
public class MarcasVeiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "mar_id" )
    private Integer id;

    @Column( name = "mar_nome", nullable = false )
    private String nome;

    @Column( name = "mar_url_logotipo" )
    private String url_logotipo;

    public MarcasVeiculos() {
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

    public String getUrl_logotipo() {
        return url_logotipo;
    }

    public void setUrl_logotipo(String url_logotipo) {
        this.url_logotipo = url_logotipo;
    }

    @Override
    public String toString() {
        return "MarcasVeiculos: " +
                "  id = " + id +
                ", nome = " + nome +
                ", url_logotipo = " + url_logotipo;
    }
}