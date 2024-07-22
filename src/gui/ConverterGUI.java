package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ConverterGUI extends JFrame {

    private int xMouse, yMouse;
    private JPanel header;
    private JLabel btnExit;
    private JLabel btnAbout;

    

    public static void main(String[] args) {
        ConverterGUI converterGUI = new ConverterGUI();
        converterGUI.setVisible(true);
    }



    public ConverterGUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(100, 100, 520, 290);
        setResizable(true);
        //setLocationByPlatform(true);
        setUndecorated(true);       //Removes the upper bar of the window.


        //This contentPane contains within all the other components(btns, labels, JPanels,...)
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(238,238,238));
        mainPanel.setForeground(new Color(255, 255, 255));
        mainPanel.setBounds(0,0,520,290);
        mainPanel.setLayout(null);
        contentPane.add(mainPanel);

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



//        JLabel btnExit = new JLabel("X");
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

        JPanel logoPanel = new JPanel();
        logoPanel.setBounds(300,80,150,155);
        mainPanel.add(logoPanel);

        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(ConverterGUI.class.getResource("/images/logo.png")));
        logoPanel.add(logo);


        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, 240, 290);
        menuPanel.setBackground(new Color(0, 134, 190));
        menuPanel.setLayout(null);      //Anula el layout
        mainPanel.add(menuPanel);

        JLabel title = new JLabel("Conv€rter!");
        title.setBounds(0, 0, 240, 80);
        title.setForeground(new Color(255, 255, 255));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Roboto", Font.BOLD, 24));
        menuPanel.add(title);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0, 134, 190));
        buttonPanel.setBounds(0, 80, 240, 210);
        menuPanel.add(buttonPanel);

        JLabel btnCurrency = new JLabel("Currency");
//        btnCurrency.setBounds(0,0,240,60);
        btnCurrency.setPreferredSize(new Dimension(240,40));
        btnCurrency.setIconTextGap(20);
        btnCurrency.setIcon(new ImageIcon(ConverterGUI.class.getResource("/images/logoCurrency.png")));
        btnCurrency.setBackground(new Color(0, 141, 202));
        btnCurrency.setForeground(new Color(255, 255, 255));
        btnCurrency.setOpaque(true);
        btnCurrency.setFont(new Font("Roboto", Font.BOLD, 14));
        btnCurrency.setBorder(new EmptyBorder(0, 10, 0, 0));
        btnCurrency.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnCurrency.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CurrencyGUI currencyGUI = new CurrencyGUI();
                currencyGUI.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnCurrency.setBackground(new Color(0, 141, 202));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnCurrency.setBackground(new Color(0, 134, 190));
            }
        });

        buttonPanel.add(btnCurrency);

        JLabel btnTemperature = new JLabel("Temperature");
        btnTemperature.setPreferredSize(new Dimension(240,40));
        btnTemperature.setIconTextGap(20);
        btnTemperature.setOpaque(true);
        btnTemperature.setIcon(new ImageIcon(ConverterGUI.class.getResource("/images/logoTemperature.png")));
        btnTemperature.setBackground(new Color(0, 141, 202));
        btnTemperature.setForeground(new Color(255, 255, 255));
        btnTemperature.setHorizontalAlignment(SwingConstants.LEFT);
        btnTemperature.setFont(new Font("Roboto", Font.BOLD, 14));
        btnTemperature.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnTemperature.setBorder(new EmptyBorder(0, 10, 0, 0));


        btnTemperature.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String temperatureTag = btnTemperature.getText();
                UnitsGUI unitsGUI = new UnitsGUI(temperatureTag);
                unitsGUI.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnTemperature.setBackground(new Color(0, 141, 202));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnTemperature.setBackground(new Color(0, 134, 190));
            }
        });

        buttonPanel.add(btnTemperature);


        JLabel btnTime = new JLabel("Time");
        btnTime.setPreferredSize(new Dimension(240,40));
        btnTime.setIconTextGap(20);
        btnTime.setOpaque(true);
        btnTime.setIcon(new ImageIcon(ConverterGUI.class.getResource("/images/logoClock.png")));
        btnTime.setBackground(new Color(0, 141, 202));
        btnTime.setForeground(new Color(255, 255, 255));
        btnTime.setFont(new Font("Roboto", Font.BOLD, 14));
        btnTime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnTime.setBorder(new EmptyBorder(0, 10, 0, 0));

        btnTime.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String btnTimeTag = btnTime.getText();
                UnitsGUI unitsGUI = new UnitsGUI(btnTimeTag);
                unitsGUI.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnTime.setBackground(new Color(0, 141, 202));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnTime.setBackground(new Color(0, 134, 190));
            }
        });


        buttonPanel.add(btnTime);

        btnAbout = new JLabel("About!");
//        btnAbout.setBounds(0,200,240, 40);
        btnAbout.setPreferredSize(new Dimension(240,40));
        btnAbout.setIconTextGap(20);
        btnAbout.setOpaque(true);
        btnAbout.setIcon(new ImageIcon(ConverterGUI.class.getResource("/images/logoAbout.png")));
        btnAbout.setBackground(new Color(0, 141, 202));
        btnAbout.setForeground(new Color(255, 255, 255));
        btnAbout.setFont(new Font("Roboto", Font.BOLD, 14));
        btnAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAbout.setBorder(new EmptyBorder(0, 10, 0, 0));

        btnAbout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String aboutTag = btnAbout.getText();
                UnitsGUI unitsGUI = new UnitsGUI(aboutTag);
                unitsGUI.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }
        });

        buttonPanel.add(btnAbout);

    }

}



