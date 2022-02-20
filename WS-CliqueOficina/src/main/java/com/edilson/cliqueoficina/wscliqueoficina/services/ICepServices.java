package com.edilson.cliqueoficina.wscliqueoficina.services;

import com.edilson.cliqueoficina.wscliqueoficina.entity.Enderecos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface ICepServices {

    @GetMapping("{cep}/json")
    Enderecos buscaEnderecoPorCep(@PathVariable("cep") String cep );
}
