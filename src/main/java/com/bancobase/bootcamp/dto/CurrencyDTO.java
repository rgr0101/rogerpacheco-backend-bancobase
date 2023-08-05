//Bootcamp Desarrollo de Aplicaciones de Banca | Banco BASE
//Hecho por: Roger Pacheco

package com.bancobase.bootcamp.dto;

import lombok.*;

//creamos el dto en el que indicamos que datos vamos a mostrar de las dos apis

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CurrencyDTO {
    private String name;
    private String symbol;
    private Double value;
}
