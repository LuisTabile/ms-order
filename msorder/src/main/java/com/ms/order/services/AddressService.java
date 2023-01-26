package com.ms.order.services;

import com.ms.order.models.dto.response.ApiViaCepResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws/")
public interface AddressService {

    @GetMapping("{cep}/json")
    ApiViaCepResponseDTO findByCep(@PathVariable("cep") String cep);
}
