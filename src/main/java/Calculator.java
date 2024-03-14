import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public Calculator(int totalPersons) {
        this.totalPersons = totalPersons;

    }
    static ArrayList<Product> products = new ArrayList<>();
    static int totalPersons;
    static double calculate(){
        double sum = 0;
        for (Product product:products) {sum += product.price;}
        return sum;
    }
    static void addProducts(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Здравствуйте!");
        System.out.println("Сделайте заказ (для завершения введите 'завершить'): ");

        String productName;
        double productPrice;
        double totalPrice = 0;
        Declension roubles;

        do {
            System.out.print("Наименование товара: ");
            productName = scanner.nextLine();

            if (!productName.equalsIgnoreCase("завершить")) {
                System.out.print("Цена товара: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Некорректное значение. Повторите ввод");
                    scanner.next();
                }
                productPrice = scanner.nextDouble();
                scanner.nextLine();

                if (productPrice > 0) {
                    Product product = new Product(productName, productPrice);

                    roubles = new Declension(product.price);
                    System.out.println("Товар '" + product.name + "' добавлен в счет, стоимость: " + String.format("%.2f", product.price)+roubles.getDeclension());

                    products.add(product);
                    totalPrice = calculate();

                    roubles = new Declension(totalPrice);

                    System.out.println("Добавлено товаров на сумму "+String.format("%.2f", totalPrice) + roubles.getDeclension());
                } else {
                    System.out.println("Введите цену товара больше нуля");
                }
            }
        } while (!productName.equalsIgnoreCase("завершить"));

        double result = totalPrice/totalPersons;
        roubles = new Declension(result);
        System.out.println("Каждый из вас должен заплатить по  "+String.format("%.2f", result) +roubles.getDeclension());
    }
}
