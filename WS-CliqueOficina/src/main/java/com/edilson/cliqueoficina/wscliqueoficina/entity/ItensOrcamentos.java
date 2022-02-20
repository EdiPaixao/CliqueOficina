package com.edilson.cliqueoficina.wscliqueoficina.entity;

import com.edilson.cliqueoficina.wscliqueoficina.util.Propriedades;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table( name = Propriedades.TABELA_ITENS_ORCAMENTOS )
public class ItensOrcamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "ito_id" )
    private Integer id;

    @Column( name = "ito_descricao", nullable = false )
    private String descricao;

    @Column( name = "ito_valor", nullable = false )
    private Double valor;

    @Column( name = "ito_valor_desconto" )
    private Double valor_desconto;

    @Column( name = "ito_quantidade", nullable = false )
    private Integer quantidade;

    @Column( name = "ito_data_hora_item", nullable = false )
    private String data_hora_item;

    @Column( name = "ito_is_complementar" )
    private Boolean is_complementar;

    @Column( name = "ito_id_orcamento", nullable = false )
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY )
    private Integer id_orcamento;

    public ItensOrcamentos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValor_desconto() {
        return valor_desconto;
    }

    public void setValor_desconto(Double valor_desconto) {
        this.valor_desconto = valor_desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getData_hora_item() {
        return data_hora_item;
    }

    public void setData_hora_item(String data_hora_item) {
        this.data_hora_item = data_hora_item;
    }

    public Boolean getIs_complementar() {
        return is_complementar;
    }

    public void setIs_complementar(Boolean is_complementar) {
        this.is_complementar = is_complementar;
    }

    public Integer getId_orcamento() {
        return id_orcamento;
    }

    public void setId_orcamento(Integer id_orcamento) {
        this.id_orcamento = id_orcamento;
    }

    @Override
    public String toString() {
        return "Item orcamento: " +
                "  id = " + id +
                ", descricao = " + descricao +
                ", valor = " + valor +
                ", valor_desconto = " + valor_desconto +
                ", quantidade = " + quantidade +
                ", data_hora_item = " + data_hora_item +
                ", is_complementar = " + is_complementar +
                ", id_orcamento = " + id_orcamento;
    }
}