package ui;

import domain.Consulta;
import service.AgendaService;
import dao.jdbc.ConsultaJdbcRepository;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SwingMain {
    static final DateTimeFormatter PADRAO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", new Locale("pt", "BR"));

    public static void runSwing() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) { UIManager.setLookAndFeel(info.getClassName()); break; }
            }
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            var repo = new ConsultaJdbcRepository();
            var service = new AgendaService(repo);

            JFrame frame = new JFrame("Agendar Consulta");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12)); // padding geral

            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(6, 6, 6, 6);
            c.fill = GridBagConstraints.HORIZONTAL;

            // Campos mais largos (15 colunas) + dicas
            JTextField txtPaciente = new JTextField(15);
            txtPaciente.setToolTipText("Ex.: 1");
            JTextField txtMedico = new JTextField(15);
            txtMedico.setToolTipText("Ex.: 10");
            JTextField txtInicio = new JTextField(15);   // dd/MM/yyyy HH:mm
            txtInicio.setToolTipText("Formato: dd/MM/yyyy HH:mm (ex.: 21/08/2025 10:00)");
            JTextField txtDuracao = new JTextField(15);  // minutos
            txtDuracao.setToolTipText("Duração em minutos (ex.: 30)");
            JButton btnAgendar = new JButton("Agendar");

            int row = 0;

            // Label
            c.gridx = 0; c.gridy = row; c.weightx = 0; c.gridwidth = 1;
            panel.add(new JLabel("ID Paciente:"), c);
            // Campo (expande)
            c.gridx = 1; c.gridy = row++; c.weightx = 1.0;
            panel.add(txtPaciente, c);

            c.gridx = 0; c.gridy = row; c.weightx = 0;
            panel.add(new JLabel("ID Médico:"), c);
            c.gridx = 1; c.gridy = row++; c.weightx = 1.0;
            panel.add(txtMedico, c);

            c.gridx = 0; c.gridy = row; c.weightx = 0;
            panel.add(new JLabel("Início (dd/MM/yyyy HH:mm):"), c);
            c.gridx = 1; c.gridy = row++; c.weightx = 1.0;
            panel.add(txtInicio, c);

            c.gridx = 0; c.gridy = row; c.weightx = 0;
            panel.add(new JLabel("Duração (min):"), c);
            c.gridx = 1; c.gridy = row++; c.weightx = 1.0;
            panel.add(txtDuracao, c);

            // Botão ocupa as 2 colunas
            c.gridx = 0; c.gridy = row; c.gridwidth = 2; c.weightx = 0;
            panel.add(btnAgendar, c);

            // Deixa Enter como "clique" do botão
            frame.getRootPane().setDefaultButton(btnAgendar);

            btnAgendar.addActionListener(ev -> {
                try {
                    long pacienteId = Long.parseLong(txtPaciente.getText().trim());
                    long medicoId = Long.parseLong(txtMedico.getText().trim());
                    LocalDateTime inicio = LocalDateTime.parse(txtInicio.getText().trim(), PADRAO);
                    int duracaoMin = Integer.parseInt(txtDuracao.getText().trim());
                    LocalDateTime fim = inicio.plusMinutes(duracaoMin);

                    var consulta = new Consulta(null, pacienteId, medicoId, inicio, fim);

                    btnAgendar.setEnabled(false);
                    try {
                        Long id = service.agendar(consulta);
                        JOptionPane.showMessageDialog(frame,
                                "Consulta agendada com sucesso!\nID = " + id,
                                "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                        // Limpa campos e foca no primeiro
                        txtPaciente.setText("");
                        txtMedico.setText("");
                        txtInicio.setText("");
                        txtDuracao.setText("");
                        txtPaciente.requestFocusInWindow();
                    } finally {
                        btnAgendar.setEnabled(true);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Erro ao agendar consulta:\n" + ex.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });

            frame.setContentPane(panel);

            // Define um tamanho mínimo confortável e permite pack (layout bonito)
            frame.pack();
            frame.setMinimumSize(new Dimension(380, 260));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
