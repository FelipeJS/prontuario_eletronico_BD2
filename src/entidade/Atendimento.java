/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @ManyToOne
    private Prestador prestador;
    @ManyToOne
    private Paciente paciente;
    @Column(name = "tipo_atendimento")
    private String tipoAtendimento;
    private String diagnostico;
    @Column(name = "data_atendimento")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataAtendimento;
    @Column(name = "data_alta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataAlta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Calendar getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Calendar dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Calendar getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Calendar dataAlta) {
        this.dataAlta = dataAlta;
    }

}
