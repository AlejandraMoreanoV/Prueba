package com.example.demo.controlador;


import com.example.demo.servicio.ServicioRepaso;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/controladorRepaso")
public class ControladorRepaso {

    ServicioRepaso servicioRepaso;

    public ControladorRepaso(ServicioRepaso servicioRepaso) {
        this.servicioRepaso = servicioRepaso;
    }

    @ResponseBody
    @RequestMapping(value = "/objTraza")
    public ArrayList<String> doWhile () {
        return servicioRepaso.doWhile(5);
    }

}