import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        checkYear(2036);
        System.out.println();

        printInstallationMessage();
        System.out.print("\n");

        printDeliveryDays(89);

    }

    private static void checkYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + " - високосный год");
        } else {
            System.out.println(year + " - не високосный год");
        }
    }


    private static void printInstallationMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер ОС, где 0 — iOS, а 1 — Android: ");
        int clientOs = scanner.nextInt();

        if (clientOs != 1 && clientOs != 0) {
            throw new RuntimeException("Устройство не определено");
        }

        System.out.println("Введите год выпуска устройства: ");
        int clientDeviceYear = scanner.nextInt();
        String versionMessage = clientOs == 0 ? "Ios" : "Android";
        int currentYear = LocalDate.now().getYear();
        String productionYear = clientDeviceYear < currentYear ? "облегченную" : "";
        System.out.printf("Установите %s версию приложения для %s по ссылке", productionYear, versionMessage);

    }

    private static void printDeliveryDays(int deliveryDistance) {
        int start = 20;
        int step = 40;
        int deliveryDays;
        if (deliveryDistance < start) {
            deliveryDays = 1;
        } else {
            deliveryDays = ((Math.abs(deliveryDistance - start) / step) + 2);
        }
        System.out.println("Потребуется дней: " + deliveryDays);
    }
}
