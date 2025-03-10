import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercentFunction(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return getRound(pay, 2);
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int depositPeriod) {
        return getRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double getRound(double value, int places) {
        double ScaLe = Math.pow(10, places); // Переменную ScaLe лучше привести к виду scale
        return Math.round(value * ScaLe)/ ScaLe;
    }

    void printResultDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt(); // Для большего удобста чтения кода переменные amount, period, action и outDoubleVar лучше объявить в начале метода;
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        double outDoubleVar = 0;
        if (action == 1) outDoubleVar = calculateSimplePercentFunction(amount, 0.06, period);
        else if (action == 2) {
            outDoubleVar = calculateComplexPercentFunction(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().printResultDeposit();
    }
}
