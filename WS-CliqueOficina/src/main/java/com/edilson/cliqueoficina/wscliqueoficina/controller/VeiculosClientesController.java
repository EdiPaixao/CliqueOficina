package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.VeiculosClientes;
import com.edilson.cliqueoficina.wscliqueoficina.repository.VeiculosClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/veiculos_clientes" )
public class VeiculosClientesController {

    @Autowired
    private VeiculosClientesRepository veiculos_clientes_repository;

    @GetMapping( "/busca/cliente/{id_cliente}" )
    public ResponseEntity<Object> index( @PathVariable( "id_cliente" ) Integer id_cliente ) {
        List<VeiculosClientes> lista_veiculos_clientes = veiculos_clientes_repository.findByIdCliente( id_cliente );

        if ( lista_veiculos_clientes.isEmpty() )
            return new ResponseEntity<>( "Cliente não contém veículos cadastrados", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_veiculos_clientes, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Object> send( @Valid @RequestBody VeiculosClientes veiculos_clientes ) {
        /* Validando o id do veículo para atualização */
        if ( veiculos_clientes.getId() != null ) {
            Optional<VeiculosClientes> veiculos_clientes_consulta = veiculos_clientes_repository.findById( veiculos_clientes.getId() );

            if ( veiculos_clientes_consulta.isEmpty() )
                return new ResponseEntity<>( "Id de veículo inválido para atualização", HttpStatus.NOT_ACCEPTABLE );
        }

        veiculos_clientes_repository.save( veiculos_clientes );
        return new ResponseEntity<>( veiculos_clientes, HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> delete( @PathVariable( "id" ) Integer id ) {
        Optional<VeiculosClientes> veiculos_clientes_consulta = veiculos_clientes_repository.findById( id );

        if ( veiculos_clientes_consulta.isEmpty() )
            return new ResponseEntity<>( "Id de veículo inválido para exclusão", HttpStatus.NOT_FOUND );

        veiculos_clientes_repository.delete( veiculos_clientes_consulta.get() );
        return new ResponseEntity<>( "Veículo excluído com sucesso!", HttpStatus.OK );
    }
}
