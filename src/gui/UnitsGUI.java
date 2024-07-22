package gui;

import temperature.Temperature;
import time.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Year;


public class UnitsGUI extends JFrame {

    private int xMouse, yMouse;
    private JPanel header;
    private JLabel btnExit;
    private JLabel btnReturn;
    private JComboBox<String> fromUnitBox;
    private JComboBox<String> toUnitBox;


    //Initial values for the labels (inCurrencyLabel -> USD, outCurrencyLabel -> COP)
    private final Temperature fromTemp = Temperature.CELSIUS;
    private final Temperature toTemp = Temperature.FAHRENHEIT;
    private final Time inTime = Time.YEAR;
    private final Time outTime = Time.WEEK;

    private String tagFromConverter;

    //This Tag comes from the button selected (Temperature, Time, About)
    public String getTagFromConverter() {
        return tagFromConverter;
    }


    public UnitsGUI(String tag){
        this.tagFromConverter = tag;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(100, 100, 520, 290);
        setResizable(false);
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


        fromUnitBox = new JComboBox<>();
        fromUnitBox.setBounds(50, 80, 200, 40);
        fromUnitBox.setFont(new Font("Roboto", Font.BOLD, 14));
        fromUnitBox.setBackground(new Color(255, 255, 255));
        fromUnitBox.setFocusable(false);
        fromUnitBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(fromUnitBox);

        toUnitBox = new JComboBox<>();
        toUnitBox.setBounds(50, 140, 200, 40);
        toUnitBox.setFont(new Font("Roboto", Font.BOLD, 14));
        toUnitBox.setBackground(new Color(255, 255, 255));
        toUnitBox.setFocusable(false);
        toUnitBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        mainPanel.add(toUnitBox);

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

        JLabel fromUnitLabel = new JLabel();
        fromUnitLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        fromUnitLabel.setFont(new Font("Roboto Black", Font.BOLD, 16));
        fromUnitLabel.setBounds(20, 210, 150, 28);

        mainPanel.add(fromUnitLabel);

        JLabel equalsLabel = new JLabel(" = ");
        equalsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        equalsLabel.setFont(new Font("Roboto Black", Font.BOLD, 16));
        equalsLabel.setBounds(200, 210, 40, 28);

        mainPanel.add(equalsLabel);

        JLabel toUnitLabel = new JLabel();
        toUnitLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        toUnitLabel.setFont(new Font("Roboto Black", Font.BOLD, 16));
        toUnitLabel.setBounds(250, 210, 150, 28);

        mainPanel.add(toUnitLabel);


        if (getTagFromConverter().equalsIgnoreCase("temperature")){
            JLabel title = new JLabel("Temperature");
            title.setBounds(120, 0, 240, 80);
            title.setForeground(Color.BLACK);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setFont(new Font("Roboto", Font.BOLD, 24));
//            fromUnitLabel.setText(fromTemp.getSymbol());
//            toUnitLabel.setText(toTemp.getSymbol());
            mainPanel.add(title);

            // This for loop takes the values from the Enum Temperature and displays it
            // within the comboBox
            for (Temperature temperature : Temperature.values()){
                fromUnitBox.addItem(temperature.getName() + " " + temperature.getSymbol());
                toUnitBox.addItem(temperature.getName() + " " + temperature.getSymbol());
            }
            System.out.println(toUnitBox.getSelectedItem());


        }

        if (getTagFromConverter().equalsIgnoreCase("time")) {
            JLabel title = new JLabel("Time");
            title.setBounds(120, 0, 240, 80);
            title.setForeground(Color.BLACK);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setFont(new Font("Roboto", Font.BOLD, 24));
            mainPanel.add(title);

            // This for loop takes the values from the Enum Time and displays it
            // within the comboBox
            for (Time time : Time.values()){
                fromUnitBox.addItem(time.getName());
                toUnitBox.addItem(time.getName());
            }
        }

        if (getTagFromConverter().equalsIgnoreCase("about!")) {
            JLabel title = new JLabel("About!");
            title.setBounds(120, 0, 240, 80);
            title.setForeground(Color.BLACK);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setFont(new Font("Roboto", Font.BOLD, 24));
            mainPanel.add(title);

            //To get the current year and print the whole message in the About! panel
            int currentYear = Year.now().getValue();
            String description = "<html><body>Developed by Julian Lopez © " + currentYear +
                    "<p>https://github.com/Julopvel</p></body></html>";
            JLabel message = new JLabel(description);
            message.setFont(new Font("Roboto", Font.PLAIN, 17));
            message.setBounds(80,100,300,80);
            mainPanel.add(message);

            //It hides the values below
            fromUnitBox.setVisible(false);
            toUnitBox.setVisible(false);
            inputValueTxt.setVisible(false);
            outputValueTxt.setVisible(false);
            fromUnitLabel.setVisible(false);
            equalsLabel.setVisible(false);
            toUnitLabel.setVisible(false);
        }


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
                inputValueTxt.setForeground(new Color(51, 51, 51));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                outputValueTxt.setForeground(new Color(51, 51, 51));

                String inputText = inputValueTxt.getText();
                if (inputText.isEmpty() || inputText.equals(".")){
                    outputValueTxt.setForeground(new Color(200, 200, 200));
                    inputValueTxt.setText("");
                    inputText = "0";
                }

                String stringUnit1 = fromUnitBox.getSelectedItem().toString();
                String stringUnit2 = toUnitBox.getSelectedItem().toString();

                Units units = new Units(getTagFromConverter());
                String unitsConversion = units.getUnitsConversion(inputText, stringUnit1, stringUnit2);

                outputValueTxt.setText(unitsConversion);
            }
        });

        fromUnitBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String inputText = inputValueTxt.getText();
                if (inputText.isEmpty() || inputText.equals(".")){
                    inputValueTxt.setText("");
                    inputText = "0";
                }
                String stringUnit1 = fromUnitBox.getSelectedItem().toString();
                String stringUnit2 = toUnitBox.getSelectedItem().toString();

                Units units = new Units(getTagFromConverter());
                String unitsConversion = units.getUnitsConversion(inputText, stringUnit1, stringUnit2);

                outputValueTxt.setText(unitsConversion);
            }
        });

        toUnitBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String inputText = inputValueTxt.getText();
                if (inputText.isEmpty() || inputText.equals(".")){
                    inputValueTxt.setText("");
                    inputText = "0";
                }
                String stringUnit1 = fromUnitBox.getSelectedItem().toString();
                String stringUnit2 = toUnitBox.getSelectedItem().toString();

                Units units = new Units(getTagFromConverter());
                String unitsConversion = units.getUnitsConversion(inputText, stringUnit1, stringUnit2);

                outputValueTxt.setText(unitsConversion);
            }
        });

    }
}
