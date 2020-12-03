package com.example.af190111.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Reserva {
    private int cod;

    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm:ss")
    private LocalDateTime dataInicial;

    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm:ss")
    private LocalDateTime dataFinal;

    private Cliente cliente;
    private Veiculo veiculo;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDateTime dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getClienteCod() {
        return cliente.getCod();
    }

    public int getVeiculoCod() {
        return veiculo.getCod();
    }
}
