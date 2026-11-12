package com.Decroly.Mange_Bandas.Service.BandasInfo;

import com.Decroly.Mange_Bandas.config.BandasProperties;
import org.springframework.stereotype.Service;

@Service
public class InfoBandasServiceMemoria extends InfoBandasServiceBase {

    public InfoBandasServiceMemoria(BandasProperties bandasProperties) {
        super(bandasProperties);
    }
}