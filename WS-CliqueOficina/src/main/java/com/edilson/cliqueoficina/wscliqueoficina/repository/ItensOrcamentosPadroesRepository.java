package com.edilson.cliqueoficina.wscliqueoficina.repository;

import com.edilson.cliqueoficina.wscliqueoficina.entity.ItensOrcamentosPadroes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItensOrcamentosPadroesRepository extends JpaRepository<ItensOrcamentosPadroes, Integer> {

    @Query( value = "SELECT * FROM ITENS_ORCAMENTOS_PADROES WHERE iop_descricao LIKE %:descricao%", nativeQuery = true )
    List< ItensOrcamentosPadroes > findByDescricaoItem( @Param( "descricao" ) String descricao );
}
