package com.edilson.cliqueoficina.wscliqueoficina.entity;

import com.edilson.cliqueoficina.wscliqueoficina.util.Propriedades;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table( name = Propriedades.TABELA_TELEFONES_CLIENTES )
public class TelefonesClientes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "tec_id" )
    private Integer id;

    @Column( name = "tec_ddd", nullable = false )
    private String ddd;

    @Column( name = "tec_telefone", nullable = false )
    private String telefone;

    @Column( name = "tec_is_residencial", nullable = false )
    private Boolean is_residencial;

    @Column( name = "tec_id_cliente", nullable = false )
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY )
    private Integer id_cliente;

    public TelefonesClientes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getIs_residencial() {
        return is_residencial;
    }

    public void setIs_residencial(Boolean is_residencial) {
        this.is_residencial = is_residencial;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Telefone: " +
                "  id = " + id +
                ", telefone = (" + ddd + ") " + telefone +
                ", is_residencial = " + is_residencial +
                ", id_cliente = " + id_cliente;
    }
}