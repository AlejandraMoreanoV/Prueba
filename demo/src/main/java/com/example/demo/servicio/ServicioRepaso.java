package com.example.demo.servicio;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioRepaso {

    public ArrayList<String> doWhile (int a) {
        ArrayList <String> objTraza = new ArrayList();
        do {
            System.out.println("Hola mundo " + a);
            objTraza.add("Hola mundo " + String.valueOf(a));
            a++;
        } while (a < 10);
        return objTraza;
    }

}