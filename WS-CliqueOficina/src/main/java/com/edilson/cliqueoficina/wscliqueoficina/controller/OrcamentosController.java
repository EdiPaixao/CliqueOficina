package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.Orcamentos;
import com.edilson.cliqueoficina.wscliqueoficina.repository.OrcamentosRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/orcamentos" )
public class OrcamentosController {

    @Autowired
    private OrcamentosRepository orcamentos_repository;

    @GetMapping
    public ResponseEntity<Object> index() {
        List<Orcamentos> lista_orcamentos = orcamentos_repository.findAll();

        if ( lista_orcamentos.isEmpty() )
            return new ResponseEntity<>( "Sistema não possui orçamentos cadastrados", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_orcamentos, HttpStatus.OK );
    }

    @GetMapping("/busca/cliente/{id_cliente}")
    public ResponseEntity<Object> indexByUsuario( @PathVariable("id_cliente") Integer id_cliente ) {
        List<Orcamentos> lista_orcamentos = orcamentos_repository.findByIdCliente( id_cliente );

        if ( lista_orcamentos.isEmpty() )
            return new ResponseEntity<>( "Cliente não possui orçamento cadastrado", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_orcamentos, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Object> send( @Valid @RequestBody Orcamentos orcamento ) {
        /* Validando o id para atualização */
        if ( orcamento.getId() != null ) {
            Optional<Orcamentos> orcamento_consulta = orcamentos_repository.findById(orcamento.getId() );

            if ( orcamento_consulta.isEmpty() )
                return new ResponseEntity<>( "Id de orçamento inválido para atualização", HttpStatus.NOT_ACCEPTABLE );
        }

        orcamentos_repository.save( orcamento );
        return new ResponseEntity<>( orcamento, HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> delete( @PathVariable( "id" ) Integer id ) {
        Optional<Orcamentos> orcamento_consulta = orcamentos_repository.findById( id );

        if ( orcamento_consulta.isEmpty() )
            return new ResponseEntity<>( "Id de orçamento inválido para exclusão", HttpStatus.NOT_FOUND );

        orcamentos_repository.delete( orcamento_consulta.get() );
        return new ResponseEntity<>( "Orçamento excluido com sucesso!", HttpStatus.OK );
    }
}
