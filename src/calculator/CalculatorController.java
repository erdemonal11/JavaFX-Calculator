package calculator;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class CalculatorController implements Initializable {

    @FXML
    private TextArea txtResult;

    private boolean start = true;
    private ArrayList<Double> numbers = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();
    private Calculate calculate = new Calculate();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void onClickNumber(String number) {
        if (start) {
            txtResult.setText("");
            start = false;
        }
        txtResult.setText(txtResult.getText() + number);
    }

    public void onClickOperator(String operatorSign) {
        if (!operatorSign.equals("=")) {
            if (!txtResult.getText().isEmpty()) {
                operators.add(operatorSign);
                numbers.add(Double.parseDouble(txtResult.getText()));
                txtResult.setText("");
            } else {
                operators.set(operators.size() - 1, operatorSign);
            }

        } else {
            if (operators.isEmpty()) {
                return;
            }

            numbers.add(Double.parseDouble(txtResult.getText()));

            for (int i = 0; i < operators.size(); i++) {
                String operator = operators.get(i);
                if (operator.equals("^")) {
                    Double number1 = numbers.get(i);
                    Double number2 = numbers.get(i + 1);
                    Double result = calculate.calculate(number1, number2, operator);

                    numbers.set(i, result);
                    numbers.remove(i + 1);
                    operators.remove(i);
                }
            }
            int i = 0;
            while (i < operators.size()) {
                String operator = operators.get(i);
                if (operator.equals("*") || operator.equals("/")) {
                    Double number1 = numbers.get(i);
                    Double number2 = numbers.get(i + 1);
                    Double result = calculate.calculate(number1, number2, operator);

                    numbers.set(i, result);
                    numbers.remove(i + 1);
                    operators.remove(i);
                } else {
                    i++;
                }
            }

            i = 0;
            while (i < operators.size()) {
                String operator = operators.get(i);
                Double number1 = numbers.get(i);
                Double number2 = numbers.get(i + 1);
                Double result = calculate.calculate(number1, number2, operator);

                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
            }

            txtResult.setText(String.valueOf(numbers.get(0)));
        }
    }

    public void onClickScientificOperation(String operation) {
        operators.add(operation);
        numbers.add(Double.parseDouble(txtResult.getText()));

        String operator = operators.remove(0);
        double number1 = numbers.remove(0);

        double result = calculate.calculateScintific(number1, operator);
        numbers.add(0, result);
        txtResult.setText(numbers.get(0).toString());
    }

    @FXML
    private void onClickBtn0(ActionEvent event) {
        onClickNumber("0");
    }

    @FXML
    private void onClickBtn2(ActionEvent event) {
        onClickNumber("2");
    }

    @FXML
    private void onClickBtn5(ActionEvent event) {
        onClickNumber("5");
    }

    @FXML
    private void onClickBtn4(ActionEvent event) {
        onClickNumber("4");
    }

    @FXML
    private void onClickBtn1(ActionEvent event) {
        onClickNumber("1");
    }

    @FXML
    private void onClickClear(ActionEvent event) {
        operators.clear();
        numbers.clear();
        start = true;
        txtResult.setText("");
    }

    @FXML
    private void onClickBtnDot(ActionEvent event) {
        onClickNumber(".");
    }

    @FXML
    private void onClickBtn3(ActionEvent event) {
        onClickNumber("3");
    }

    @FXML
    private void onClickBtn6(ActionEvent event) {
        onClickNumber("6");
    }

    @FXML
    private void onClickBtn7(ActionEvent event) {
        onClickNumber("7");
    }

    @FXML
    private void onClickBtn8(ActionEvent event) {
        onClickNumber("8");
    }

    @FXML
    private void onClickBtn9(ActionEvent event) {
        onClickNumber("9");
    }

    @FXML
    private void onClickSin(ActionEvent event) {
        onClickScientificOperation("sin");
    }

    @FXML
    private void onClickCos(ActionEvent event) {
        onClickScientificOperation("cos");
    }

    @FXML
    private void onClickTan(ActionEvent event) {
        onClickScientificOperation("tan");
    }

    @FXML
    private void onClickEuler(ActionEvent event) {
        onClickScientificOperation("e^x");
    }

    @FXML
    private void onClickLog(ActionEvent event) {
        onClickScientificOperation("log");
    }

    @FXML
    private void onClickPower(ActionEvent event) {
        onClickOperator("^");
    }

    @FXML
    private void onClickCube(ActionEvent event) {
        onClickScientificOperation("x^3");
    }

    @FXML
    private void onClickSquare(ActionEvent event) {
        onClickScientificOperation("x^2");
    }

    @FXML
    private void onClickDivide(ActionEvent event) {
        onClickOperator("/");
    }

    @FXML
    private void onClickMultiply(ActionEvent event) {
        onClickOperator("*");
    }

    @FXML
    private void onClickMinus(ActionEvent event) {
        onClickOperator("-");
    }

    @FXML
    private void onClickPlus(ActionEvent event) {
        onClickOperator("+");
    }

    @FXML
    private void onClickBtnEqual(ActionEvent event) {
        onClickOperator("=");
    }

    @FXML
    private void onClickSquareRoot(ActionEvent event) {
        onClickScientificOperation("√");

    }

    @FXML
    private void onClickDelete(ActionEvent event) {
        if (txtResult.getText().equals("")) {
            txtResult.setText("");
        } else {
            StringBuffer sb = new StringBuffer(txtResult.getText());
            sb.delete(txtResult.getText().length() - 1, txtResult.getText().length());
            txtResult.setText(sb.toString());
        }
    }

    @FXML
    private void onClickFactorial(ActionEvent event) {
        onClickScientificOperation("x!");

    }

}
