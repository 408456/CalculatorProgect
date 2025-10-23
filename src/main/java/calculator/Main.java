package calculator;
import java.util.Scanner;

/**
 * Выполнил: Гольцман Глеб Михайлович */

class Main {
    static String calc(String input) throws Exception {
        int result;
        String[] args = input.trim().split("\\s+");
        if (args.length != 3)
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[2]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("калькулятор должен принимать на вход числа от 1 до 10 включительно, не более");
        }

        String operator = args[1];

        switch (operator) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> {
                if (b == 0) throw new Exception("не делите на ноль, пожалуйста");
                result = a / b;
            }
            default -> throw new Exception("калькулятор не умеет работать с такими операторами, молодой человек");
        }

        return String.valueOf(result);
    }

    static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();
        System.out.println(calc(input));
        scanner.close();
    }
}

