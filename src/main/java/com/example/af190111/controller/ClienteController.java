package com.example.af190111.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.af190111.dto.ClienteDTO;
import com.example.af190111.dto.ReservaDTO;
import com.example.af190111.model.Cliente;
import com.example.af190111.model.Reserva;
import com.example.af190111.service.ClienteService;
import com.example.af190111.service.ReservaService;

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
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/{cod}")
    public ResponseEntity<Cliente> getClienteByCod(@PathVariable int cod) {
        Cliente cliente = clienteService.getClienteByCod(cod);     
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@Valid @RequestBody ClienteDTO clienteDTO,
                                           HttpServletRequest request,
                                           UriComponentsBuilder builder) {       
         Cliente cliente = clienteService.fromDTO(clienteDTO);
         cliente = clienteService.save(cliente);
         UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + cliente.getCod()).build();
         return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PostMapping("{codCliente}/veiculos/{codVeiculo}")
    public ResponseEntity<Reserva> salvar(@PathVariable int codCliente,
                                            @PathVariable int codVeiculo,
                                            @RequestBody ReservaDTO reservadto,
                                            HttpServletRequest request,
                                            UriComponentsBuilder builder) {
         Reserva reserva = reservaService.save(reservadto, codCliente, codVeiculo);                                    
         UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + reserva.getCod()).build();
         return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{cod}")
    public ResponseEntity<Cliente> update(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable int cod) { 
        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente.setCod(cod);
        cliente = clienteService.update(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{cod}")
    public ResponseEntity<Void> delete(@PathVariable int cod) {
        clienteService.delete(cod);
        return ResponseEntity.noContent().build();
    }
}