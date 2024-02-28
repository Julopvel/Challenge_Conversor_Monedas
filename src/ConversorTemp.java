
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorTemp extends JDialog implements ActionListener {

    private JTextField temperature;
    private JButton convertButton, returnButton;
    private JLabel celsiusLabel, fahrenheitLabel, kelvinLabel;

    public ConversorTemp(MainMenu parent, boolean modal) {
        super(parent, modal);

        //JTextField
        temperature = new JTextField();
        temperature.setBounds(20, 20, 100, 25);
        add(temperature);


        initJButtons();
        initJLabel();
        initPantalla();
    }

    private void initJButtons() {
        //JButton
        convertButton = new JButton("Convert!");
        convertButton.setBounds(20, 80, 100, 25);
        convertButton.addActionListener(this);
        add(convertButton);

        //JButton(Volver)
        returnButton = new JButton("Return");
        returnButton.setBounds(20, 120, 100, 25);
        returnButton.addActionListener(this);
        add(returnButton);
    }

    private void initPantalla() {
        setLayout(null);
        setTitle("Celsius converter"); //Titulo
        setBounds(400, 200, 300, 200); //Tamaño ventana
    }

    private void initJLabel() {
        //JLabel Celsius
        celsiusLabel = new JLabel("° Celsius");
        celsiusLabel.setBounds(150, 20, 100, 25);
        add(celsiusLabel);

        //JLabel Fahrenheit
        fahrenheitLabel = new JLabel("Fahrenheit");
        fahrenheitLabel.setBounds(150, 80, 120, 25);
        add(fahrenheitLabel);

        //JLabel Kelvin
        kelvinLabel = new JLabel("Kelvin");
        kelvinLabel.setBounds(150,120,140,25);
        add(kelvinLabel);
    }

    public static boolean ValidarNumero(String input){
        try {
            double x = Double.parseDouble(input);
            if(x >= 0 || x < 0);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            if (ValidarNumero(temperature.getText())){
                double tempFahr = (Double.parseDouble(temperature.getText()) * 1.8 + 32);
                double tempKelvin = Double.parseDouble(temperature.getText()) + 273.15;
                fahrenheitLabel.setText(tempFahr + " Fahrenheit");
                kelvinLabel.setText(tempKelvin + " Kelvin");
            }
            else {
                System.out.println("Solo se aceptan valores numéricos");
                JOptionPane.showMessageDialog(null, "Error, solo se aceptan valores numéricos",
                        null, JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == returnButton) {
            dispose();
        }
    }
}
