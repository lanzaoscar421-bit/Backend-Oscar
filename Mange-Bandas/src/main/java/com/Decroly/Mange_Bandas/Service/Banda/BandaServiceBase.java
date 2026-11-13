package com.Decroly.Mange_Bandas.Service.Banda;

import com.Decroly.Mange_Bandas.domain.Banda;
import com.Decroly.Mange_Bandas.dto.BandaDto;
import com.Decroly.Mange_Bandas.exceptions.BadRequestException;
import com.Decroly.Mange_Bandas.exceptions.ConflictException;
import com.Decroly.Mange_Bandas.exceptions.NotFoundException;
import com.Decroly.Mange_Bandas.exceptions.ValidateException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
    public abstract class BandaServiceBase implements BandaService {


    private final List<Banda> bandas;
    private final AtomicLong secuencia;


    public BandaServiceBase(List<Banda> bandas){


        this.bandas = new ArrayList<>(bandas);

        long maxId = 0;
        for (Banda banda : bandas) {
            if (banda.getId() > maxId) {
                maxId = banda.getId();
            }
        }
        this.secuencia = new AtomicLong(maxId);


    }

    @Override
    public List<Banda>listBandas(){
        return bandas;
    }


    @Override
    public Banda listaBandaId(Long id){
        for (Banda banda : bandas){
            if (banda.getId().equals(id)){
                return banda;
            }
        }
        throw new NotFoundException("");
    }

    @Override
    public void delBanda(Long id){

        Banda banda = listaBandaId(id);

        bandas.remove(banda);

    }

    @Override
    public Banda addBanda(BandaDto dto){

        validarBanda(dto, null);

        Banda banda = new Banda();

        banda.setId(secuencia.incrementAndGet());
        banda.setNombre(dto.getNombre());
        banda.setCategoria(dto.getCategoria());
        banda.setIntregantes(dto.getIntregantes());

        bandas.add(banda);


        return banda;
    }


    @Override
    public Banda updateBanda(Long id, BandaDto bn){


        Banda banda = listaBandaId(id);

        validarBanda(bn , id);

        banda.setNombre(bn.getNombre());
        banda.setCategoria(bn.getCategoria());
        banda.setIntregantes(bn.getIntregantes());

        return banda;
    }

    public List<Banda> buscarPorNombre(String nombre) {
        List<Banda> resultado = new ArrayList<>();

        for (Banda banda : bandas) {
            if (banda.getNombre().toLowerCase().contains(nombre.trim().toLowerCase())) {
                resultado.add(banda);
            }
        }
        return resultado;
    }

    public List<Banda> buscarMenosIntegrantes(int max) {
        List<Banda> resultado = new ArrayList<>();

        for (Banda banda : bandas) {
            if (banda.getIntregantes() < max) {
                resultado.add(banda);
            }
        }
        return resultado;
    }

    //Validar
    private void validarBanda(BandaDto banda, Long id) {

        if (banda.getNombre() == null || banda.getNombre().isBlank()) {
            throw new BadRequestException("El nombre de la banda no puede estar vacío");
        }

        if (banda.getIntregantes() <= 0) {
            throw new ValidateException("La banda debe tener al menos un integrante");
        }

        if (banda.getCategoria() == null) {
            throw new BadRequestException("La categoría no puede estar vacía");
        }
        for (Banda b : bandas) {

            if (b.getNombre().equalsIgnoreCase(banda.getNombre())
                    && !b.getId().equals(id)) {

                throw new ConflictException("Ya existe una banda con ese nombre");
            }
        }

    }
//    private void validarBanda(BandaDto banda, Long id) {
//
//        if (banda.getNombre() == null || banda.getNombre().isBlank()) {
//            throw new ValidateException("El nombre de la banda no puede estar vacío");
//        }
//        if (banda.getIntregantes() <= 0) {
//            throw new ValidateException("La banda debe tener al menos un integrante");
//        }
//        if (banda.getCategoria() == null) {
//            throw new ValidateException("La categoría no puede estar vacía");
//        }
//
//        for (Banda b : bandas) {
//            boolean esOtra = id == null || !b.getId().equals(id);
//
//            if (esOtra && b.getNombre().equalsIgnoreCase(banda.getNombre().trim())) {
//                throw new ConflictException("Ya existe una banda con ese nombre");
//            }
//        }


}
