package com.example.clinic;

import com.example.clinic.domain.model.Consulta;
import com.example.clinic.domain.model.Medico;
import com.example.clinic.domain.model.Paciente;
import com.example.clinic.domain.service.AgendaService;
import com.example.clinic.infra.dao.ConsultaJdbcRepository;
import com.example.clinic.infra.dao.MedicoDao;
import com.example.clinic.infra.dao.PacienteDao;

import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("----//---- Bem vindo ao Sistema de Consultório! ----//----");
        System.out.println("--> O que deseja fazer hoje? ");
        System.out.println("1- Inserir registro de médico");
        System.out.println("2- Inserir registro de paciente");
        System.out.println("3- Agendar consulta");

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
            default:
                System.out.println("Opção inválida! Escolha outra!");
        }
    }

    public static void insereMedico(){
        var medicoDAO = new MedicoDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o nome do médico: ");
        String nomeMedico = sc.nextLine();

        System.out.println("Insira o CRM do médico: ");
        String CRMMedico = sc.nextLine();

        var medico = new Medico(null, nomeMedico, CRMMedico);
        medicoDAO.salvar(medico);
    }

    public static void inserePaciente(){
        var pacienteDAO = new PacienteDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o nome do paciente: ");
        String nomePaciente = sc.nextLine();

        System.out.println("Insira o email do paciente: ");
        String emailPaciente = sc.nextLine();

        var paciente = new Paciente(null, nomePaciente, emailPaciente);
        pacienteDAO.salvar(paciente);
    }

    public static void agendaConsulta(){
        // Cria o repositório (implementação JDBC)
        var repo = new ConsultaJdbcRepository();
        var service = new AgendaService(repo);
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o ID do paciente: ");
        Long idPaciente = sc.nextLong();

        System.out.println("Insira o ID do médico: ");
        Long idMedico = sc.nextLong();

        // Define horário da consulta (válido)
        var inicio = LocalDateTime.now().plusHours(2).withHour(10).withMinute(0).withSecond(0).withNano(0);
        var fim = inicio.plusMinutes(30);

        var consulta = new Consulta(null, idPaciente, idMedico, inicio, fim);

        try {
            Long id = service.agendar(consulta);
            System.out.println("Consulta agendada com sucesso! ID = " + id);
        } catch (Exception e) {
            System.err.println("Erro ao agendar consulta: " + e.getMessage());
        }
    }
}
