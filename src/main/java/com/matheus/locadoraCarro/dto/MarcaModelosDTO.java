package com.matheus.locadoraCarro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MarcaModelosDTO {

    private String name;
    private int lugares;
    private boolean airBag;
    private boolean abs;
    private boolean numPortas;
	
}
