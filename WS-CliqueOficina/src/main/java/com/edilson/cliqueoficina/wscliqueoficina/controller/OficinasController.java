package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.Oficinas;
import com.edilson.cliqueoficina.wscliqueoficina.repository.OficinasRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/oficinas" )
public class OficinasController {

    @Autowired
    private OficinasRepository oficinas_repository;

    @GetMapping
    public ResponseEntity<Object> index() {
        List<Oficinas> lista_oficinas = oficinas_repository.findAll();

        if ( lista_oficinas.isEmpty() )
            return new ResponseEntity<>( "Não existe oficinas cadastradas no sistema", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_oficinas, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Object> send( @Valid @RequestBody Oficinas oficina ) {
        /* Validando o id da oficina para atualização */
        if ( oficina.getId() != null ) {
            Optional<Oficinas> oficina_consulta = oficinas_repository.findById( oficina.getId() );

            if ( oficina_consulta.isEmpty() )
                return new ResponseEntity<>( "Id de oficina inválido para atualização", HttpStatus.NOT_ACCEPTABLE );
        }

        oficinas_repository.save( oficina );
        return new ResponseEntity<>( oficina, HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> delete( @PathVariable( "id" ) Integer id ) {
        Optional<Oficinas> oficina = oficinas_repository.findById( id );

        if ( oficina.isEmpty() )
            return new ResponseEntity<>( "Id de oficina inválido para exclusão", HttpStatus.NOT_ACCEPTABLE );

        oficinas_repository.delete( oficina.get() );
        return new ResponseEntity<>( "Oficina excluída com sucesso!", HttpStatus.OK );
    }
}
