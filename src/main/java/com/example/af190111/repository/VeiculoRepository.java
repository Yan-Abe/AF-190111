package com.example.af190111.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.af190111.model.Veiculo;

import org.springframework.stereotype.Component;

@Component
public class VeiculoRepository {
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    private static int nextCod = 1;

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public Optional<Veiculo> getVeiculoByCod(int cod) {
        for (Veiculo aux : veiculos) {
            if(aux.getCod() == cod) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Veiculo save(Veiculo veiculo) {
        veiculo.setCod(nextCod++);
        veiculos.add(veiculo);
        return veiculo;
    }

    public Veiculo update(Veiculo veiculo) {
        Veiculo aux = getVeiculoByCod(veiculo.getCod()).get();
        if(aux != null) {
            aux.setValorDiaria(veiculo.getValorDiaria());
        }
        return aux;
    }

    public void delete(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }
}
