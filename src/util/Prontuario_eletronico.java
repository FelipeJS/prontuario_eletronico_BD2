package util;

import dao.AtendimentoDAO;
import dao.PacienteDAO;
import dao.PrestadorDAO;
import entidade.Atendimento;
import entidade.Paciente;
import entidade.Prestador;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Prontuario_eletronico {

    public static void main(String[] args) {
        salvarPaciente();
        salvarPrestador();
        salvarAtendimento();
        contarAtendimento();
    }
    
    public static void salvarPaciente(){
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setCpf("123456789");
        paciente.setNome("Valdir");
        paciente.setSexo("M");
        paciente.setEndereco("Rua da abadia");
        paciente.setTelefone("62994683718");
        paciente.setDataNascimento(new GregorianCalendar(1993, 8, 3));
        
        new PacienteDAO().save(paciente);
        System.err.println("Paciente salvo com sucesso!");
    }
    
    public static void salvarPrestador(){
        Prestador prestador = new Prestador();
        prestador.setId(1L);
        prestador.setCpf("123456");
        prestador.setCrm("1324");
        prestador.setNome("Wilson Dias");
        prestador.setSexo("M");
        prestador.setEndereco("aparecida de goiania");
        prestador.setTelefone("62998563624");
        prestador.setDataNascimento(new GregorianCalendar(1895, 10, 15));
        
        new PrestadorDAO().save(prestador);
        System.err.println("Prestador salvo com sucesso!");
    }
    
    public static void salvarAtendimento(){
        Atendimento atendimento = new Atendimento();
        atendimento.setId(1L);
        atendimento.setPaciente(new PacienteDAO().findById(1L));
        atendimento.setPrestador(new PrestadorDAO().findById(1L));
        atendimento.setDataAtendimento(Calendar.getInstance());
        atendimento.setTipoAtendimento("Urgencia");
        atendimento.setDiagnostico("Queda de bicicleta");
        
        new AtendimentoDAO().save(atendimento);
        
        System.err.println("Atendimento salvo com sucesso!");
    }
    
    public static void contarAtendimento(){
        System.err.println("Quantidade de atendimentos: " + new AtendimentoDAO().count());
    }
}
