package com.ph3.form.persona;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.FaseDAO;
import com.ph3.dao.GrupoDAO;
import com.ph3.dao.MotivoDAO;
import com.ph3.dao.PersonaDAO;
import com.ph3.dao.ProgramaDAO;
import com.ph3.dao.RecorridoDAO;
import com.ph3.dao.TratamientoDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Fase;
import com.ph3.vo.Grupo;
import com.ph3.vo.Motivo;
import com.ph3.vo.Persona;
import com.ph3.vo.Programa;
import com.ph3.vo.Recorrido;
import com.ph3.vo.Tratamiento;

public class InsertarPersonaRecorrido3Accion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String activo = "1"; // al ser insercción siempre estará activo por defecto
        String idTratamiento = request.getParameter("tratamiento");
        String idPrograma = request.getParameter("programa");
        String idFase = request.getParameter("fase");
        String idGrupo = request.getParameter("grupo");
        String idMotivo = request.getParameter("motivo");

        System.out.println("\nEmpezamos: " + nombre + " " + apellido1 + " " + apellido2 + " " + activo);
        System.out.println("\nSeguimos:");
        System.out.println("tratamiento: " + idTratamiento);
        System.out.println("programa: " + idPrograma);
        System.out.println("fase: " + idFase);
        System.out.println("grupo: " + idGrupo);
        System.out.println("motivo: " + idMotivo);

        // Persona objetoPersona = new Persona(nombre, apellido1, apellido2, activo, null, null);
        PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
        Persona persona = personaDAO.buscarNombreApellido1Apellido2(nombre, apellido1, apellido2);

        persona.setActivo(activo);

        Date fechaInicio = null;
        // Date fechaFin = null;
        // DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fechaInicio = Calendar.getInstance().getTime();
        // fechaFin = sdf.parse(request.getParameter("fechaDeFin"));

        TratamientoDAO tratamientoDAO = DAOFactory.getTratamientoDAO();
        Tratamiento tratamiento = tratamientoDAO.buscarPorClave(Integer.valueOf(idTratamiento));
        ProgramaDAO programaDAO = DAOFactory.getProgramaDAO();
        Programa programa = programaDAO.buscarPorClave(Integer.valueOf(idPrograma));
        FaseDAO faseDAO = DAOFactory.getFaseDAO();
        Fase fase = faseDAO.buscarPorClave(Integer.valueOf(idFase));
        GrupoDAO grupoDAO = DAOFactory.getGrupoDAO();
        Grupo grupo = grupoDAO.buscarPorClave(Integer.valueOf(idGrupo));
        MotivoDAO motivoDAO = DAOFactory.getMotivoDAO();
        Motivo motivo = motivoDAO.buscarPorClave(Integer.valueOf(idMotivo));

        RecorridoDAO recorridoDAO = DAOFactory.getRecorridoDAO();
        Recorrido recorrido = new Recorrido(fase, grupo, motivo, persona, programa, tratamiento, fechaInicio, null, activo);
        personaDAO.salvar(persona);
        recorridoDAO.salvar(recorrido);

        return "protegido/admin/form/ingresos/grabarIngreso.jsp";
    }

}
