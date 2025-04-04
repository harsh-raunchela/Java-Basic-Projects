import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    //set the defaulter first

    JFrame Frame = new JFrame("Simple Calculator");
    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton eqlButton, decButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Ink Free",Font.BOLD, 30 );

    double num1=0, num2=0, result = 0;
    char operator;

    Calculator() {

        //we will add frame

        Frame.setSize(420, 550);
        Frame.setLocationRelativeTo(null);
        Frame.setResizable(false);
        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Frame.setLayout(null);


        //add text field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);


        //add buttons
        addButton = new JButton("+");
        subButton = new JButton("_");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqlButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButton[0]=addButton;
        functionButton[1]=subButton;
        functionButton[2]=mulButton;
        functionButton[3]=divButton;
        functionButton[4]=decButton;
        functionButton[5]=eqlButton;
        functionButton[6]=delButton;
        functionButton[7]=clrButton;
        for (int i = 0; i <8 ; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }

        //delete and clear button
        delButton.setBounds(50, 430, 145, 50 );
        clrButton.setBounds(205, 430, 145, 50);


        //add panel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4,10, 10));


        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(eqlButton);
        panel.add(divButton);


        Frame.add(panel);
        Frame.add(delButton);
        Frame.add(clrButton);
        Frame.add(textField);
        Frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
          if(e.getSource() == addButton){
              num1 = Double.parseDouble(textField.getText());
              operator = '+';
              textField.setText("");
          }
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == eqlButton){
            num2 = Double.parseDouble(textField.getText());

            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1*num2;
                    break;
                case '/' :
                    result = num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");

            for (int i = 0; i < string.length()-1;i++){
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
    }
}