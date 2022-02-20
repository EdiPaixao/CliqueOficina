package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.ItensOrcamentos;
import com.edilson.cliqueoficina.wscliqueoficina.repository.ItensOrcamentosRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/itens_orcamentos" )
public class ItensOrcamentosController {

    @Autowired
    private ItensOrcamentosRepository itens_orcamentos_repository;

    @GetMapping( "/busca/orcamento/{id_orcamento}" )
    public ResponseEntity<Object> index( @PathVariable( "id_orcamento" ) Integer id_orcamento ) {
        List<ItensOrcamentos> lista_itens_orcamentos = itens_orcamentos_repository.findByIdOrcamento( id_orcamento );

        if ( lista_itens_orcamentos.isEmpty() )
            return new ResponseEntity<>( "Orçamento não contém itens", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_itens_orcamentos, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Object> send( @Valid @RequestBody ItensOrcamentos item_orcamento ) {
        if ( item_orcamento.getId() != null ) {
            Optional<ItensOrcamentos> item_orcamento_consulta = itens_orcamentos_repository.findById( item_orcamento.getId() );

            if ( item_orcamento_consulta.isEmpty() )
                return new ResponseEntity<>( "Id de item de orçamento inválido para atualização", HttpStatus.NOT_ACCEPTABLE );
        }

        itens_orcamentos_repository.save( item_orcamento );
        return new ResponseEntity<>( item_orcamento, HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> delete( @PathVariable( "id" ) Integer id ) {
        Optional<ItensOrcamentos> item_orcamento = itens_orcamentos_repository.findById( id );

        if ( item_orcamento.isEmpty() )
            return new ResponseEntity<>( "Id de item de orçamento inválido para exclusão", HttpStatus.NOT_FOUND );

        itens_orcamentos_repository.delete( item_orcamento.get() );
        return new ResponseEntity<>( "Item de orçamento removido com sucesso!", HttpStatus.OK );
    }
}
