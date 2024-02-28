import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainMenu extends JFrame implements ItemListener, ActionListener {
    private JLabel titulo1 = new JLabel("Welcome!");
    private JLabel titulo2;
    private JComboBox<String> menuOpciones;
    private JButton botonCerrar;
    private JButton okButton;

    public MainMenu() {
        titulo1.setBounds(100, 10, 100, 25);
        add(titulo1);
        String[] opciones = new String[]{"Seleccione una opción", "Currency converter", "Temperature converter", "????????"};
        menuOpciones = new JComboBox(opciones);
        menuOpciones.setBounds(50, 50, 220, 30);
        add(menuOpciones);
        menuOpciones.addActionListener(this);

        initBotones();
        initJFrame();
    }

    private void initBotones() {
        okButton = new JButton("OK");
        okButton.setBounds(40, 110, 100, 30);
        okButton.addActionListener(this);
        add(okButton);
        botonCerrar = new JButton("Exit");
        botonCerrar.setBounds(170, 110, 100, 30);
        botonCerrar.addActionListener(this);
        add(botonCerrar);
    }

    private void initJFrame() {
        setLayout((LayoutManager)null);
        setLocationRelativeTo((Component)null);
        setTitle("Conversor de monedas y +");
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
            switch ((String)e.getItem()) {
                case "Conversor de monedas":
                    System.out.println("monedas");
                    break;
                case "Conversor de temperatura":
                    System.out.println("temperatura");
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        String opcion = (String)this.menuOpciones.getSelectedItem();
        if (e.getSource() == this.okButton) {
            switch (opcion) {
                case "Currency converter":
                    System.out.println("Coins");
                    ConversorMonedas conversorCoin = new ConversorMonedas(this, true);
                    conversorCoin.setVisible(true);
                    break;
                case "Temperature converter":
                    System.out.println("Temperature");
                    ConversorTemp conversorTemp = new ConversorTemp(this, true);
                    conversorTemp.setVisible(true);
            }

            System.out.println("getSelectedItem: " + this.menuOpciones.getSelectedItem());
            System.out.println(e.getActionCommand());
        }

        if (e.getSource() == this.botonCerrar) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new MainMenu();
    }
}