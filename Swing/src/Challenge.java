import java.awt.*;
import javax.swing.*;

public class Challenge {

    public enum ComponentType {
        LABEL,
        TEXTFIELD,
        TEXTAREA,
        CHECKBOX,
        BUTTON,
        RADIOBUTTON,
        BUTTONGROUP
    }

    public static void createElement(ComponentType componentType, int rows, int columns, JPanel panel){
        JComponent component = new JTextArea(rows, columns);
        panel.add(component);
    }

    public static void createElement(ComponentType componentType, int columns, JPanel panel){
        JComponent component = new JTextField(columns);
        panel.add(component);
    }

    public static JComponent createElement(ComponentType componentType, String label, JPanel panel){
        JComponent component = null;

        switch (componentType){
            case LABEL:
                component = new JLabel(label);
                break;
            
            case CHECKBOX:
                component = new JCheckBox(label);
                break;

            case BUTTON:
                component = new JButton(label);
                panel.add(component);
                return component;
        }
        panel.add(component);
        return component;
    }

    public static void createElement(ComponentType componentType, String label, ButtonGroup group, JPanel panel){
        JRadioButton radio = new JRadioButton(label);
        group.add(radio);
        panel.add(radio);
    }
    
    public static void main(String[] args){
        JFrame frame = new JFrame("Formulário de contato");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        ButtonGroup group = new ButtonGroup();

        createElement(ComponentType.LABEL, "Nome: ", panel);
        createElement(ComponentType.TEXTFIELD, 20, panel);
        createElement(ComponentType.LABEL, "Comentário", panel);
        createElement(ComponentType.TEXTAREA, 5, 20, panel);
        createElement(ComponentType.CHECKBOX, "Tem interese em AWS?", panel);
        createElement(ComponentType.RADIOBUTTON, "Sim", group, panel);
        createElement(ComponentType.RADIOBUTTON, "Não", group, panel);
        
        JButton enviarButton = (JButton) createElement(ComponentType.BUTTON, "Enviar", panel);

        enviarButton.addActionListener(e -> {
            String nome = ((JTextField) panel.getComponent(1)).getText();
            String comentario = ((JTextArea) panel.getComponent(3)).getText();
            System.out.println("Nome: " + nome + ", Comentário: " + comentario);
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}