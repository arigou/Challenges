package ar.com.ada.apis.nasachallenge.nasachall.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.apis.nasachallenge.nasachall.entities.Pais;
import ar.com.ada.apis.nasachallenge.nasachall.repo.PaisRepository;

/**
 * PaisService
 */
@Service
public class PaisService {

    @Autowired
    PaisRepository paisRepo;

    public Pais ingresarPais(int codigoPais, String nombrePais) {
        Pais p = new Pais();
        p.setCodigoPais(codigoPais);
        p.setNombrePais(nombrePais);

        paisRepo.save(p);

        return p;
    }

    public void savePais(Pais pais) {


        paisRepo.save(pais);
    }

    public List<Pais> getPais() {

        return paisRepo.findAll();
    }

    public Pais buscarPorCodigoPais(int id) {

        Optional<Pais> c = paisRepo.findById(id);

        if (c.isPresent())
            return c.get();
        return null;
    }

    public Pais buscarPorNombrePais(String nombrePais) {
        return paisRepo.findByNombrePais(nombrePais);
    }

    public enum PaisValidationType {

        PAIS_OK, PAIS_DATOS_INVALIDOS, PAIS_DUPLICADO

    }

    public PaisValidationType verificarPais(Pais pais) {

        if (pais.getNombrePais() == null)
            return PaisValidationType.PAIS_DATOS_INVALIDOS;

        if (pais.getCodigoPais() <= 0)
            return PaisValidationType.PAIS_DATOS_INVALIDOS;

        Pais p = paisRepo.findByCodigoPais(pais.getCodigoPais());
        if (p != null) {
            if (pais.getCodigoPais() <= 0) {

                if ((pais.getCodigoPais()) == (p.getCodigoPais())) {
                    return PaisValidationType.PAIS_DUPLICADO;
                } else {
                    return PaisValidationType.PAIS_OK;
                }
            } else {
                return PaisValidationType.PAIS_DATOS_INVALIDOS;
            }
        }

        return PaisValidationType.PAIS_OK; 
    }
}