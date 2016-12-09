package dao;

import entidade.Paciente;

public class PacienteDAO extends GenericDAO<Paciente> {
    
    public PacienteDAO() {
        super(Paciente.class);
    }
}
