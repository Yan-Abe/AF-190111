package com.example.af190111.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.af190111.dto.VeiculoDTO;
import com.example.af190111.model.Veiculo;
import com.example.af190111.service.VeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> getVeiculos() {
        return veiculoService.getVeiculos();
    }

    @GetMapping("/{cod}")
    public ResponseEntity<Veiculo> getVeiculoByCod(@PathVariable int cod) {
        Veiculo cliente = veiculoService.getVeiculoByCod(cod);    
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Veiculo> save(@RequestBody VeiculoDTO veiculoDTO,
                                           HttpServletRequest request,
                                           UriComponentsBuilder builder) {
         Veiculo veiculo = veiculoService.fromDTO(veiculoDTO);
         veiculo = veiculoService.save(veiculo);
         UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + veiculo.getCod()).build();
         return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{cod}")
    public ResponseEntity<Veiculo> update(@RequestBody VeiculoDTO veiculoDTO, @PathVariable int cod) { 
        Veiculo veiculo = veiculoService.fromDTO(veiculoDTO);
        veiculo.setCod(cod);
        veiculo = veiculoService.update(veiculo);
        return ResponseEntity.ok(veiculo);
    }
    
    @DeleteMapping("/{cod}")
    public ResponseEntity<Void> delete(@PathVariable int cod) {
        veiculoService.delete(cod);
        return ResponseEntity.noContent().build();
    }
}
