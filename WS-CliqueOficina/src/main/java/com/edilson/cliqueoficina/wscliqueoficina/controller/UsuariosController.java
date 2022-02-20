package com.edilson.cliqueoficina.wscliqueoficina.controller;

import com.edilson.cliqueoficina.wscliqueoficina.entity.Usuarios;
import com.edilson.cliqueoficina.wscliqueoficina.repository.UsuariosRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/usuarios" )
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuarios_repository;

    @GetMapping
    public ResponseEntity<Object> index() {
        List<Usuarios> lista_usuarios = usuarios_repository.findAll();

        if ( lista_usuarios.isEmpty() )
            return new ResponseEntity<>( "Não existem usuários cadastrados no sistema", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( lista_usuarios, HttpStatus.OK );
    }

    @GetMapping( "/login/{email}/{senha}" )
    public ResponseEntity<Object> login( @PathVariable( "email" ) String email, @PathVariable( "senha" ) String senha ) {
        Usuarios usuario = usuarios_repository.findByEmailAndSenha( email, senha );

        if ( usuario == null )
            return new ResponseEntity<>( "Credenciais inválidas para login", HttpStatus.NOT_FOUND );
        else
            return new ResponseEntity<>( usuario, HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<Object> send( @Valid @RequestBody Usuarios usuario ) {
        /* Verificando o id do usuário para realizar atualização */
        if ( usuario.getId() != null ) {
            Optional<Usuarios> usuario_consulta = usuarios_repository.findById( usuario.getId() );

            if ( usuario_consulta.isEmpty() )
                return new ResponseEntity<>( "Id de usuário inválido para realizar atualização", HttpStatus.NOT_ACCEPTABLE );
        }

        usuarios_repository.save( usuario );
        return new ResponseEntity<>( usuario, HttpStatus.OK );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Object> delete( @PathVariable( "id" ) Integer id ) {
        Optional<Usuarios> usuario = usuarios_repository.findById( id );

        if ( usuario.isEmpty() )
            return new ResponseEntity<>( "Id de usuário inválido para realizar exclusão", HttpStatus.NOT_FOUND );

        usuarios_repository.delete( usuario.get() );
        return new ResponseEntity<>( "Usuário removido com sucesso!", HttpStatus.OK );
    }
}
