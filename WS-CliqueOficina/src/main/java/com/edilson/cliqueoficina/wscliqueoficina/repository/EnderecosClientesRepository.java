package com.edilson.cliqueoficina.wscliqueoficina.repository;

import com.edilson.cliqueoficina.wscliqueoficina.entity.EnderecosClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecosClientesRepository extends JpaRepository<EnderecosClientes, Integer> {

    @Query( value = "SELECT * FROM ENDERECOS_CLIENTES WHERE enc_id_cliente = :id_cliente", nativeQuery = true )
    List<EnderecosClientes> findByIdCliente( @Param( "id_cliente" ) Integer id_cliente );
}
