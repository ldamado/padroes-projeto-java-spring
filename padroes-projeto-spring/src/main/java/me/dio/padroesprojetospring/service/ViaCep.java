package me.dio.padroesprojetospring.service;

import me.dio.padroesprojetospring.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCep {

    @GetMapping("/{cep}/json/")
    Address checkCep(@PathVariable("cep") String cep);
}
