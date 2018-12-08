package tlylz.acm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcButton extends JButton {
    public CalcButton(String at, ActionListener act) {
        this.setSize(new Dimension(200,160));
        this.setFont(new Font("Segoe UI", 0, 80));
        this.setText(at);
        this.addActionListener(act);
    }
}
