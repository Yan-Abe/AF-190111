package com.example.af190111.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.example.af190111.model.Reserva;

import org.springframework.stereotype.Component;

@Component
public class ReservaRepository {
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private static int nextCod = 1;
    
    public Reserva save(Reserva reserva) {
        reserva.setCod(nextCod++);
        reservas.add(reserva);
        return reserva;
    }
    
    public Optional<Reserva> getReservaByCod(int cod) {
        for (Reserva aux : reservas) {
            if(aux.getCod() == cod) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Optional<Reserva> getReservaByCodCliente(int cod) {
        for (Reserva aux : reservas) {
            if(aux.getClienteCod() == cod) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Optional<Reserva> getReservaByCodVeiculo(int cod) {
        for (Reserva aux : reservas) {
            if(aux.getVeiculoCod() == cod) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }
}
