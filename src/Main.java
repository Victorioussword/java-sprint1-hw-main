import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true){    // используется конструкция switch/case (вместо if/else)
            printMenu();
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("Вы выбрали - 1- Введите новое значение цели");
                    stepTracker.setDayTarget(scanner.nextInt());  // лишние объекты сканнера удалены
                    stepTracker.showMecurentTarget();
                    break ;

                case 2:
                    System.out.println("Вы выбрали - 2 - Ввод пройденного количества шагов за день");
                    stepTracker.saveSteps();   // лишние объекты сканнера удалены, число сразу предается в метод
                    break;

                case 3:
                    System.out.println("Вы выбрали - 3 - Вывод статистики за определенный месяц");
                    StepTracker.printMenuMonth();
                    stepTracker.statistic(scanner.nextInt());   // лишние объекты сканнера удалены
                     break;

                case 0:
                    System.out.println("Программа завершена");
                    scanner.close();    // Добалено закрытие сканнера
                    return;     //вмесмто break имспользован return для выхода из программы, переменная типа boolean для запуска цикла удалена

                default:
            System.out.println("Такой команды не существует "+"\n"+" * * * " + "\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввод вашей цели по количеству шагов в день");
        System.out.println("2 - Ввод пройденного количества шагов за день");
        System.out.println("3 - Вывод статистики за определенный месяц");
        System.out.println("0 - Выход");
    }
}