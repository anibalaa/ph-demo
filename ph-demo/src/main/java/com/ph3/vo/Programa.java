package com.ph3.vo;
// Generated 16-may-2017 16:53:13 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Programa generated by hbm2java
 */
public class Programa implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer idPrograma;
    private String descripcion;
    private Set<ProgramaFase> programaFases = new HashSet<ProgramaFase>(0);
    private Set<Recorrido> recorridos = new HashSet<Recorrido>(0);
    private Set<TratamientoPrograma> tratamientoProgramas = new HashSet<TratamientoPrograma>(0);

    public Programa() {
    }

    public Programa(String descripcion, Set<ProgramaFase> programaFases, Set<Recorrido> recorridos, Set<TratamientoPrograma> tratamientoProgramas) {
        this.descripcion = descripcion;
        this.programaFases = programaFases;
        this.recorridos = recorridos;
        this.tratamientoProgramas = tratamientoProgramas;
    }

    public Integer getIdPrograma() {
        return this.idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<ProgramaFase> getProgramaFases() {
        return this.programaFases;
    }

    public void setProgramaFases(Set<ProgramaFase> programaFases) {
        this.programaFases = programaFases;
    }

    public Set<Recorrido> getRecorridos() {
        return this.recorridos;
    }

    public void setRecorridos(Set<Recorrido> recorridos) {
        this.recorridos = recorridos;
    }

    public Set<TratamientoPrograma> getTratamientoProgramas() {
        return this.tratamientoProgramas;
    }

    public void setTratamientoProgramas(Set<TratamientoPrograma> tratamientoProgramas) {
        this.tratamientoProgramas = tratamientoProgramas;
    }

}
