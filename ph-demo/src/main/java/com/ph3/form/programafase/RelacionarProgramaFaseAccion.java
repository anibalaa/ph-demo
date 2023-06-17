package com.ph3.form.programafase;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ph3.util.Accion;
import com.ph3.util.DAOFactory;
import com.ph3.vo.FaseGrupo;
import com.ph3.vo.ProgramaFase;

public class RelacionarProgramaFaseAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        
        
        
        
        return "protegido/admin/form/programafases/mostrarProgramaFaseRelacionados.jsp";
    }

    
    
    
    
    
    
}
