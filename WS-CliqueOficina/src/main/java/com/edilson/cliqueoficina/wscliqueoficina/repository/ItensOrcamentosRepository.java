package com.edilson.cliqueoficina.wscliqueoficina.repository;

import com.edilson.cliqueoficina.wscliqueoficina.entity.ItensOrcamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItensOrcamentosRepository extends JpaRepository<ItensOrcamentos, Integer> {

    @Query( value = "SELECT * FROM ITENS_ORCAMENTOS WHERE ito_id_orcamento = :id_orcamento", nativeQuery = true )
    List<ItensOrcamentos> findByIdOrcamento( @Param( "id_orcamento" ) Integer id_orcamento );
}
