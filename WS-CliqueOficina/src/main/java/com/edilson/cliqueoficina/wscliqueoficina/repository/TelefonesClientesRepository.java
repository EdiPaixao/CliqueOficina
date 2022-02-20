package com.edilson.cliqueoficina.wscliqueoficina.repository;

import com.edilson.cliqueoficina.wscliqueoficina.entity.TelefonesClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TelefonesClientesRepository extends JpaRepository<TelefonesClientes, Integer> {

    @Query( value = "SELECT * FROM TELEFONES_CLIENTES WHERE tec_id_cliente = :id_cliente ORDER BY tec_id DESC", nativeQuery = true )
    List<TelefonesClientes> findByIdCliente( @Param( "id_cliente" ) Integer id_cliente );
}
