package com.Decroly.Mange_Bandas.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Banda {

    private Long id;
    private String nombre;
    private Long categoria;
    private int intregantes;

}
