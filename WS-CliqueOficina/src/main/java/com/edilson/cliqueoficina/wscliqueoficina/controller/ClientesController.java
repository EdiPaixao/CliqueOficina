package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.Clientes;
import com.edilson.cliqueoficina.wscliqueoficina.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/clientes" )
public class ClientesController {

    @Autowired
    private ClientesRepository clientes_repository;

    @GetMapping
    public ResponseEntity<Object> index() {
        List<Clientes> lista_clientes = clientes_repository.findAll();

        if ( lista_clientes.isEmpty() )
            return new ResponseEntity<>( "Não existem clientes cadastros no sistema", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_clientes, HttpStatus.OK );
    }

    @GetMapping( "/busca/{nome}" )
    public ResponseEntity<Object> indexByNome( @PathVariable( "nome" ) String nome ) {
        List<Clientes> lista_clientes = clientes_repository.findByNome( nome );

        if ( lista_clientes.isEmpty() )
            return new ResponseEntity<>( "A busca não obteve resultados", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_clientes, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Object> send( @Valid @RequestBody Clientes cliente ) {
        /* Validando o id do cliente para atualização cadastral */
        if ( cliente.getId() != null ) {
            Optional<Clientes> cliente_consulta = clientes_repository.findById( cliente.getId() );

            if ( cliente_consulta.isEmpty() )
                return new ResponseEntity<>( "Id inválido para atualização do cliente", HttpStatus.NOT_ACCEPTABLE );
        }

        clientes_repository.save( cliente );
        return new ResponseEntity<>( cliente, HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> delete( @PathVariable( "id" ) Integer id ) {
        Optional<Clientes> cliente = clientes_repository.findById( id );

        if ( cliente.isEmpty() )
            return new ResponseEntity<>( "Cliente não existe para realizar exclusão", HttpStatus.NOT_FOUND );

        clientes_repository.delete( cliente.get() );
        return new ResponseEntity<>( "Cliente excluido com sucesso!", HttpStatus.OK );
    }
}
