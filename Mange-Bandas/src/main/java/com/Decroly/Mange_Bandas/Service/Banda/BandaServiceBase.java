package com.Decroly.Mange_Bandas.Service.Banda;

import com.Decroly.Mange_Bandas.domain.Banda;
import com.Decroly.Mange_Bandas.exceptions.NotFoundException;
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
    public Banda addBanda(Banda banda){

        banda.setId(secuencia.incrementAndGet());

        bandas.add(banda);

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

}
