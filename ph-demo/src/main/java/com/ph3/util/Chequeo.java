package com.ph3.util;

import java.util.List;

import com.ph3.vo.Persona;
import com.ph3.vo.Recorrido;

public class Chequeo {

    public Chequeo() {

    }
    // buscar en todos los recorridos de una persona si no están activos, en ese caso poner activo 0 en persona
    public void buscarRecorridosActivosDeUnaPersona(Persona persona, List<Recorrido> listaDeRecorridos) {
        System.out.println("Estramos en CHEQUEO ******");
        int cont = 0;
        for (Recorrido r : listaDeRecorridos) {
            System.out.println(r.getActivo());
            if (r.getActivo().equals("1")){
                cont++;
            }
        }
        System.out.println("cont: " + cont);
        if (cont == 0) {
            System.out.println("Activo Persona DESactivado");
            persona.setActivo("0");
        }else {
            System.out.println("Activo Persona activado");
            persona.setActivo("1");
        }
    }
}
