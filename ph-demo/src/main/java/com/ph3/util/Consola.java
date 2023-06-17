package com.ph3.util;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletRequest;

public class Consola {
    
    public Consola() {
    
    }
    
        
    public void mostrarMapas(ServletRequest request) {
        System.err.println("\n-_- Mostrar mapas -_-\n");
        @SuppressWarnings("unchecked")
		Map<String, String[]> mapaParametros = request.getParameterMap();

        String[] unValor = null;

        for (Entry<String, String[]> entry : mapaParametros.entrySet()) {
            System.out.print("[Key : " + entry.getKey() + "] [Value : ");
            unValor = mapaParametros.get(entry.getKey());
            for (String y : unValor) {
                System.out.print(y + ", ");
            }
            System.out.println("]");
        }
    }

}
