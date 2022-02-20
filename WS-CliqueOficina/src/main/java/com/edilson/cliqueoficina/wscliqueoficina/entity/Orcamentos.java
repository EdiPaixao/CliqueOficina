package com.edilson.cliqueoficina.wscliqueoficina.entity;

import com.edilson.cliqueoficina.wscliqueoficina.util.Propriedades;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

import java.util.List;

@Entity
@Table( name = Propriedades.TABELA_ORCAMENTOS )
public class Orcamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "orc_id" )
    private Integer id;

    @Column( name = "orc_data_hora_criacao", nullable = false )
    private String data_hora_criacao;

    @Column( name = "orc_data_hora_atualizacao", nullable = false )
    private String data_hora_atualizacao;

    @Column( name = "orc_data_hora_finalizacao" )
    private String data_hora_finalizacao;

    @Column( name = "orc_is_finalizada" )
    private Boolean is_finalizada;

    @Column( name = "orc_valor_inicial" )
    private Double valor_inicial;

    @Column( name = "orc_valor_final" )
    private Double valor_final;

    @Column( name = "orc_observacoes" )
    private String observacoes;

    @Column( name = "orc_id_cliente", nullable = false )
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY )
    private Integer id_cliente;

    @Column( name = "orc_id_veiculo_cliente", nullable = false )
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY )
    private Integer id_veiculo_cliente;

    @ManyToOne
    @JoinColumn( name = "orc_id_cliente", referencedColumnName = "cli_id", insertable = false, updatable = false )
    private Clientes cliente;

    @ManyToOne
    @JoinColumn( name = "orc_id_veiculo_cliente", referencedColumnName = "vec_id", insertable = false, updatable = false )
    private VeiculosClientes veiculo;

    @OneToMany( mappedBy = "id_orcamento" )
    @OrderBy( "data_hora_item ASC" )
    private List< ItensOrcamentos > itens_orcamento;

    public Orcamentos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData_hora_criacao() {
        return data_hora_criacao;
    }

    public void setData_hora_criacao(String data_hora_criacao) {
        this.data_hora_criacao = data_hora_criacao;
    }

    public String getData_hora_atualizacao() {
        return data_hora_atualizacao;
    }

    public void setData_hora_atualizacao(String data_hora_atualizacao) {
        this.data_hora_atualizacao = data_hora_atualizacao;
    }

    public String getData_hora_finalizacao() {
        return data_hora_finalizacao;
    }

    public void setData_hora_finalizacao(String data_hora_finalizacao) {
        this.data_hora_finalizacao = data_hora_finalizacao;
    }

    public Boolean getIs_finalizada() {
        return is_finalizada;
    }

    public void setIs_finalizada(Boolean is_finalizada) {
        this.is_finalizada = is_finalizada;
    }

    public Double getValor_inicial() {
        return valor_inicial;
    }

    public void setValor_inicial(Double valor_inicial) {
        this.valor_inicial = valor_inicial;
    }

    public Double getValor_final() {
        return valor_final;
    }

    public void setValor_final(Double valor_final) {
        this.valor_final = valor_final;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_veiculo_cliente() {
        return id_veiculo_cliente;
    }

    public void setId_veiculo_cliente(Integer id_veiculo_cliente) {
        this.id_veiculo_cliente = id_veiculo_cliente;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public VeiculosClientes getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculosClientes veiculo) {
        this.veiculo = veiculo;
    }

    public List<ItensOrcamentos> getItens_orcamento() {
        return itens_orcamento;
    }

    public void setItens_orcamento(List<ItensOrcamentos> itens_orcamento) {
        this.itens_orcamento = itens_orcamento;
    }

    @Override
    public String toString() {
        String tostring_cliente = cliente == null ? "Cliente inexistente" : cliente.toString();
        String tostring_veiculo = veiculo == null ? "Veiculo inexistente" : veiculo.toString();

        StringBuilder tostring_itens_orcamento = new StringBuilder( "Sem itens" );
        if ( itens_orcamento != null ) {
            for ( ItensOrcamentos item : itens_orcamento )
                tostring_itens_orcamento.append( item.toString() ).append( ", " );
        }

        return "Orcamento: " +
                "  id = " + id +
                ", data_hora_criacao = " + data_hora_criacao + '\'' +
                ", data_hora_atualizacao = " + data_hora_atualizacao + '\'' +
                ", data_hora_finalizacao = " + data_hora_finalizacao + '\'' +
                ", is_finalizada = " + is_finalizada +
                ", valor_inicial = " + valor_inicial +
                ", valor_final = " + valor_final +
                ", observacoes = " + observacoes + '\'' +
                ", id_cliente = " + id_cliente +
                ", id_veiculo_cliente = " + id_veiculo_cliente +
                ", cliente = " + tostring_cliente +
                ", veiculo = " + tostring_veiculo +
                ", itens_orcamento = " + tostring_itens_orcamento;
    }
}