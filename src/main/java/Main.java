import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = 0;
        boolean intScanner = false;

        //Ввод количества человек на которых будет разделен счет
        while (!intScanner) {
            System.out.print("На скольких человек будет разделен счёт? ");
            if(scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 1){intScanner = true;}
                else {
                    System.out.println("Введите количество человек больше одного");
                    }

            } else {
                System.out.println("Некорректное значение. Повторите ввод");
                scanner.next();
            }
        }
        System.out.println("Счет будет разделен на " + number);

        Calculator calculator = new Calculator(number);
        calculator.addProducts();

    }
}