package calculator;

public class Calculate {
    public Double calculateScintific(double number1, String operator) {
        switch (operator) {
            case "√":
                return Math.sqrt(number1);
            case "sin":
                return (double) Math.sin(Math.toRadians(number1));
            case "cos":
                return Math.cos(Math.toRadians(number1));
            case "tan":
                return (double) Math.tan(Math.toRadians(number1));
            case "e^x":
                return (double) Math.exp(number1);
            case "x^2":
                return number1 * number1;
            case "x^3":
                return number1 * number1 * number1;
            case "log":
                return Math.log10(number1);
            case "x!":
                double result = 1;
                if(number1<=0) return 0.0;
                else{
                    for(int i=2;i<=number1;i++){
                        result *= i;
                    }
                    return result;
                }
            default:
                break;
        }
        return 0.0;
    }
    public Double calculate(double number1, double number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    return 0.0;
                }
                return number1 / number2;
            case "^":
                return (double) Math.pow(number1, number2);
            default:
                break;
        }
        return 0.0;
    }
}
