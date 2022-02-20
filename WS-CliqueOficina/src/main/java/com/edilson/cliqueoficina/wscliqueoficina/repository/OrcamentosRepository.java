package com.edilson.cliqueoficina.wscliqueoficina.repository;

import com.edilson.cliqueoficina.wscliqueoficina.entity.Orcamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrcamentosRepository extends JpaRepository<Orcamentos, Integer> {

    @Query( value = "SELECT * FROM ORCAMENTOS WHERE orc_id_cliente = :id_cliente ORDER BY orc_data_hora_criacao DESC, orc_is_finalizada ASC", nativeQuery = true )
    List<Orcamentos> findByIdCliente( @Param( "id_cliente" ) Integer id_cliente );
}
