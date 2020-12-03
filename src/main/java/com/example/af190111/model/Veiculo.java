package com.example.af190111.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Veiculo {
    private int cod;
    private String modelo;
    private float valorDiaria;
    private ArrayList<Reserva> reservas;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean addReserva(Reserva reserva) {
        return reservas.add(reserva);
    }

    @JsonIgnore
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
}
