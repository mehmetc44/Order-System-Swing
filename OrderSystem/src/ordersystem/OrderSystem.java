package ordersystem;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderSystem {

    public static double totalPrice = 0.00;

    public static void main(String[] args) {

        JFrame frame = new JFrame("ComboBox Example");
        frame.setSize(900, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        /*                  Panel1                  */
        JPanel panel1 = new JPanel();
        panel1.setBounds(30, 10, 800, 100);
        TitledBorder border1 = new TitledBorder("Customer Information");
        panel1.setBorder(border1);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(30, 40, 150, 30);

        JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(400, 40, 150, 30);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(150, 40, 200, 30);

        JTextField phoneTextField = new JTextField();
        phoneTextField.setBounds(500, 40, 200, 30);

        panel1.setLayout(null);
        panel1.add(nameLabel);
        panel1.add(nameTextField);
        panel1.add(phoneLabel);
        panel1.add(phoneTextField);

        /*                  Panel2                  */
        JPanel panel2 = new JPanel();
        panel2.setBounds(30, 120, 350, 180);
        TitledBorder border2 = new TitledBorder("Meals");
        panel2.setBorder(border2);

        JLabel lbl1 = new JLabel("Choose a meal: ");
        lbl1.setBounds(30, 30, 150, 30);
        String[] meals = {"Börek - $5.00", "Mantı - $10.00", "Pasta - $7.00 ", "Döner - $10.00", "Cağ Kebabı - $15.00"};
        JComboBox<String> cmb1 = new JComboBox<>(meals);
        cmb1.setBounds(30, 60, 180, 30);

        JLabel lbl2 = new JLabel("Quantity: ");
        lbl2.setBounds(30, 100, 110, 30);

        SpinnerNumberModel sModel1 = new SpinnerNumberModel(1, 1, 10, 1);
        JSpinner spinner1 = new JSpinner(sModel1);
        spinner1.setBounds(110, 100, 100, 30);
        JCheckBox extraCheese = new JCheckBox("Extra Cheese (+$2.00)");
        extraCheese.setBounds(30, 140, 150, 30);

        panel2.setLayout(null);
        panel2.add(lbl1);
        panel2.add(lbl2);
        panel2.add(cmb1);
        panel2.add(spinner1);
        panel2.add(extraCheese);

        /*                  Panel3                  */
        JPanel panel3 = new JPanel();
        panel3.setBounds(30, 310, 350, 180);
        TitledBorder border3 = new TitledBorder("Drinks");
        panel3.setBorder(border3);

        JLabel lbl3 = new JLabel("Choose a drink: ");
        lbl3.setBounds(30, 30, 150, 30);
        JCheckBox cola = new JCheckBox("Cola - $2.00");
        cola.setBounds(30, 60, 150, 25);

        JCheckBox water = new JCheckBox("Water - $1.00");
        water.setBounds(30, 95, 150, 25);

        JCheckBox addIce = new JCheckBox("Add Ice (+$0.50)");
        addIce.setBounds(30, 130, 150, 25);

        panel3.setLayout(null);
        panel3.add(cola);
        panel3.add(water);
        panel3.add(addIce);
        panel3.add(lbl3);

        /*                  Panel4                  */
        JPanel panel4 = new JPanel();
        panel4.setBounds(30, 500, 350, 180);
        TitledBorder border4 = new TitledBorder("Desserts");
        panel4.setBorder(border4);

        JLabel lbl4 = new JLabel("Choose a desert: ");
        lbl4.setBounds(30, 30, 150, 30);
        JRadioButton radio1 = new JRadioButton("Cake - $4.00");
        radio1.setBounds(30, 60, 150, 30);

        JRadioButton radio2 = new JRadioButton("Ice Cream - $3.00");
        radio2.setBounds(30, 90, 150, 30);
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);

        JCheckBox chck1 = new JCheckBox("Extra Toppings (+$1.00)");
        chck1.setBounds(30, 130, 200, 25);
        panel4.setLayout(null);
        panel4.add(lbl4);
        panel4.add(radio1);
        panel4.add(radio2);
        panel4.add(chck1);

        /*                  Panel5                  */
        JPanel panel5 = new JPanel();
        panel5.setBounds(400, 120, 430, 560);
        panel5.setBackground(Color.white);
        TitledBorder border5 = new TitledBorder("Order Summary");
        panel5.setBorder(border5);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(20, 20, 415, 560);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JButton btn1 = new JButton("Calculate Price");
        JButton btn2 = new JButton("Reset Order");
        btn1.setBounds(400, 700, 200, 30);
        btn2.setBounds(630, 700, 200, 30);
        panel5.add(textArea);

        JLabel lbl5 = new JLabel();
        lbl5.setText("Total: $" + Double.toString(totalPrice));
        lbl5.setBounds(80, 700, 200, 30);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int currentPrice = 0;
                textArea.append("Customer: " + nameTextField.getText());
                textArea.append("\nPhone Number: " + phoneTextField.getText() + "\n");

                switch (cmb1.getSelectedIndex()) {
                    case 0:
                        totalPrice += 5 * (Integer) spinner1.getValue();
                        textArea.append("\nBörek x" + spinner1.getValue() + " - $" + (double) (5 * (Integer) spinner1.getValue()));
                        break;
                    case 1:
                        totalPrice += 10 * (Integer) spinner1.getValue();
                        textArea.append("\nMantı x" + spinner1.getValue() + " - $" + (double) (10 * (Integer) spinner1.getValue()));
                        break;
                    case 2:
                        totalPrice += 7 * (Integer) spinner1.getValue();
                        textArea.append("\nPasta x" + spinner1.getValue() + " - $" + (double) (7 * (Integer) spinner1.getValue()));
                        break;
                    case 3:
                        totalPrice += 10 * (Integer) spinner1.getValue();
                        textArea.append("\nDöner x" + spinner1.getValue() + " - $" + (double) (10 * (Integer) spinner1.getValue()));
                        break;
                    case 4:
                        totalPrice += 15 * (Integer) spinner1.getValue();
                        textArea.append("\nCağ Kebabı x" + spinner1.getValue() + " - $" + (double) (15 * (Integer) spinner1.getValue()));
                        break;
                    default:
                        break;
                }
                if (extraCheese.isSelected()) {
                    totalPrice += (double) (2 * (Integer) spinner1.getValue());
                    textArea.append("\n + Extra Cheese x" + spinner1.getValue() + " - $" + (double) (2 * (Integer) spinner1.getValue()));

                }
                if (cola.isSelected()) {
                    textArea.append("\nCola - $" + 2.00);
                    totalPrice += 2;
                }
                if (water.isSelected()) {
                    textArea.append("\nWater - $" + 1.00);
                    totalPrice += 1;
                }
                if (addIce.isSelected()) {
                    textArea.append("\n +Ice - $" + 0.50);
                    totalPrice += 0.5;
                }
                if (radio1.isSelected()) {
                    textArea.append("\nCake - $4.00");
                    totalPrice += 4;
                }
                if (radio2.isSelected()) {
                    textArea.append("\nIce Cream - $3.00");
                    totalPrice += 3;
                }
                if (chck1.isSelected()) {
                    textArea.append("\n + Extra Toppings - $1.00");
                    totalPrice += 1;
                }
                lbl5.setText("Total: $" + Double.toString(totalPrice));
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalPrice = 0;
                textArea.setText("");
                lbl5.setText("Total: $0.00");
                spinner1.setValue(1);

                extraCheese.setSelected(false);
                cola.setSelected(false);
                water.setSelected(false);
                addIce.setSelected(false);
                chck1.setSelected(false);

                cmb1.setSelectedIndex(0);
            }
        });
        
        frame.add(lbl5);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel4);
        frame.add(panel3);
        frame.add(panel5);
        frame.setVisible(true);
    }
}
