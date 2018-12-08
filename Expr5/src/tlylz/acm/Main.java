package tlylz.acm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main extends JFrame {
    private Main() {
        this.setSize(new Dimension(800, 800));
        this.setLocationByPlatform(true);
        this.setLayout(new BorderLayout());
        TextField textBox = new TextField();
        textBox.setFont(new Font("Segoe UI", 0, 80));
        textBox.setSize(0, 160);
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(4, 4));
        this.add(textBox, BorderLayout.NORTH);
        this.add(controlPanel, BorderLayout.CENTER);

        CalcController presenter = new CalcController();
        presenter.numberChanged = (e -> { textBox.setText(presenter.getCurrentNumber()); });
        controlPanel.add(new CalcButton("7", presenter.numberButton[7]));
        controlPanel.add(new CalcButton("8", presenter.numberButton[8]));
        controlPanel.add(new CalcButton("9", presenter.numberButton[9]));
        controlPanel.add(new CalcButton("/", presenter.divListener));
        controlPanel.add(new CalcButton("4", presenter.numberButton[4]));
        controlPanel.add(new CalcButton("5", presenter.numberButton[5]));
        controlPanel.add(new CalcButton("6", presenter.numberButton[6]));
        controlPanel.add(new CalcButton("*", presenter.mulListener));
        controlPanel.add(new CalcButton("1", presenter.numberButton[1]));
        controlPanel.add(new CalcButton("2", presenter.numberButton[2]));
        controlPanel.add(new CalcButton("3", presenter.numberButton[3]));
        controlPanel.add(new CalcButton("-", presenter.subListener));
        controlPanel.add(new CalcButton("0", presenter.numberButton[0]));
        controlPanel.add(new CalcButton(".", presenter.dotButton));
        controlPanel.add(new CalcButton("=", presenter.equListener));
        controlPanel.add(new CalcButton("+", presenter.addListener));
    }

    public static void main(String[] args) {
        Main st = new Main();
        st.setVisible(true);
        st.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
