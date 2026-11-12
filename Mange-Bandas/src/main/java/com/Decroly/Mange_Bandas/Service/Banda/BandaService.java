package com.Decroly.Mange_Bandas.Service.Banda;

import com.Decroly.Mange_Bandas.domain.Banda;
import com.Decroly.Mange_Bandas.dto.BandaDto;

import java.util.List;

public interface BandaService {

    List<Banda>listBandas();
    Banda listaBandaId(Long id);
    void delBanda(Long id);
    Banda addBanda(BandaDto dto);
    Banda updateBanda(Long id, BandaDto dto);
}
