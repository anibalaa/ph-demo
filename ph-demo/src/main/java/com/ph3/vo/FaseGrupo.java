package com.ph3.vo;
// Generated 16-may-2017 16:53:13 by Hibernate Tools 4.3.1.Final

/**
 * FaseGrupo generated by hbm2java
 */
public class FaseGrupo implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer idFaseGrupo;
    private Fase fase;
    private Grupo grupo;

    public FaseGrupo() {
    }

    public FaseGrupo(Fase fase, Grupo grupo) {
        this.fase = fase;
        this.grupo = grupo;
    }

    public Integer getIdFaseGrupo() {
        return this.idFaseGrupo;
    }

    public void setIdFaseGrupo(Integer idFaseGrupo) {
        this.idFaseGrupo = idFaseGrupo;
    }

    public Fase getFase() {
        return this.fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Grupo getGrupo() {
        return this.grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

}