package ui;

import domain.Consulta;
import domain.Medico;
import domain.Paciente;
import service.AgendaService;
import dao.jdbc.ConsultaJdbcRepository;
import dao.jdbc.MedicoDao;
import dao.jdbc.PacienteDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleMain {
    static final DateTimeFormatter PADRAO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", new Locale("pt", "BR"));

    public static void runConsole(){
        Scanner sc = new Scanner(System.in);
        PacienteDao pacienteDao = new PacienteDao();

        System.out.println("----//---- Bem vindo ao Sistema de Consultório! ----//----");
        System.out.println("--> O que deseja fazer hoje? ");
        System.out.println("1- Inserir registro de médico");
        System.out.println("2- Inserir registro de paciente");
        System.out.println("3- Agendar consulta");
        System.out.println("4- Listar Todos os Pacientes");

        int option = sc.nextInt();

        switch(option){
            case 1:
                insereMedico();
                break;

            case 2:
                inserePaciente();
                break;

            case 3:
                agendaConsulta();
                break;

            case 4:
                System.out.println("----// Lista de pacientes //----");
                pacienteDao.listarTodos().forEach(paciente -> System.out.println(paciente.getId() + " - " + paciente.getNome() + " - " + paciente.getEmail()));
                break;

            default:
                System.out.println("Opção inválida! Escolha outra!");
                break;
        }
    }

    public static void insereMedico(){
        var medicoDAO = new MedicoDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o nome do médico: ");
        String nomeMedico = sc.nextLine();

        System.out.println("Insira o CRM do médico: ");
        String CRMMedico = sc.nextLine();

        try {
            var medico = new Medico(null, nomeMedico, CRMMedico);
            medicoDAO.salvar(medico);
        } catch (Exception e){
            System.out.println("Erro ao tentar inserir um médico.");
        }
    }

    public static void inserePaciente(){
        var pacienteDAO = new PacienteDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o nome do paciente: ");
        String nomePaciente = sc.nextLine();

        System.out.println("Insira o email do paciente: ");
        String emailPaciente = sc.nextLine();

        try {
            var paciente = new Paciente(null, nomePaciente, emailPaciente);
            pacienteDAO.salvar(paciente);
        } catch(Exception e){
            System.out.println("Erro ao tentar inserir um paciente.");
        }
    }

    public static void agendaConsulta(){
        // Cria o repositório (implementação JDBC)
        var repo = new ConsultaJdbcRepository();
        var service = new AgendaService(repo);
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Insira o ID do paciente: ");
            Long idPaciente = Long.parseLong(in.nextLine().trim());

            System.out.println("Insira o ID do médico: ");
            Long idMedico = Long.parseLong(in.nextLine().trim());

            System.out.print("Início da consulta (dd/MM/yyyy HH:mm): ");
            LocalDateTime inicio = LocalDateTime.parse(in.nextLine().trim(), PADRAO);

            System.out.print("Duração em minutos (ex.: 30): ");
            int duracaoMin = Integer.parseInt(in.nextLine().trim());
            LocalDateTime fim = inicio.plusMinutes(duracaoMin);

            var consulta = new Consulta(null, idPaciente, idMedico, inicio, fim);

            try {
                Long id = service.agendar(consulta);
                System.out.println("Consulta agendada com sucesso! ID = " + id);
            } catch (Exception e) {
                System.err.println("Erro ao agendar consulta: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Erro ao agendar consulta: " + e.getMessage());
        }
    }
}
