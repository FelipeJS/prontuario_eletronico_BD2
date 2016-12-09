package entidade;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Prescricao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    private String prescricao;
    @ManyToOne
    private Atendimento atendimento;
    @Column(name = "data_prescricao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataPrescricao;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public Calendar getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(Calendar dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }
    
}
