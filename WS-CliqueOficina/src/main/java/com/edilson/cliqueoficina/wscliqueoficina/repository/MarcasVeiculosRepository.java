package com.edilson.cliqueoficina.wscliqueoficina.repository;

import com.edilson.cliqueoficina.wscliqueoficina.entity.MarcasVeiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarcasVeiculosRepository extends JpaRepository<MarcasVeiculos, Integer> {

    @Query( value = "SELECT * FROM MARCAS_VEICULOS WHERE mar_nome LIKE %:nome%", nativeQuery = true )
    List<MarcasVeiculos> findByNome( @Param( "nome" ) String nome );
}
