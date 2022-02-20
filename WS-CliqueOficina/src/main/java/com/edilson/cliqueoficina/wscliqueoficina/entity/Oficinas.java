package com.edilson.cliqueoficina.wscliqueoficina.entity;

import com.edilson.cliqueoficina.wscliqueoficina.util.Propriedades;
import javax.persistence.*;

@Entity
@Table( name = Propriedades.TABELA_OFICINAS )
public class Oficinas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "ofc_id" )
    private Integer id;

    @Column( name = "ofc_razao_social", nullable = false )
    private String razao_social;

    @Column( name = "ofc_nome_fantasia", nullable = false )
    private String nome_fantasia;

    @Column( name = "ofc_cnpj", nullable = false )
    private String cnpj;

    @Column( name = "ofc_ie" )
    private String ie;

    @Column( name = "ofc_telefone_principal", nullable = false )
    private String telefone_principal;

    @Column( name = "ofc_telefone_secundario" )
    private String telefone_secundario;

    @Column( name = "ofc_cep", nullable = false )
    private String cep;

    @Column( name = "ofc_logradouro", nullable = false )
    private String logradouro;

    @Column( name = "ofc_numero", nullable = false )
    private String numero;

    @Column( name = "ofc_complemento" )
    private String complemento;

    @Column( name = "ofc_bairro", nullable = false )
    private String bairro;

    @Column( name = "ofc_cidade", nullable = false )
    private String cidade;

    @Column( name = "ofc_estado", nullable = false )
    private String estado;

    public Oficinas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getTelefone_principal() {
        return telefone_principal;
    }

    public void setTelefone_principal(String telefone_principal) {
        this.telefone_principal = telefone_principal;
    }

    public String getTelefone_secundario() {
        return telefone_secundario;
    }

    public void setTelefone_secundario(String telefone_secundario) {
        this.telefone_secundario = telefone_secundario;
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

    @Override
    public String toString() {
        return "Oficinas: " +
                "  id = " + id +
                ", razao_social = " + razao_social +
                ", nome_fantasia = " + nome_fantasia +
                ", cnpj = " + cnpj +
                ", ie = " + ie +
                ", telefone_principal = " + telefone_principal +
                ", telefone_secundario = " + telefone_secundario +
                ", cep = " + cep +
                ", logradouro = " + logradouro +
                ", numero = " + numero +
                ", complemento = " + complemento +
                ", bairro = " + bairro +
                ", cidade = " + cidade +
                ", estado = " + estado;
    }
}
