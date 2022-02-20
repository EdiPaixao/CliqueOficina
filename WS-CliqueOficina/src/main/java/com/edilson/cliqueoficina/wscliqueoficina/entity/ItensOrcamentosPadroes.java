package com.edilson.cliqueoficina.wscliqueoficina.entity;

import com.edilson.cliqueoficina.wscliqueoficina.util.Propriedades;
import javax.persistence.*;

@Entity
@Table( name = Propriedades.TABELA_ITENS_ORCAMENTOS_PADROES )
public class ItensOrcamentosPadroes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "iop_id" )
    private Integer id;

    @Column( name = "iop_descricao", nullable = false )
    private String descricao;

    @Column( name = "iop_valor", nullable = false )
    private Double valor;

    public ItensOrcamentosPadroes() {
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

    @Override
    public String toString() {
        return "ItensOrcamentosPadroes: " +
                "  id = " + id +
                ", descricao = " + descricao +
                ", valor = " + valor;
    }
}
