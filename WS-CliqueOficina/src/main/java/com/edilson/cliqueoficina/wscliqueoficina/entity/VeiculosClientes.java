package com.edilson.cliqueoficina.wscliqueoficina.entity;

import com.edilson.cliqueoficina.wscliqueoficina.util.Propriedades;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table( name = Propriedades.TABELA_VEICULOS_CLIENTES )
public class VeiculosClientes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "vec_id" )
    private Integer id;

    @Column( name = "vec_modelo", nullable = false )
    private String modelo;

    @Column( name = "vec_versao" )
    private String versao;

    @Column( name = "vec_ano_fabricacao", nullable = false )
    private Integer ano_fabricacao;

    @Column( name = "vec_ano_modelo", nullable = false )
    private Integer ano_modelo;

    @Column( name = "vec_placa", nullable = false )
    private String placa;

    @Column( name = "vec_renavan" )
    private String renavan;

    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY )
    @Column( name = "vec_id_marca", nullable = false )
    private Integer id_marca;


    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY )
    @Column( name = "vec_id_cliente", nullable = false )
    private Integer id_cliente;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY )
    @ManyToOne
    @JoinColumn( name = "vec_id_marca", referencedColumnName = "mar_id", insertable = false, updatable = false )
    private MarcasVeiculos marca;

    public VeiculosClientes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Integer getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(Integer ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public Integer getAno_modelo() {
        return ano_modelo;
    }

    public void setAno_modelo(Integer ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public MarcasVeiculos getMarca() {
        return marca;
    }

    public void setMarca(MarcasVeiculos marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        String tostring_marca = marca == null ? "Marca indefinida" : marca.toString();

        return "Veiculo: " +
                "  id = " + id +
                ", modelo = " + modelo +
                ", versao = " + versao +
                ", ano_fabricacao = " + ano_fabricacao +
                ", ano_modelo = " + ano_modelo +
                ", placa = " + placa +
                ", renavan = " + renavan +
                ", id_marca = " + id_marca +
                ", id_cliente = " + id_cliente +
                ", marca = " + tostring_marca;
    }
}