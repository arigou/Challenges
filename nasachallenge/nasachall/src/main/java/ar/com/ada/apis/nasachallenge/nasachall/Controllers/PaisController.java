package ar.com.ada.apis.nasachallenge.nasachall.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ar.com.ada.apis.nasachallenge.nasachall.Services.PaisService;
import ar.com.ada.apis.nasachallenge.nasachall.entities.Pais;
import ar.com.ada.apis.nasachallenge.nasachall.model.req.PaisReq;
import ar.com.ada.apis.nasachallenge.nasachall.model.resp.PaisResp;

/**
 * PaisController
 */
@RestController
public class PaisController {

    @Autowired
    PaisService paisService; 

    @PostMapping("/pais")
    public PaisResp postRegistroPais(@RequestBody PaisReq req){


        PaisResp r = new PaisResp();
        paisService.ingresarPais(req.codigoPais, req.nombrePais);

        r.message = "Pais ingresado";

        return r;
        
    }
   

    @GetMapping("/paises")
    public List<Pais> getPais() {
        List<Pais> lp = paisService.getPais();

        return lp;
    }

    @GetMapping("/paises/{id}")
    public Pais getPaisById(@PathVariable int id) {
        Pais p = paisService.buscarPorCodigoPais(id);

        return p;
    }

    
}