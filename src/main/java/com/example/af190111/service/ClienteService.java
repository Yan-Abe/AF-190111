package com.example.af190111.service;

import java.util.List;
import java.util.Optional;

import com.example.af190111.dto.ClienteDTO;
import com.example.af190111.model.Cliente;
import com.example.af190111.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente fromDTO(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setEndereco(dto.getEndereco());
        cliente.setNome(dto.getNome());
        cliente.setCpf(dto.getCpf());
        return cliente;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.getClientes();
    }

    public Cliente getClienteByCod(int cod) {
        Optional<Cliente> op = clienteRepository.getClienteByCod(cod);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        getClienteByCod(cliente.getCod());
        return clienteRepository.update(cliente);
    }

    public void delete(int cod) {
        clienteRepository.delete(getClienteByCod(cod));
    }
}
