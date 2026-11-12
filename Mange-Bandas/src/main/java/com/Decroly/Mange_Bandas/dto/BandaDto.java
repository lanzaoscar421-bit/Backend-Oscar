
package com.Decroly.Mange_Bandas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BandaDto {

    private String nombre;
    private Long categoria;
    private int intregantes;

}
