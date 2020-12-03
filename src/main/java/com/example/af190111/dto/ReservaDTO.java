package com.example.af190111.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservaDTO {
    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm:ss")
    private LocalDateTime dataFinal;

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }
}
