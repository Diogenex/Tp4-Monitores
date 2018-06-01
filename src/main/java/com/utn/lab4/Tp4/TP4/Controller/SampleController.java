package com.utn.lab4.Tp4.TP4.Controller;

import com.utn.lab4.Tp4.TP4.Model.UserLogs;
import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.utn.lab4.Tp4.TP4.Repository.LogsService;

import java.util.Hashtable;
import java.util.List;


@RestController
public class SampleController {

    @Autowired
    private LogsService sampleService;

    @Autowired
    private UserAgentAnalyzer userA;

    //ENDPOINT que devuelve una List con todos los logeos de los clientes.
    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public List user() {
        List<UserLogs> allusers = sampleService.getAll();
        return allusers;
    }
    //ENDPOINT que devuelve una hashtable con el numero de veces que se logearon con los distintos navegadores.
    @RequestMapping(value = "/navegadores", method = RequestMethod.GET)
        public Hashtable navegadoresUtilizados (){
        return sampleService.navegadoresUtilizados();
    }

    //ENDPOINT que devuelve una hashtable con los sistemas operativos utilizados por el cliente y el numero de veces si se repitio el uso
    @RequestMapping(value = "/sistemasO", method = RequestMethod.GET)
        public Hashtable sitemasOUtilizados (){
        return sampleService.sOUtilizados();
    }

    //ENDPOINT que devuelve un String con el sistema operativo mas utilizado (NO SE LLEGó a conseguir la correcta funcionalidad)
    @RequestMapping(value = "/sistemaOmasUtilizado", method = RequestMethod.GET)
    public String sitemaOmasUtilizado (){
        return sampleService.sOmasUtilizado();
    }

    //ENDPOINT que devuelve una lista con los navegadores ordenados del mas utilizado hacia abajo.
    @RequestMapping(value = "/navegadorMasUtilizado", method = RequestMethod.GET)
    public List navegadormasUtilizado (){
        return sampleService.navegadorMasUtilizado();
    }

    //ENDPOINT que devuelve una hashtable con el numero de veces que se usaron las combinaciones del mismo del sistema operativo y navegador.
    @RequestMapping(value = "/combinacionUtilizados", method = RequestMethod.GET)
    public Hashtable combinacionUtilizados (){
        return sampleService.sOyNavegadorUtilizados();
    }

    //ENDPOINT donde se capturan los datos del cliente por medio del User-Agent
    @RequestMapping(value = "/index")
    public String index(
            @RequestHeader(value="User-Agent") String useragent) {
            UserAgent userAgent = this.userA.parse(useragent);
            sampleService.registrarLog(userAgent);
            return "Bienvenido al Sitio";
    }
}


