package tlylz.acm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController extends CalcPresenter {
    public double historyNumber;
    public char historyCalc = ' ';
    public ActionListener addListener = new CalcListener('+');
    public ActionListener subListener = new CalcListener('-');
    public ActionListener mulListener = new CalcListener('*');
    public ActionListener divListener = new CalcListener('/');
    public ActionListener equListener = new CalcListener('=');

    private class CalcListener implements ActionListener {
        private char usage = ' ';

        public CalcListener(char usage) {
            this.usage = usage;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (historyCalc != ' ') {
                if (getCurrentNumber().equals("")) {
                    historyCalc = usage;
                } else {
                    double cur = parseCurrentNumber();
                    switch (historyCalc) {
                        case '+':
                            historyNumber = historyNumber + cur;
                            break;
                        case '-':
                            historyNumber = historyNumber - cur;
                            break;
                        case '*':
                            historyNumber = historyNumber * cur;
                            break;
                        case '/':
                            historyNumber = historyNumber / cur;
                            break;
                    }
                    historyCalc = usage;
                    setCurrentNumber("");
                }
            } else {
                historyNumber = parseCurrentNumber();
                System.out.println(historyNumber);
                historyCalc = usage;
                setCurrentNumber("");
            }

            if (usage == '=') {
                setCurrentNumber(Double.toString(historyNumber));
                historyNumber = 0;
                historyCalc = ' ';
            }
        }
    }
}
