package com.Decroly.Mange_Bandas.Service.BandasInfo;

import com.Decroly.Mange_Bandas.config.BandasProperties;
import com.Decroly.Mange_Bandas.dto.InfoBandasDto;

public abstract class InfoBandasServiceBase implements InfoBandasService {

    private final BandasProperties bandasProperties;

    public InfoBandasServiceBase(BandasProperties bandasProperties) {
        this.bandasProperties = bandasProperties;
    }

    @Override
    public InfoBandasDto getInfo() {
        return new InfoBandasDto(
                bandasProperties.nombre(),
                bandasProperties.maxBandas(),
                bandasProperties.maxIntegrantes());
    }
}
