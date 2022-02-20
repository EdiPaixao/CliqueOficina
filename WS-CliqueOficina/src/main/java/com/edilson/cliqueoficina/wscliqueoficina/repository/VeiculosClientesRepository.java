package com.edilson.cliqueoficina.wscliqueoficina.repository;

import com.edilson.cliqueoficina.wscliqueoficina.entity.VeiculosClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VeiculosClientesRepository extends JpaRepository<VeiculosClientes, Integer> {

    @Query( value = "SELECT * FROM VEICULOS_CLIENTES WHERE vec_id_cliente = :id_cliente ORDER BY vec_id DESC", nativeQuery = true )
    List<VeiculosClientes> findByIdCliente( @Param( "id_cliente" ) Integer id_cliente );
}
