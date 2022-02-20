package com.edilson.cliqueoficina.wscliqueoficina.repository;

import com.edilson.cliqueoficina.wscliqueoficina.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

    @Query( value = "SELECT * FROM USUARIOS WHERE usu_email = :email AND usu_senha = :senha", nativeQuery = true )
    Usuarios findByEmailAndSenha( @Param( "email" ) String email, @Param( "senha" ) String senha );
}
