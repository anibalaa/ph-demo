package com.ph3.form.recorrido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.PersonaDAO;
import com.ph3.dao.RecorridoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Fase;
import com.ph3.vo.Grupo;
import com.ph3.vo.Motivo;
import com.ph3.vo.Persona;
import com.ph3.vo.Programa;
import com.ph3.vo.Recorrido;
import com.ph3.vo.Tratamiento;

public class InsertarRecorridoAccion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        // Integer idRecorrido = Integer.parseInt(request.getParameter("idRecorrido"));
        @SuppressWarnings("unchecked")
        Map<String, String[]> parametros = request.getParameterMap();
        Set<Entry<String, String[]>> s = parametros.entrySet();
        Iterator<Entry<String, String[]>> it = s.iterator();

        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String activo = request.getParameter("activo");
        String fechaDeInicio = request.getParameter("fechaDeInicio");
        String fechaDeFin = request.getParameter("fechaDeFin");

        System.out.println("\nEmpezamos: " + nombre + " " + apellido1 + " " + apellido2 + " " + activo + " " + fechaDeInicio + " " + fechaDeFin);

        @SuppressWarnings("unused")
        PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
        Persona objetoPersona = new Persona(nombre, apellido1, apellido2, activo, null, null);
        // personaDAO.insertar(persona); FUNCIONA, por eso está comentada

        String tratamiento = null;
        String programa = null;
        String fase = null;
        String grupo = null;
        String motivo = null;

        while (it.hasNext()) {
            Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it.next();

            String key = entry.getKey();
            String[] value = entry.getValue();

            System.out.println("Key is " + key);
            if (value.length > 1) {
                for (int i = 0; i < value.length; i++) {
                    tratamiento = value[0];
                    programa = value[1];
                    fase = value[2];
                    grupo = value[3];
                    motivo = value[4];
                    System.out.println(value[i].toString());
                }
            } else
                System.out.println("Value is " + value[0].toString());
        }

        System.out.println("\nSeguimos:");
        System.out.println("tratamiento: " + tratamiento);
        System.out.println("programa: " + programa);
        System.out.println("fase: " + fase);
        System.out.println("grupo: " + grupo);
        System.out.println("motivo: " + motivo);

        Tratamiento objetoTratamiento = new Tratamiento(tratamiento, null, null);
        Programa objetoPrograma = new Programa(programa, null, null, null);
        Fase objetoFase = new Fase(fase, null, null, null);
        Grupo objetoGrupo = new Grupo(grupo, null, null);
        Motivo objetoMotivo = new Motivo(motivo, null);

        Date fechaInicio = null;
        Date fechaFin = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            fechaInicio = sdf.parse(request.getParameter("fechaDeInicio"));
            fechaFin = sdf.parse(request.getParameter("fechaDeFin"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RecorridoDAO recorridoDAO = DAOFactory.getRecorridoDAO();

        Recorrido objetoRecorrido = new Recorrido(null, null, null, null, null, null, fechaInicio, fechaFin, activo);

        objetoRecorrido.setTratamiento(objetoTratamiento);
        objetoRecorrido.setPrograma(objetoPrograma);
        objetoRecorrido.setFase(objetoFase);
        objetoRecorrido.setGrupo(objetoGrupo);
        objetoRecorrido.setPersona(objetoPersona);
        objetoRecorrido.setMotivo(objetoMotivo);

        recorridoDAO.salvar(objetoRecorrido);

        request.setAttribute("listaDeRecorridos", recorridoDAO.buscarTodos());
        return "protegido/admin/form/recorridos/mostrarRecorridos.jsp";
    }
}
