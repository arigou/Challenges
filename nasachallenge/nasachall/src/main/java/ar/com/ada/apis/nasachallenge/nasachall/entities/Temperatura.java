package ar.com.ada.apis.nasachallenge.nasachall.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Temperatura
 */
@Entity
@Table(name = "temperatura")
public class Temperatura {

    @Id
    @Column(name = "temperatura_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int temperaturaId;
    //public String pais;
    @Column(name = "año_temperatura")
    public int añoTemperatura;
    public double grados;

    @ManyToOne 
    @JoinColumn(name = "codigo_pais", referencedColumnName = "codigo_pais")
    public Pais pais;



    //get/set
    public int getTemperaturaId() {
        return temperaturaId;
    }

    public void setTemperaturaId(int temperaturaId) {
        this.temperaturaId = temperaturaId;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public int getAñoTemperatura() {
        return añoTemperatura;
    }

    public void setAñoTemperatura(int añoTemperatura) {
        this.añoTemperatura = añoTemperatura;
    }

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }

   

    //const
    public Temperatura() {
    }

    public Temperatura(int temperaturaId, int añoTemperatura, double grados, Pais pais) {
        this.temperaturaId = temperaturaId;
        this.añoTemperatura = añoTemperatura;
        this.grados = grados;
        this.pais = pais;
    }

    
}