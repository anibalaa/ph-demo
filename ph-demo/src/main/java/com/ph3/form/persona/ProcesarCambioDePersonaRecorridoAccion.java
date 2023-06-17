package com.ph3.form.persona;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

public class ProcesarCambioDePersonaRecorridoAccion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

        String idTratamiento = request.getParameter("tratamiento");
        String idPrograma = request.getParameter("programa");
        String idFase = request.getParameter("fase");
        String idGrupo = request.getParameter("grupo");
        String idMotivo = request.getParameter("motivo");

        System.out.println("Datos:");
        System.out.println("tratamiento: " + idTratamiento);
        System.out.println("programa: " + idPrograma);
        System.out.println("fase: " + idFase);
        System.out.println("grupo: " + idGrupo);
        System.out.println("motivo: " + idMotivo);

        System.out.println("Fecha de Inicio: " + request.getParameter("fechaDeInicio"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = request.getParameter("fechaDeInicio");

        Date fecha = null;
        try {
            fecha = formatter.parse(fechaInicio);
            System.out.println(fecha);
            System.out.println(formatter.format(fecha));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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

        String activo = "1";
        PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
        Persona persona = personaDAO.buscarPorClave(Integer.valueOf(request.getParameter("idPersona")));
        persona.setActivo(activo); // la persona pasará a tener activado por defecto el activo
        RecorridoDAO recorridoDAO = DAOFactory.getRecorridoDAO();

        System.out.println(request.getParameter("idRecorrido"));
        Recorrido recorridoViejo = DAOFactory.getRecorridoDAO().buscarPorClave(Integer.valueOf(request.getParameter("idRecorrido")));
        recorridoViejo.setFechaFin(fecha);
        // se desactiva el activo por defecto en el viejo recorrido 
        recorridoViejo.setActivo("0");
        // el nuevo recorrido tendrá activado por defecto el activo
        Recorrido recorridoNuevo = new Recorrido(fase, grupo, motivo, persona, programa, tratamiento, fecha, null, activo);
        System.out.println(recorridoViejo);
        System.out.println(recorridoNuevo);
        recorridoDAO.salvar(recorridoViejo);
        recorridoDAO.salvar(recorridoNuevo);
        personaDAO.salvar(persona);

        // return "protegido/admin/form/cambios/grabarCambio.jsp";

        List<Recorrido> listaDeRecorridos = null;
        listaDeRecorridos = recorridoDAO.buscarRecorridosActivosDeUnaPersona(Integer.valueOf(request.getParameter("idPersona")));
        request.setAttribute("listaDeRecorridos", listaDeRecorridos);
        request.setAttribute("persona", personaDAO.buscarPorClave(Integer.valueOf(request.getParameter("idPersona"))));
        
        return "protegido/admin/form/cambios/mostrar_persona_valores.jsp";
    }

}
