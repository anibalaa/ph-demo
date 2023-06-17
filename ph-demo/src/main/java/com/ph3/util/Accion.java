package com.ph3.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion {

    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);

    public static Accion getAccion(String tipo) {
        Accion accion = null;

        try {
            accion = (Accion) Class.forName(buscaRuta(tipo) + "." + tipo + "Accion").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return accion;

    }

    private static String buscaRuta(String tipo) {

        if (tipo.indexOf("Motivo") != -1)
            return "com.ph3.form.motivo";
        if (tipo.indexOf("Persona") != -1)
            return "com.ph3.form.persona";
        if (tipo.indexOf("Recorrido") != -1)
            return "com.ph3.form.recorrido";
        if (tipo.indexOf("TratamientoPrograma") != -1)
            return "com.ph3.form.tratamientoprograma";
        if (tipo.indexOf("ProgramaFase") != -1)
            return "com.ph3.form.programafase";
        if (tipo.indexOf("FaseGrupo") != -1)
            return "com.ph3.form.fasegrupo";
        if (tipo.indexOf("Tratamiento") != -1)
            return "com.ph3.form.tratamiento";
        if (tipo.indexOf("Programa") != -1)
            return "com.ph3.form.programa";
        if (tipo.indexOf("Fase") != -1)
            return "com.ph3.form.fase";
        if (tipo.indexOf("Grupo") != -1)
            return "com.ph3.form.grupo";
        if (tipo.indexOf("Rol") != -1)
            return "com.ph3.form.rol";
        if (tipo.indexOf("Agrupacion") != -1)
            return "com.ph3.form.agrupacion";
        // if (tipo.indexOf("Usuario")!=-1) return "com.ph3.form.usuario";
        if (tipo.indexOf("Modelo") != -1)
            return "com.ph3.tmp.modelo";
        return null;
    }

    @SuppressWarnings("unused")
    private static String getPackage() {
        return Accion.class.getPackage().getName();
    }

}
