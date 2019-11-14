package ar.com.ada.apis.nasachallenge.nasachall.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.apis.nasachallenge.nasachall.Services.TemperaturaService;
import ar.com.ada.apis.nasachallenge.nasachall.entities.Temperatura;
import ar.com.ada.apis.nasachallenge.nasachall.model.req.TemperaturaReq;
import ar.com.ada.apis.nasachallenge.nasachall.model.resp.TemperaturaResp;

/**
 * TemperaturaController
 */
@RestController
public class TemperaturaController {

    @Autowired
    TemperaturaService temperaturaService;

    @PostMapping("temperaturas")
    public TemperaturaResp postRegistroTemperatura(@RequestBody TemperaturaReq req) {

        TemperaturaResp r = new TemperaturaResp();
        
        temperaturaService.registrarTemperatura(req.añoTemperatura, req.grados, req.codigoId);

        r.message = "Temperatura registrada";

        return r;

    }

    @GetMapping("/temperaturas")
    public List<Temperatura> getTemperatura() {

        List<Temperatura> lt = temperaturaService.getTemperatura();

        return lt;
    }

    @GetMapping("/temperaturas/{id}")
    public Temperatura getEmpleadoById(@PathVariable int id) {

        Temperatura t = temperaturaService.buscarTemperatura(id);
        return t;
    }

    @GetMapping("/temperaturas/paises/{paisId}")
        public List<Temperatura> getEmpleadosPorCategoriaId(@PathVariable int paisId){
        
            List<Temperatura> lt = temperaturaService.getTemperatura();
            return lt;
    

        }

    
}