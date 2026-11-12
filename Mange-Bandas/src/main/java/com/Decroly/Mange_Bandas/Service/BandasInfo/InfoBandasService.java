package com.Decroly.Mange_Bandas.Service.BandasInfo;

import com.Decroly.Mange_Bandas.dto.InfoBandasDto;

public interface InfoBandasService {
    /**
     * Devuelve la información general configurada.
     *
     * @return nombre, máximo de bandas y máximo de integrantes
     */
    InfoBandasDto getInfo();
}
