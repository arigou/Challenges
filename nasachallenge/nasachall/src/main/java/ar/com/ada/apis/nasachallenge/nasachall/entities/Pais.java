package ar.com.ada.apis.nasachallenge.nasachall.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Pais
 */
@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @Column(name = "codigo_pais")
    public int codigoPais;
    @Column(name = "nombre_pais")
    public String nombrePais;

    @OneToMany( mappedBy = "pais", cascade = CascadeType.ALL)
    @JsonIgnore
    @LazyCollection (LazyCollectionOption.FALSE)
    private List <Temperatura> temperaturas =  new ArrayList<Temperatura>();


    //get/set
    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public List<Temperatura> getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(List<Temperatura> temperaturas) {
        this.temperaturas = temperaturas;
    }


    //const
    public Pais() {
    }

    public Pais(int codigoPais, String nombrePais, List<Temperatura> temperaturas) {
        this.codigoPais = codigoPais;
        this.nombrePais = nombrePais;
        this.temperaturas = temperaturas;
    }

    
}