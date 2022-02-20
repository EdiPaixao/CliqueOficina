package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.MarcasVeiculos;
import com.edilson.cliqueoficina.wscliqueoficina.repository.MarcasVeiculosRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/marcas" )
public class MarcasVeiculosController {

    @Autowired
    private MarcasVeiculosRepository marcas_veiculos_repository;

    @GetMapping
    public ResponseEntity<Object> index() {
        List<MarcasVeiculos> lista_marcas_veiculos = marcas_veiculos_repository.findAll();

        if ( lista_marcas_veiculos.isEmpty() )
            return new ResponseEntity<>( "Não existem marcas de veículos cadastros no sistema", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_marcas_veiculos, HttpStatus.OK );
    }

    @GetMapping( "/busca/nome/{nome}" )
    public ResponseEntity<Object> indexByNome( @PathVariable( "nome" ) String nome ) {
        List<MarcasVeiculos> lista_marcas_veiculos = marcas_veiculos_repository.findByNome( nome );

        if ( lista_marcas_veiculos.isEmpty() )
            return new ResponseEntity<>( "Marcas não encontradas", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_marcas_veiculos, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Object> send( @Valid @RequestBody MarcasVeiculos marca_veiculo ) {
        /* Verificando id da marca de veículo para atualização */
        if ( marca_veiculo.getId() != null ) {
            Optional<MarcasVeiculos> marca_veiculo_consulta = marcas_veiculos_repository.findById( marca_veiculo.getId() );

            if ( marca_veiculo_consulta.isEmpty() )
                return new ResponseEntity<>( "Id de marca de veículo inválido para atualização", HttpStatus.NOT_ACCEPTABLE );
        }

        marcas_veiculos_repository.save( marca_veiculo );
        return new ResponseEntity<>( marca_veiculo, HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> delete( @PathVariable( "id" ) Integer id ) {
        Optional<MarcasVeiculos> marca_veiculo = marcas_veiculos_repository.findById( id );

        if ( marca_veiculo.isEmpty() )
            return new ResponseEntity<>( "Id de marca de veículo inválido para exclusão", HttpStatus.NOT_ACCEPTABLE );

        marcas_veiculos_repository.delete( marca_veiculo.get() );
        return new ResponseEntity<>( "Marca de veículo excluido com sucesso!", HttpStatus.OK );
    }
}
