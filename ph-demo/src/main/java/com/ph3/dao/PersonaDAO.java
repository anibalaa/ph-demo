package com.ph3.dao;

import java.util.List;

import com.ph3.util.GenericDAO;
import com.ph3.vo.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Integer> {

    public List<Persona> buscarApellidosPorNombre(String str);
    public Persona buscarNombreApellido1Apellido2(String nombre, String apellido1, String apellido2);
}
