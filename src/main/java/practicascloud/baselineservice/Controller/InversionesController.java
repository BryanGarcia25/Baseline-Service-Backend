package practicascloud.baselineservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practicascloud.baselineservice.Model.InversionCalculada;
import practicascloud.baselineservice.Model.Inversiones;
import practicascloud.baselineservice.Service.InversionesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/inversiones")
public class InversionesController {

    @Autowired
    private InversionesService inversionesService;
    
    @PostMapping(value = "/calcularInversion")
    public List<InversionCalculada> inversionRecibida(@RequestBody Inversiones datosInversion) {
        //llamamos al metodo que se encuentra en nuestro servicio
        return inversionesService.calculandoInversion(datosInversion); //Retorna nuestra lista de inversiones y es enviada a nuestro frontend
    }

}