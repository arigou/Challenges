package ar.com.ada.apis.nasachallenge.nasachall.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.apis.nasachallenge.nasachall.entities.Temperatura;

/**
 * TemperaturaRepository
 */
@Repository
public interface TemperaturaRepository extends JpaRepository <Temperatura, Integer> {

    
}