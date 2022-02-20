package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.TelefonesClientes;
import com.edilson.cliqueoficina.wscliqueoficina.repository.TelefonesClientesRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/telefones_clientes" )
public class TelefonesClientesController {

    @Autowired
    private TelefonesClientesRepository telefones_clientes_repository;

    @GetMapping( "/busca/cliente/{id_cliente}" )
    public ResponseEntity<Object> index( @PathVariable( "id_cliente" ) Integer id_cliente ) {
        List<TelefonesClientes> lista_telefones_clientes = telefones_clientes_repository.findByIdCliente( id_cliente );

        if ( lista_telefones_clientes.isEmpty() )
            return new ResponseEntity<>( "Cliente não contém telefones cadastrados", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_telefones_clientes, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Object> send( @Valid @RequestBody TelefonesClientes telefone_cliente ) {
        /* Validando o id do telefone para atualização */
        if ( telefone_cliente.getId() != null ) {
            Optional<TelefonesClientes> telefone_cliente_consulta = telefones_clientes_repository.findById( telefone_cliente.getId() );

            if ( telefone_cliente_consulta.isEmpty() )
                return new ResponseEntity<>( "Id de telefone do cliente inválido para atualização", HttpStatus.NOT_ACCEPTABLE );
        }

        telefones_clientes_repository.save( telefone_cliente );
        return new ResponseEntity<>( telefone_cliente, HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> delete( @PathVariable( "id" ) Integer id ) {
        Optional<TelefonesClientes> telefone_cliente = telefones_clientes_repository.findById( id );

        if ( telefone_cliente.isEmpty() )
            return new ResponseEntity<>( "Telefone de cliente inexistente para excluir", HttpStatus.NOT_ACCEPTABLE );

        telefones_clientes_repository.delete( telefone_cliente.get() );
        return new ResponseEntity<>( "Telefone de cliente removido com sucesso!", HttpStatus.OK );
    }
}
