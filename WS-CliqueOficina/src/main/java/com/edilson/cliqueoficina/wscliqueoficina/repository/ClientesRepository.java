package com.edilson.cliqueoficina.wscliqueoficina.repository;

import com.edilson.cliqueoficina.wscliqueoficina.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    @Query( value = "SELECT * FROM CLIENTES WHERE cli_nome LIKE %:nome%", nativeQuery = true )
    List<Clientes> findByNome( @Param( "nome" ) String nome );
}
