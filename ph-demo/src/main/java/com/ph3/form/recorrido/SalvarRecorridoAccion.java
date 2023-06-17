package com.ph3.form.recorrido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.dao.FaseDAO;
import com.ph3.dao.FaseGrupoDAO;
import com.ph3.dao.GrupoDAO;
import com.ph3.dao.MotivoDAO;
import com.ph3.dao.PersonaDAO;
import com.ph3.dao.ProgramaDAO;
import com.ph3.dao.ProgramaFaseDAO;
import com.ph3.dao.RecorridoDAO;
import com.ph3.dao.TratamientoDAO;
import com.ph3.dao.TratamientoProgramaDAO;
import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.Fase;
import com.ph3.vo.FaseGrupo;
import com.ph3.vo.Grupo;
import com.ph3.vo.Motivo;
import com.ph3.vo.Persona;
import com.ph3.vo.Programa;
import com.ph3.vo.ProgramaFase;
import com.ph3.vo.Recorrido;
import com.ph3.vo.Tratamiento;
import com.ph3.vo.TratamientoPrograma;

public class SalvarRecorridoAccion extends Accion {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        Integer idRecorrido = Integer.valueOf(request.getParameter("idRecorrido").trim());
        String nombre = request.getParameter("nombre").trim();
        String apellido1 = request.getParameter("apellido1").trim();
        String apellido2 = request.getParameter("apellido2").trim();

        String activo = null;
        if (request.getParameter("activo") != null) {
            System.out.println("Entramos en activo != null");
            activo = "1";
        } else {
            System.out.println("Entramos en activo = 0");
            activo = "0";
        }

        String idTratamiento = request.getParameter("tratamiento").trim();
        String idPrograma = request.getParameter("programa").trim();
        String idFase = request.getParameter("fase").trim();
        String idGrupo = request.getParameter("grupo").trim();
        String idMotivo = request.getParameter("motivo").trim();

        System.out.println("\nEmpezamos: " + nombre + " " + apellido1 + " " + apellido2 + " " + activo);
        System.out.println("\nSeguimos:");
        System.out.println("tratamiento: " + idTratamiento);
        System.out.println("programa: " + idPrograma);
        System.out.println("fase: " + idFase);
        System.out.println("grupo: " + idGrupo);
        System.out.println("motivo: " + idMotivo);

        PersonaDAO personaDAO = DAOFactory.getPersonaDAO();
        Persona persona = personaDAO.buscarNombreApellido1Apellido2(nombre, apellido1, apellido2);

        try {
            persona.setActivo(activo);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            System.out.println("Excepción en activo");
            e1.printStackTrace();
        }

        Date fechaInicio = null;
        Date fechaFin = null;
        // SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println(request.getParameter("fechaDeInicio"));
            if (request.getParameter("fechaDeInicio") == "" || request.getParameter("fechaDeInicio") == null) {
                System.out.println("Entramos por fdi nulo");
                fechaInicio = null;
            } else {
                System.out.println("Entramos por fdi getParam");
                fechaInicio = sdf.parse(request.getParameter("fechaDeInicio"));
            }
            System.out.println(request.getParameter("fechaDeFin"));
            if (request.getParameter("fechaDeFin") == "" || request.getParameter("fechaDeFin") == null) {
                System.out.println("Entramos por fdf nulo");
                fechaFin = null;
            } else {
                System.out.println("Entramos por fdf getParam");
                fechaFin = sdf.parse(request.getParameter("fechaDeFin"));
            }
        } catch (ParseException e) {
            System.err.println("Error con las fechas");
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

        // parrafo que comprueba si no están relacionados el tratamiento y fase elegidos. En ese caso, los relaciona grabandolos en la tabla TratamientoPrograma
        TratamientoProgramaDAO tratamientoProgramaDAO = DAOFactory.getTratamientoProgramaDAO();
        TratamientoPrograma tratamientoPrograma = null;
        List<TratamientoPrograma> listaDeTratamientoProgramas = tratamientoProgramaDAO.buscarTratamientoProgramasRelacionados(Integer.valueOf(idTratamiento), Integer.valueOf(idPrograma));
        System.out.println("Lista de TP:\n" + listaDeTratamientoProgramas);
        if (listaDeTratamientoProgramas.isEmpty()) {
            System.out.println("Entrando por TP nulo");
            tratamientoPrograma = new TratamientoPrograma(programa, tratamiento);
            tratamientoProgramaDAO.insertar(tratamientoPrograma);
            System.out.println("*** INSERTADO ***");
        }

        // parrafo que comprueba si no están relacionados el programa y la fase elegidos. En ese caso, los relaciona grabandolos en la tabla ProgramaFase
        ProgramaFaseDAO programaFaseDAO = DAOFactory.getProgramaFaseDAO();
        ProgramaFase programaFase = null;
        List<ProgramaFase> listaDeProgramaFases = programaFaseDAO.buscarProgramaFasesRelacionadas(Integer.valueOf(idPrograma), Integer.valueOf(idFase));
        System.out.println("Lista de PF:\n" + listaDeProgramaFases);
        if (listaDeProgramaFases.isEmpty()) {
            System.out.println("Entrando por PF nulo");
            programaFase = new ProgramaFase(fase, programa);
            programaFaseDAO.insertar(programaFase);
            System.out.println("*** INSERTADO ***");
        }

        // parrafo que comprueba si no están relacionados la fase y el grupo elegidos. En ese caso, los relaciona grabandolos en la tabla FaseGrupo
        FaseGrupoDAO faseGrupoDAO = DAOFactory.getFaseGrupoDAO();
        FaseGrupo faseGrupo = null;
        List<FaseGrupo> listaDeFaseGrupos = faseGrupoDAO.buscarFaseGruposRelacionados(Integer.valueOf(idFase), Integer.valueOf(idGrupo));
        System.out.println("Lista de FG:\n" + listaDeFaseGrupos);
        if (listaDeFaseGrupos.isEmpty()) {
            System.out.println("Entrando por FG nulo");
            faseGrupo = new FaseGrupo(fase, grupo);
            faseGrupoDAO.insertar(faseGrupo);
            System.out.println("*** INSERTADO ***");
        }

        RecorridoDAO recorridoDAO = DAOFactory.getRecorridoDAO();
        Recorrido recorrido = recorridoDAO.buscarPorClave(idRecorrido);

        recorrido.setFase(fase);
        recorrido.setGrupo(grupo);
        recorrido.setMotivo(motivo);
        recorrido.setPersona(persona);
        recorrido.setPrograma(programa);
        recorrido.setTratamiento(tratamiento);
        recorrido.setFechaInicio(fechaInicio);
        recorrido.setFechaFin(fechaFin);
        recorrido.setActivo(activo);

        recorridoDAO.salvar(recorrido);

        request.setAttribute("listaDeRecorridos", recorridoDAO.buscarTodos());
        return "protegido/admin/form/recorridos/mostrarRecorridos.jsp";
    }

}
