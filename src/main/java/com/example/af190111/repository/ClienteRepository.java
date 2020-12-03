package com.example.af190111.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.af190111.model.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static int nextCod = 1;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Optional<Cliente> getClienteByCod(int cod) {
        for (Cliente aux : clientes) {
            if(aux.getCod() == cod) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Cliente save(Cliente cliente) {
        cliente.setCod(nextCod++);
        clientes.add(cliente);
        return cliente;
    }

    public Cliente update(Cliente cliente) {
        Cliente aux = getClienteByCod(cliente.getCod()).get();
        if(aux != null) {
            aux.setEndereco(cliente.getEndereco());
        }
        return aux;
    }

    public void delete(Cliente cliente)
    {
        clientes.remove(cliente);
    }
}
