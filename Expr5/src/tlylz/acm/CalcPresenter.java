package tlylz.acm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPresenter {
    private String current = "";
    public ActionListener numberChanged;
    public final ActionListener[] numberButton;
    public final ActionListener dotButton;

    public String getCurrentNumber() {
        return current;
    }

    public void setCurrentNumber(String cur) {
        current = cur;
        if (numberChanged != null) {
            numberChanged.actionPerformed(null);
        }
    }

    public double parseCurrentNumber() {
        try {
            return Double.parseDouble(current.equals("") ? "0" : current);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public CalcPresenter() {
        numberButton = new ActionListener[10];
        for (int i = 0; i < 10; i++)
            numberButton[i] = new NumberListener(i);
        dotButton = new DotListener();
    }

    private class DotListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (current.contains(".")) {
                return;
            } else {
                if (current.equals(""))
                    current = "0";
                current += '.';
            }

            if (numberChanged != null) {
                numberChanged.actionPerformed(e);
            }
        }
    }

    private class NumberListener implements ActionListener {
        private int thisNumber;

        public NumberListener(int n) {
            thisNumber = n;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (current.equals("0")) {
                if (thisNumber == 0) {
                    return;
                } else {
                    current = "";
                }
            }

            current += thisNumber;

            if (numberChanged != null) {
                numberChanged.actionPerformed(e);
            }
        }
    }
}
