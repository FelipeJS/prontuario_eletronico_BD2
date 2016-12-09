package entidade;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Cirurgia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String procedimento;
    @ManyToOne
    private Atendimento atendimento;
    @Column(name = "data_cirurgia")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataCirurgia;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public Calendar getDataCirurgia() {
        return dataCirurgia;
    }

    public void setDataCirurgia(Calendar dataCirurgia) {
        this.dataCirurgia = dataCirurgia;
    }
    
}
