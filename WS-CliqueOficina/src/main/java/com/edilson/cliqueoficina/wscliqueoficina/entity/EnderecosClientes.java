package com.edilson.cliqueoficina.wscliqueoficina.entity;

import com.edilson.cliqueoficina.wscliqueoficina.util.Propriedades;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table( name = Propriedades.TABELA_ENDERECOS_CLIENTES )
public class EnderecosClientes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "enc_id" )
    private Integer id;

    @Column( name = "enc_cep", nullable = false )
    private String cep;

    @Column( name = "enc_logradouro", nullable = false )
    private String logradouro;

    @Column( name = "enc_numero", nullable = false )
    private String numero;

    @Column( name = "enc_complemento" )
    private String complemento;

    @Column( name = "enc_bairro", nullable = false )
    private String bairro;

    @Column( name = "enc_cidade", nullable = false )
    private String cidade;

    @Column( name = "enc_estado", nullable = false )
    private String estado;

    @Column( name = "enc_id_cliente", nullable = false )
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY )
    private Integer id_cliente;

    public EnderecosClientes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Endereco: " +
                "  id = " + id +
                ", cep = " + cep +
                ", logradouro = " + logradouro +
                ", numero = " + numero +
                ", complemento = " + complemento +
                ", bairro = " + bairro +
                ", cidade = " + cidade +
                ", estado = " + estado +
                ", id_cliente = " + id_cliente;
    }
}