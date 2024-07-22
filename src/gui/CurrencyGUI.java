package gui;

import com.google.gson.Gson;
import currency.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyGUI extends JFrame{

    private int xMouse, yMouse;
    private JPanel header;
    private JLabel btnExit;
    private JLabel btnReturn;
    private JComboBox<String> inputCurrency;
    private JComboBox<String> outputCurrency;
    private JLabel inCurrencyLabel;
    private JLabel outCurrencyLabel;

    //Initial values for the labels (inCurrencyLabel -> USD, outCurrencyLabel -> COP)
    private final Currencies fromCurrency = Currencies.USD;
    private final Currencies toCurrency = Currencies.COP;


    ExchangeRateConverter ERConverter = new ExchangeRateConverter();
    JsonGenerator jsonGenerator = new JsonGenerator();
    Gson gson = jsonGenerator.createMyGson();


    public static void main(String[] args) {
        new CurrencyGUI().setVisible(true);
    }

    public CurrencyGUI(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(100, 100, 520, 290);
        setResizable(false);
//        setLocationByPlatform(true);
        setUndecorated(true);       //Removes the upper bar of the window.

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0,0,520,290);
        mainPanel.setLayout(null);
        add(mainPanel);

        header = new JPanel();
        header.setBounds(0,0,520,40);
        header.setLayout(null);
        header.setOpaque(false);                //false so it does not paint the header by default
        mainPanel.add(header);

        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - xMouse, y - yMouse);
            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });

        btnExit = new JLabel("X");
        btnExit.setBounds(480, 0, 40, 40);
        btnExit.setFont(new Font("Roboto Light", Font.PLAIN, 24));
        btnExit.setBackground(new Color(238,238,238));
        btnExit.setForeground(Color.BLACK);
        btnExit.setHorizontalAlignment(SwingConstants.CENTER);
        btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnExit.setOpaque(true);
        header.add(btnExit);

        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnExit.setBackground(Color.RED);
                btnExit.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnExit.setBackground(new Color(238,238,238));
                btnExit.setForeground(Color.BLACK);
            }
        });


        btnReturn = new JLabel("<");
        btnReturn.setBounds(0, 0, 40, 40);
        btnReturn.setFont(new Font("Roboto Light", Font.PLAIN, 24));
        btnReturn.setBackground(new Color(238,238,238));
        btnReturn.setForeground(Color.BLACK);
        btnReturn.setHorizontalAlignment(SwingConstants.CENTER);
        btnReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReturn.setOpaque(true);
        header.add(btnReturn);

        btnReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ConverterGUI converterGUI = new ConverterGUI();
                converterGUI.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnReturn.setBackground(Color.LIGHT_GRAY);
                btnReturn.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnReturn.setBackground(new Color(238,238,238));
                btnReturn.setForeground(Color.BLACK);
            }
        });

        JLabel title = new JLabel("Currencies");
        title.setBounds(120, 0, 240, 80);
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Roboto", Font.BOLD, 24));
        mainPanel.add(title);


        inputCurrency = new JComboBox<>();
        inputCurrency.setBounds(50, 80, 200, 40);
        inputCurrency.setFont(new Font("Roboto", Font.BOLD, 14));
        inputCurrency.setBackground(new Color(255, 255, 255));
        inputCurrency.setFocusable(false);
        inputCurrency.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // This for loop takes the values from the Enum Currencies and displays it
        // within the comboBox
        for (Currencies currencies : Currencies.values()){
            inputCurrency.addItem(currencies.getName() + " " + currencies.getSymbol());
        }

        mainPanel.add(inputCurrency);

        outputCurrency = new JComboBox<String>();
        outputCurrency.setBounds(50, 140, 200, 40);
        outputCurrency.setFont(new Font("Roboto", Font.BOLD, 14));
        outputCurrency.setBackground(new Color(255, 255, 255));
        outputCurrency.setFocusable(false);
        outputCurrency.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //With this for loop, it adds all the items created in the Enum object (Currencies)
        for (Currencies currencies : Currencies.values()){
            outputCurrency.addItem(currencies.getName() + " " + currencies.getSymbol());
        }
        outputCurrency.setSelectedIndex(1);     //Selects the item in the ComboBox located in pos 1

        mainPanel.add(outputCurrency);


        JTextField inputValueTxt = new JTextField();
        inputValueTxt.setBounds(300,80,140,40);
        inputValueTxt.setFont(new Font("Roboto", Font.BOLD, 16));
        inputValueTxt.setForeground(new Color(200, 200, 200));

        mainPanel.add(inputValueTxt);

        JTextField outputValueTxt = new JTextField();
        outputValueTxt.setBounds(300,140,140,40);
        outputValueTxt.setFont(new Font("Roboto", Font.BOLD, 16));
        outputValueTxt.setForeground(new Color(200, 200, 200));
        outputValueTxt.setEditable(false);

        mainPanel.add(outputValueTxt);

        //The initial value of the label will be USD (as defined in the top)
        inCurrencyLabel = new JLabel(fromCurrency.getSymbol());
        inCurrencyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        inCurrencyLabel.setFont(new Font("Roboto Black", Font.BOLD, 16));
        inCurrencyLabel.setBounds(20, 210, 150, 28);

        mainPanel.add(inCurrencyLabel);

        JLabel equalsLabel = new JLabel(" = ");
        equalsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        equalsLabel.setFont(new Font("Roboto Black", Font.BOLD, 16));
        equalsLabel.setBounds(200, 210, 40, 28);

        mainPanel.add(equalsLabel);

        //The initial value of the label will be COP (as defined in the top)
        outCurrencyLabel = new JLabel(toCurrency.getSymbol());
        outCurrencyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        outCurrencyLabel.setFont(new Font("Roboto Black", Font.BOLD, 16));
        outCurrencyLabel.setBounds(250, 210, 150, 28);

        mainPanel.add(outCurrencyLabel);


        inputValueTxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String inputText = inputValueTxt.getText();
                if (inputText.equals("0") || inputText.isEmpty()){
                    inputValueTxt.setText("");
                }
            }
        });


        inputValueTxt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c != '.') {
                    e.consume(); // ignore event
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                inputValueTxt.setText("");
                inputValueTxt.setForeground(new Color(51, 51, 51));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                outputValueTxt.setForeground(new Color(51, 51, 51));

                String inputText = inputValueTxt.getText();
                if (inputText.isEmpty() || inputText.equals(".")){
                    outputValueTxt.setForeground(new Color(200, 200, 200));
                    inputValueTxt.setText("");
                }

                String inputCurrencyString = inputCurrency.getSelectedItem().toString();
                String inputCurrencyCode = inputCurrencyString.substring(
                        inputCurrencyString.length() - 3);
                String outCurrencyString = outputCurrency.getSelectedItem().toString();
                String amount = inputValueTxt.getText();
                String outCurrencyCode = outCurrencyString.substring(
                        outCurrencyString.length() - 3);

                String exchangeRateUrl = ERConverter.exchangeRateUrl(
                        inputCurrencyString, outCurrencyString, amount);

                ExchangeRateValues exchangeRateValues = ERConverter.exchangeRateBody(exchangeRateUrl, gson);

                Coin coin = new Coin(exchangeRateValues);
                String conversion_result = String.valueOf(coin.getConversion_result());
                outputValueTxt.setText(conversion_result);

                inCurrencyLabel.setText(amount + " " + inputCurrencyCode);
                outCurrencyLabel.setText(conversion_result + " " + outCurrencyCode);
            }
        });

        inputCurrency.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String inputCurrencyString = inputCurrency.getSelectedItem().toString();
                String inputCurrencyCode = inputCurrencyString.substring(
                        inputCurrencyString.length() - 3);
                String outCurrencyString = outputCurrency.getSelectedItem().toString();
                String outCurrencyCode = outCurrencyString.substring(
                        outCurrencyString.length() - 3);

                String amount = inputValueTxt.getText();

                String exchangeRateUrl = ERConverter.exchangeRateUrl(
                        inputCurrencyString, outCurrencyString, amount);

                ExchangeRateValues exchangeRateValues = ERConverter.exchangeRateBody(exchangeRateUrl, gson);

                Coin coin = new Coin(exchangeRateValues);
                String conversion_result = String.valueOf(coin.getConversion_result());
                outputValueTxt.setText(conversion_result);

                inCurrencyLabel.setText(amount + " " + inputCurrencyCode);
                outCurrencyLabel.setText(conversion_result + " " + outCurrencyCode);
            }
        });

        outputCurrency.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String inputCurrencyString = inputCurrency.getSelectedItem().toString();
                String inputCurrencyCode = inputCurrencyString.substring(
                        inputCurrencyString.length() - 3);
                String outCurrencyString = outputCurrency.getSelectedItem().toString();
                String outCurrencyCode = outCurrencyString.substring(
                        outCurrencyString.length() - 3);


                String amount = inputValueTxt.getText();

                String exchangeRateUrl = ERConverter.exchangeRateUrl(
                        inputCurrencyString, outCurrencyString, amount);

                ExchangeRateValues exchangeRateValues = ERConverter.exchangeRateBody(exchangeRateUrl, gson);

                Coin coin = new Coin(exchangeRateValues);

                String conversion_result = String.valueOf(coin.getConversion_result());
                outputValueTxt.setText(conversion_result);

                inCurrencyLabel.setText(amount + " " + inputCurrencyCode);
                outCurrencyLabel.setText(conversion_result + " " + outCurrencyCode);
            }
        });
    }
}
