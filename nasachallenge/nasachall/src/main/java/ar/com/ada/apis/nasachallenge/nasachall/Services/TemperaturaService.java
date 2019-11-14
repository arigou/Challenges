package ar.com.ada.apis.nasachallenge.nasachall.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.apis.nasachallenge.nasachall.entities.Pais;
import ar.com.ada.apis.nasachallenge.nasachall.entities.Temperatura;
import ar.com.ada.apis.nasachallenge.nasachall.repo.TemperaturaRepository;

/**
 * TemperaturaService
 */
@Service
public class TemperaturaService {

    @Autowired
    PaisService paisService;
    @Autowired
    TemperaturaRepository temperaturaRepo;

    public Temperatura registrarTemperatura (int año, Double grados, int codigoId) {
        Pais p = paisService.buscarPorCodigoPais(codigoId);

        Temperatura temperatura = new Temperatura();
        temperatura.setAñoTemperatura(año);
        temperatura.setGrados(grados);
        temperatura.setPais(p);

        temperaturaRepo.save(temperatura);

        return temperatura;

    }

    public List<Temperatura> getTemperatura() {

        return temperaturaRepo.findAll();
    }

    public Temperatura buscarTemperatura(int id) {
        Optional<Temperatura> t = temperaturaRepo.findById(id);

        if (t.isPresent())
            return t.get();
        return null;

    }
}