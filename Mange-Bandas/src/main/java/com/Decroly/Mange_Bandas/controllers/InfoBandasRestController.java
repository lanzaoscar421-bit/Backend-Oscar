package com.Decroly.Mange_Bandas.controllers;
import com.Decroly.Mange_Bandas.Service.BandasInfo.InfoBandasService;
import com.Decroly.Mange_Bandas.dto.InfoBandasDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Info", description = "Informacion general")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/info")
public class InfoBandasRestController {

    private final InfoBandasService infoBandasService;

    @Operation(summary = "Informacion de la aplicacion")
    @ApiResponse(responseCode = "200", description = "Informacion devuelta")
    @GetMapping
    public InfoBandasDto info() {
        return infoBandasService.getInfo();
    }
}