package com.example.af190111.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.af190111.dto.ReservaDTO;
import com.example.af190111.model.Cliente;
import com.example.af190111.model.Reserva;
import com.example.af190111.model.Veiculo;
import com.example.af190111.repository.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeiculoService veiculoService;

    public Reserva fromDTO(ReservaDTO dto, Cliente cliente, Veiculo veiculo) {
        Reserva reserva = new Reserva();
        reserva.setDataInicial(LocalDateTime.now());
        reserva.setDataFinal(dto.getDataFinal());
        reserva.setCliente(cliente);
        reserva.setVeiculo(veiculo);
        return reserva;
    }

    public Reserva save(ReservaDTO reservadto, int codCliente, int codVeiculo) {
        Cliente cliente = clienteService.getClienteByCod(codCliente);
        Veiculo veiculo = veiculoService.getVeiculoByCod(codVeiculo);
        
        Reserva reserva = fromDTO(reservadto, cliente, veiculo);

        cliente.addReserva(reserva);
        veiculo.addReserva(reserva);
        
        return reservaRepository.save(reserva);
    }
    
    public Reserva getReservaByCod(int cod) {
        Optional<Reserva> op = reservaRepository.getReservaByCod(cod);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada!"));
    }

    public Reserva getReservaByCodCliente(int cod) {
        Optional<Reserva> op = reservaRepository.getReservaByCodCliente(cod);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada!"));
    }

    public Reserva getReservaByCodVeiculo(int cod) {
        Optional<Reserva> op = reservaRepository.getReservaByCodVeiculo(cod);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada!"));
    }
}
