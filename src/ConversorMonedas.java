
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMonedas extends JDialog implements ActionListener {
    private JTextField valorMoneda;
    private JButton convertButton, returnButton;
    private JLabel labelTo;
    private JComboBox<String> fromMoneda, toMoneda;

    public ConversorMonedas(MainMenu parent, boolean modal) {
        super(parent, modal);

        //JTextField
        valorMoneda = new JTextField();
        valorMoneda.setBounds(20, 20, 100, 25);
        add(valorMoneda);

        //JLabel
        labelTo = new JLabel("to");
        labelTo.setBounds(35,60,30,25);
        add(labelTo);

        initBotones();
        initFromMoneda();
        initToMoneda();
        initPantalla();
    }

    private void initPantalla() {
        setLayout(null);
        setTitle("Currency converter"); //Titulo
        setBounds(400, 200, 300, 200); //Tamaño ventana
    }

    private void initFromMoneda(){
        fromMoneda = new JComboBox<String >();
        fromMoneda.setBounds(150,20,100,25);
        add(fromMoneda);

        fromMoneda.addItem("COP");
        fromMoneda.addItem("MXN");
        fromMoneda.addItem("USD");
        fromMoneda.addItem("EUR");
        fromMoneda.addItem("JPY");
        fromMoneda.addItem("CNY");
        fromMoneda.addActionListener(this);
    }

    private void initToMoneda() {
        String [] currencies = {"COP", "MXN", "USD", "EUR", "JPY", "CNY"};
        toMoneda = new JComboBox<String>(currencies);
        toMoneda.setBounds(150,60,100,25);
        add(toMoneda);
        toMoneda.addActionListener(this);
    }

    private void initBotones() {
        //Boton convert
        convertButton = new JButton("Convert");
        convertButton.setBounds(40,110,100,30);
        convertButton.addActionListener(this);
        add(convertButton);

        //JButton(Boton return)
        returnButton = new JButton("Return");
        returnButton.setBounds(170,110,100,30);
        returnButton.addActionListener(this);
        add(returnButton);
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
        String fromCoin = (String) fromMoneda.getSelectedItem();
        String toCoin = (String) toMoneda.getSelectedItem();
        String fromTo = fromCoin + "-" + toCoin;

        if (e.getSource() == convertButton){
            if (ValidarNumero(valorMoneda.getText())){
                double valor = Double.parseDouble(valorMoneda.getText());
                String mensaje = valor + " " + fromCoin + " equals to ";
                OpcionesMonedas monedas = new OpcionesMonedas();
                switch (fromTo){
                    /*----------------------Peso Colombiano a otras----------------------------*/
                    case "COP-MXN":
                        System.out.println(monedas.COP_MXN(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.COP_MXN(valor) + " " + toCoin);
                        break;
                    case "COP-USD":
                        System.out.println(monedas.COP_USD(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.COP_USD(valor) + " " + toCoin);
                        break;
                    case "COP-EUR":
                        System.out.println(monedas.COP_EUR(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.COP_EUR(valor) + " " + toCoin);
                        break;
                    case "COP-JPY":
                        System.out.println(monedas.COP_JPY(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.COP_JPY(valor) + " " + toCoin);
                        break;
                    case "COP-CNY":
                        System.out.println(monedas.COP_CNY(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.COP_CNY(valor) + " " + toCoin);
                        break;
                    /*----------------------Peso Mexicano a otras----------------------------*/
                    case "MXN-COP":
                        System.out.println(monedas.MXN_COP(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.MXN_COP(valor) + " " + toCoin);
                        break;
                    case "MXN-USD":
                        System.out.println(monedas.MXN_USD(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.MXN_USD(valor) + " " + toCoin);
                        break;
                    case "MXN-EUR":
                        System.out.println(monedas.MXN_EUR(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.MXN_EUR(valor) + " " + toCoin);
                        break;
                    case "MXN-JPY":
                        System.out.println(monedas.MXN_JPY(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.MXN_JPY(valor) + " " + toCoin);
                        break;
                    case "MXN-CNY":
                        System.out.println(monedas.MXN_CNY(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.MXN_CNY(valor) + " " + toCoin);
                        break;
                    /*----------------------Dolar americano a otras----------------------------*/
                    case "USD-COP":
                        System.out.println(monedas.USD_COP(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.USD_COP(valor) + " " + toCoin);
                        break;
                    case "USD-MXN":
                        System.out.println(monedas.USD_MXN(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.USD_MXN(valor) + " " + toCoin);
                        break;
                    case "USD-EUR":
                        System.out.println(monedas.USD_EUR(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.USD_EUR(valor) + " " + toCoin);
                        break;
                    case "USD-JPY":
                        System.out.println(monedas.USD_JPY(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.USD_JPY(valor) + " " + toCoin);
                        break;
                    case "USD-CNY":
                        System.out.println(monedas.USD_CNY(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.USD_CNY(valor) + " " + toCoin);
                        break;
                    /*----------------------Euro a otras----------------------------*/
                    case "EUR-COP":
                        System.out.println(monedas.EUR_COP(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.EUR_COP(valor) + " " + toCoin);
                        break;
                    case "EUR-MXN":
                        System.out.println(monedas.EUR_MXN(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.EUR_MXN(valor) + " " + toCoin);
                        break;
                    case "EUR-USD":
                        System.out.println(monedas.EUR_USD(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.EUR_USD(valor) + " " + toCoin);
                        break;
                    case "EUR-JPY":
                        System.out.println(monedas.EUR_JPY(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.EUR_JPY(valor) + " " + toCoin);
                        break;
                    case "EUR-CNY":
                        System.out.println(monedas.EUR_CNY(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.EUR_CNY(valor) + " " + toCoin);
                        break;
                    /*----------------------Yen  a otras----------------------------*/
                    case "JPY-COP":
                        System.out.println(monedas.JPY_COP(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.JPY_COP(valor) + " " + toCoin);
                        break;
                    case "JPY-MXN":
                        System.out.println(monedas.JPY_MXN(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.JPY_MXN(valor) + " " + toCoin);
                        break;
                    case "JPY-USD":
                        System.out.println(monedas.JPY_USD(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.JPY_USD(valor) + " " + toCoin);
                        break;
                    case "JPY-EUR":
                        System.out.println(monedas.JPY_EUR(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.JPY_EUR(valor) + " " + toCoin);
                        break;
                    case "JPY-CNY":
                        System.out.println(monedas.JPY_CNY(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.JPY_CNY(valor) + " " + toCoin);
                        break;
                    /*----------------------Yuan  a otras----------------------------*/
                    case "CNY-COP":
                        System.out.println(monedas.CNY_COP(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.CNY_COP(valor) + " " + toCoin);
                        break;
                    case "CNY-MXN":
                        System.out.println(monedas.CNY_MXN(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.CNY_MXN(valor) + " " + toCoin);
                        break;
                    case "CNY-USD":
                        System.out.println(monedas.CNY_USD(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.CNY_USD(valor) + " " + toCoin);
                        break;
                    case "CNY-EUR":
                        System.out.println(monedas.CNY_EUR(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.CNY_EUR(valor) + " " + toCoin);
                        break;
                    case "CNY-JPY":
                        System.out.println(monedas.CNY_JPY(valor));
                        JOptionPane.showMessageDialog(null,
                                mensaje + monedas.CNY_JPY(valor) + " " + toCoin);
                        break;
                }
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
