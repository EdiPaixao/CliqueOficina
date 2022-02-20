package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.Cargos;
import com.edilson.cliqueoficina.wscliqueoficina.repository.CargosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/cargos" )
public class CargosController {

    @Autowired
    private CargosRepository cargos_repository;

    @GetMapping
    public ResponseEntity<Object> index() {
        List<Cargos> lista_cargos = cargos_repository.findAll();

        if ( lista_cargos.isEmpty() )
            return new ResponseEntity<>( "Não existem cargos cadastrados no sistema", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_cargos, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Object> send( @Valid @RequestBody Cargos cargo ) {
        /* Validando o id para realizar atualizações */
        if ( cargo.getId() != null ) {
            Optional<Cargos> cargo_consulta = cargos_repository.findById( cargo.getId() );

            if ( cargo_consulta.isEmpty() )
                return new ResponseEntity<>( "Id de cargo inválido para realizar atualização", HttpStatus.NOT_ACCEPTABLE );
        }

        cargos_repository.save( cargo );
        return new ResponseEntity<>( cargo, HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> delete( @PathVariable( "id" ) Integer id ) {
        /* Validando se o id do cargo existe no sistema */
        Optional<Cargos> cargo = cargos_repository.findById( id );

        if ( cargo.isEmpty() )
            return new ResponseEntity<>( "Cargo com id informado não existe no sistema", HttpStatus.NOT_FOUND );

        cargos_repository.delete( cargo.get() );
        return new ResponseEntity<>( "Cargo excluído com sucesso!", HttpStatus.OK );
    }
}
