package com.matheus.locadoraCarro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeloCarrosDTO {

    private long id;
    private String placa;
    private boolean disponivel;
    private int km;
}
