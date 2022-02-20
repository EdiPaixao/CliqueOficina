package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.ItensOrcamentosPadroes;
import com.edilson.cliqueoficina.wscliqueoficina.repository.ItensOrcamentosPadroesRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/itens_orcamentos_padroes" )
public class ItensOrcamentosPadroesController {

    @Autowired
    private ItensOrcamentosPadroesRepository itens_orcamentos_padroes_repository;

    @GetMapping
    public ResponseEntity<Object> index() {
        List<ItensOrcamentosPadroes> lista_itens_orcamentos_padroes = itens_orcamentos_padroes_repository.findAll();

        if ( lista_itens_orcamentos_padroes.isEmpty() )
            return new ResponseEntity<>( "Não existem itens de orçamento padrão cadastro no sistema", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_itens_orcamentos_padroes, HttpStatus.OK );
    }

    @GetMapping("/busca/nome/{descricao}")
    public ResponseEntity<Object> indexByNome( @PathVariable("descricao") String descricao ) {
        List<ItensOrcamentosPadroes> lista_itens_orcamentos_padroes = itens_orcamentos_padroes_repository.findByDescricaoItem( descricao );

        if ( lista_itens_orcamentos_padroes.isEmpty() )
            return new ResponseEntity<>( "Não existem itens de orçamento com a descrição informada", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_itens_orcamentos_padroes, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Object> send( @Valid @RequestBody ItensOrcamentosPadroes item_orcamento_padrao ) {
        /* Validando o id para autalização do item de orçamento padrão */
        if ( item_orcamento_padrao.getId() != null ) {
            Optional<ItensOrcamentosPadroes> item_orcamento_padrao_consulta = itens_orcamentos_padroes_repository.findById( item_orcamento_padrao.getId() );

            if ( item_orcamento_padrao_consulta.isEmpty() )
                return new ResponseEntity<>( "Id de item padrão de orçamento inválido para atualização", HttpStatus.NOT_ACCEPTABLE );
        }

        itens_orcamentos_padroes_repository.save( item_orcamento_padrao );
        return new ResponseEntity<>( item_orcamento_padrao, HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> delete( @PathVariable( "id" ) Integer id ) {
        Optional<ItensOrcamentosPadroes> item_orcamento_padrao = itens_orcamentos_padroes_repository.findById( id );

        if ( item_orcamento_padrao.isEmpty() )
            return new ResponseEntity<>( "Id de item padrão de orçamento inválido para atualização", HttpStatus.NOT_ACCEPTABLE );

        itens_orcamentos_padroes_repository.delete( item_orcamento_padrao.get() );
        return new ResponseEntity<>( "Item de orçamento padrão removido com sucesso!", HttpStatus.OK );
    }
}
