package entidade;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Evolucao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String evolucao;
    @ManyToOne
    private Atendimento atendimento;
    @Column(name = "data_evolucao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataEvolucao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public Calendar getDataEvolucao() {
        return dataEvolucao;
    }

    public void setDataEvolucao(Calendar dataEvolucao) {
        this.dataEvolucao = dataEvolucao;
    }

}
