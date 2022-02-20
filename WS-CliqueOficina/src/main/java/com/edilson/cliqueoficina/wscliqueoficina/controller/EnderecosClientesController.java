package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.EnderecosClientes;
import com.edilson.cliqueoficina.wscliqueoficina.repository.EnderecosClientesRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/enderecos_clientes" )
public class EnderecosClientesController {

    @Autowired
    private EnderecosClientesRepository enderecos_clientes_repository;

    @GetMapping( "/busca/cliente/{id_cliente}" )
    public ResponseEntity<Object> index( @PathVariable( "id_cliente" ) Integer id_cliente ) {
        List<EnderecosClientes> lista_enderecos_cliente = enderecos_clientes_repository.findByIdCliente( id_cliente );

        if ( lista_enderecos_cliente.isEmpty() )
            return new ResponseEntity<>( "Cliente não possui endereços cadastrados", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_enderecos_cliente, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Object> send( @Valid @RequestBody EnderecosClientes endereco_cliente ) {
        /* Validando id do endereço do cliente para realizar atualização */
        if ( endereco_cliente.getId() != null ) {
            Optional<EnderecosClientes> endereco_cliente_consulta = enderecos_clientes_repository.findById( endereco_cliente.getId() );

            if ( endereco_cliente_consulta.isEmpty() )
                return new ResponseEntity<>( "Id de endereço do cliente inválido para realizar atualização", HttpStatus.NOT_ACCEPTABLE );
        }

        enderecos_clientes_repository.save( endereco_cliente );
        return new ResponseEntity<>( endereco_cliente, HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> delete( @PathVariable( "id" ) Integer id ) {
        Optional<EnderecosClientes> endereco_cliente = enderecos_clientes_repository.findById( id );

        if ( endereco_cliente.isEmpty() )
            return new ResponseEntity<>( "Endereço do cliente não existe para realizar exclusão", HttpStatus.NOT_FOUND );

        enderecos_clientes_repository.delete( endereco_cliente.get() );
        return new ResponseEntity<>( "Endereço de cliente excluído com sucesso!", HttpStatus.OK );
    }
}
