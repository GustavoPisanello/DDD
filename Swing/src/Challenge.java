import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Challenge {


    enum ComponentType {
        LABEL,
        TEXTFIELD,
        TEXTAREA,
        CHECKBOX,
        BUTTON,
        RADIOBUTTON,
        BUTTONGROUP
    }

    public static void createElement(ComponentType componentType, String label, JPanel panel){
        Scanner sc = new Scanner(System.in);
        JComponent component = null;

        switch (componentType){
            case LABEL:
                component = new JLabel(label);
                break;

            case TEXTFIELD:
                System.out.println("Digite o número de colunas do TextField: ");
                int columns = sc.nextInt();
                component = new JTextField(columns);
                break;

            case TEXTAREA:
                System.out.println("Digite o número de linhas do TextArea: ");
                int rows = sc.nextInt();

                System.out.println("Digite o número de colunas do TextArea: ");
                int tcolumns = sc.nextInt();

                component = new JTextArea(rows, tcolumns);
                break;

            case CHECKBOX:
                component = new JCheckBox(label);
                break;

            case RADIOBUTTON:
                component = new JRadioButton(label);
                break;

            case BUTTON:
                component = new JButton(label);
        }

        panel.add(component);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Formulário de contato");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel nomeLabel = new JLabel("Nome: ");
        JTextField nomeField = new JTextField(20);

        JLabel comentarioLabel = new JLabel("Comentário");
        JTextArea comentarioArea = new JTextArea(5, 20);

        JCheckBox interesseAWS = new JCheckBox("Tem interese em AWS?");
        JRadioButton radioSim = new JRadioButton("Sim");
        JRadioButton radioNao = new JRadioButton("Não");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioSim);
        grupo.add(radioNao);

        JButton enviarButton = new JButton("Enviar");

        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(comentarioLabel);
        panel.add(comentarioArea);
        panel.add(interesseAWS);
        panel.add(radioSim);
        panel.add(radioNao);
        panel.add(enviarButton);

        createElement(ComponentType.TEXTFIELD, "Digite um número: ", panel);
        createElement(ComponentType.BUTTON, "Tem interese em AWS?", panel);



        enviarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String comentario = comentarioArea.getText();
            System.out.println("Nome: " + nome + ", Comentário: " + comentario);
        });



        frame.add(panel);
        frame.setVisible(true);
    }



}
