package com.Decroly.Mange_Bandas.Service.Banda;


import com.Decroly.Mange_Bandas.domain.Banda;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
BandaServiceMemoria extends BandaServiceBase{

    public BandaServiceMemoria() {

        super(List.of(
                new Banda(1L, "Slayer", 1L, 4)
        ));

    }
}
