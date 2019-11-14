package ar.com.ada.apis.nasachallenge.nasachall.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.apis.nasachallenge.nasachall.entities.Pais;

/**
 * PaisRepository
 */
@Repository
public interface PaisRepository extends JpaRepository <Pais, Integer> {

    Pais findByNombrePais(String nombrePais);

    Pais findByCodigoPais (int codigoPais); 
    
}