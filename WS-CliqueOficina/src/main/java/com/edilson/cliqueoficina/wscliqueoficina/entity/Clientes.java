package com.edilson.cliqueoficina.wscliqueoficina.entity;

import com.edilson.cliqueoficina.wscliqueoficina.util.Propriedades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = Propriedades.TABELA_CLIENTES )
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "cli_id" )
    private Integer id;

    @Column( name = "cli_nome", nullable = false )
    private String nome;

    @Column( name = "cli_sobrenome", nullable = false )
    private String sobrenome;

    @Column( name = "cli_cpf" )
    private String cpf;

    @Column( name = "cli_rg" )
    private String rg;

    @Column( name = "cli_cnpj" )
    private String cnpj;

    @Column( name = "cli_ie" )
    private String ie;

    @Column( name = "cli_email", nullable = false )
    private String email;

    @OneToMany( mappedBy = "id_cliente" )
    private List< TelefonesClientes > telefones;

    @OneToMany( mappedBy = "id_cliente" )
    private List< EnderecosClientes > enderecos;

    @OneToMany( mappedBy = "id_cliente" )
    private List< VeiculosClientes > veiculos;

    public Clientes() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TelefonesClientes> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefonesClientes> telefones) {
        this.telefones = telefones;
    }

    public List<EnderecosClientes> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecosClientes> enderecos) {
        this.enderecos = enderecos;
    }

    public List<VeiculosClientes> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<VeiculosClientes> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        StringBuilder tostring_telefones = new StringBuilder( "Cliente sem telefones" );
        if ( telefones != null ) {
            for ( TelefonesClientes telefone : telefones )
                tostring_telefones.append( telefone.toString() ).append( ", " );
        }

        StringBuilder tostring_enderecos = new StringBuilder( "Cliente sem enderços" );
        if ( telefones != null ) {
            for ( EnderecosClientes endereco : enderecos )
                tostring_enderecos.append( endereco.toString() ).append( ", " );
        }

        StringBuilder tostring_veiculos_clientes = new StringBuilder( "Cliente sem veículos" );
        if ( telefones != null ) {
            for ( VeiculosClientes veiculo : veiculos )
                tostring_veiculos_clientes.append( veiculo.toString() ).append( ", " );
        }

        return "Clientes: " +
                "  id = " + id +
                ", nome = " + nome +
                ", sobrenome = " + sobrenome +
                ", cpf = " + cpf +
                ", rg = " + rg +
                ", cnpj = " + cnpj +
                ", ie = " + ie +
                ", email = " + email +
                ", telefones [ " + tostring_telefones + " ]" +
                ", enderecos [ " + tostring_enderecos + " ]" +
                ", veiculos [ " + tostring_veiculos_clientes + " ]";
    }
}
