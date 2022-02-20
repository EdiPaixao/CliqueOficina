package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.Enderecos;
import com.edilson.cliqueoficina.wscliqueoficina.services.ICepServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/busca_cep" )
public class CepsController {

    @Autowired
    private ICepServices icep_services;

    @GetMapping( "/{cep}" )
    public ResponseEntity<Object> index( @PathVariable( "cep" ) String cep ) {
        try {
            Enderecos endereco = icep_services.buscaEnderecoPorCep( cep );

            if ( endereco == null )
                return new ResponseEntity<>( "Endereço não encontrado!", HttpStatus.NOT_FOUND );
            else
                return new ResponseEntity<>( endereco, HttpStatus.OK );
        }
        catch ( Exception e ) {
            e.printStackTrace();
            return new ResponseEntity<>( "Erro ao realizar a busca do CEP, " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }
}
