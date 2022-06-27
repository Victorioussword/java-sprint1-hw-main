import java.util.Scanner;

public class StepTracker {
    private Converter converter = new Converter();   // добавлен модификатор доступа privat
    private Scanner scanner;
    private int[][] monthToData = new int[12][30]; // сразу инициализирован в месте объявления
    private int dayTarget = 10000;

    public StepTracker(Scanner scanner) {  //инициализирован сканер через параметры конструктора, передается уже готовый объект из Main
        this.scanner = scanner;
    }

    public void statistic(int month) {        //удалена ненужная переменная month1

        if (month <= 0 || month>12) {   // Введена проверка на отрицательное значения и значения больше 12
            System.out.println("Ошибка ввода месяца! Введено отрицательное число, число больше 12 или 0" + "\n" + " * * * " + "\n");
        } else {
            while (true) {
                printMenuAct();
                int userInput = scanner.nextInt();

                switch (userInput) {    // используется конструкция switch/case (вместо if/else)

                    case 1:
                        System.out.println("Ваш Выбор - 1 - Показать количество пройденных шагов по дням");
                        showStepsPerDay(month);
                        break;

                    case 2:
                        System.out.println("Ваш выбор - 2 - Показать общее количество шагов за месяц");
                        System.out.println("За месяц " + month + " вы прошли " + sumStepsPerMonth(month) + " шагов");
                        break;

                    case 3:
                        System.out.println("Ваш выбор - 3 - Показать максимальное пройденное количество шагов в месяце;");
                        findMaxSteps(month);
                        break;

                    case 4:
                        System.out.println("Ваш выбор - 4 - Показать среднее количество количество шагов за месяц");
                        System.out.println("Среднее количество шагов за " + month + "месяц составляет " + ((sumStepsPerMonth(month)) / 30));
                        break;

                    case 5:
                        System.out.println("Ваш выбор 5 - Показать пройденную дистанция (в км)");
                        System.out.println("Пройденная дистация за " + month + " месяц составляет " + converter.convertToKm(sumStepsPerMonth(month)) + " км");
                        break;

                    case 6:
                        System.out.println("Ваш выбор 6 - Количестю сожжённых килокалорий;");
                        System.out.println("За " + month + " высожгли " + converter.convertToKiloCls(sumStepsPerMonth(month)) + " ККал");
                        break;

                    case 7:
                        System.out.println("Ваш выбор - 7 - Лучшая серия: максимальное количество подряд идущих дней," + "\n" + " в течение которых количество шагов за день было равно или выше целевого");
                        System.out.println("Лучшая серия в " + month + " месяце составляет " + findbestSeries(month));
                        break;
                    case 0:
                        System.out.println("Ваш выбор - 0 - Выход в главное меню"+ "\n" + " * * * " + "\n");
                        return;   //вмесмто break имспользован return для выхода из программы, переменная типа boolean для запуска цикла удалена
                    default:
                        System.out.println("Такой команды не существует " + "\n" + " * * * " + "\n");
                }
            }
        }
    }

    public void saveSteps() {   //добавлен модификатор доступа "public"
                                                           // Удален не нужный сканнер
        System.out.println("Выберите месяц");
        printMenuMonth();
        int month = scanner.nextInt();
        System.out.println("Выберете день месяца [1 - 30]");
        int day = scanner.nextInt();
        System.out.println("Введите пройденные шаги");
        int inSteps = scanner.nextInt();

        if (inSteps < 0 || day < 1 || month<1 || day>30 || month>12) {   // 1. Введена проверка на отрицательное значение 2. Введена проверка верхней границы 3. Откорректированы условия day<1 и month<1
            System.out.println("Ошибка ввода!");
        } else {
            monthToData[month - 1][day - 1] = inSteps;
            System.out.println("Вы ввели " + inSteps + " шагов.");
        }
    }

    public static void printMenuMonth() {  // Убрать модификатор доступа static не возможно, так как метод используется и в классе StaepTraker и в классе Main
       System.out.println("Выберете месяц");
       System.out.println("1 - Январь");
       System.out.println("2 - Февраль");
       System.out.println("3 - Март");
       System.out.println("4 - Апрель");
       System.out.println("5 - Май");
       System.out.println("6 - Июнь");
       System.out.println("7 - Июль");
       System.out.println("8 - Август");
       System.out.println("9 - Сентябрь");
       System.out.println("10 - Октябрь");
       System.out.println("11 - Ноябрь");
       System.out.println("12 - Декабрь");
    }

    private void printMenuAct() {    // убран модификатор доступа static
        System.out.println("\n" + "Что вы хотите сделать?");
        System.out.println("1 - Показать количество пройденных шагов по дням");
        System.out.println("2 - Показать общее количество шагов за месяц");
        System.out.println("3 - Показать максимальное пройденное количество шагов в месяце;");
        System.out.println("4 - Показать среднее количество количество шагов за месяц;");
        System.out.println("5 - Показать пройденную дистанция (в км);");
        System.out.println("6 - Количестю сожжённых килокалорий;");
        System.out.println("7 - Лучшая серия: максимальное количество подряд идущих дней," + "\n" + " в течение которых количество шагов за день было равно или выше целевого");
        System.out.println("0 - Выход в главное меню");
    }

    public void setDayTarget(int newDayTarget1) {
        if (newDayTarget1 < 0) {   // Введена проверка на отрицательное значение
            System.out.println("Ошибка! Введено отрицательныое число");
        } else {
            dayTarget = newDayTarget1;
            System.out.println("Установлена новая цель - " + dayTarget + " шагов.");
        }
    }

    private void showStepsPerDay(int month) {    //удалена ненужная переменная month1

        System.out.println("\n" + "Статистика за " + month + " месяц (шаг):");
        for (int j = 0; j < monthToData[month - 1].length; j++) {
            System.out.print("День " + (j + 1) + ": " + monthToData[month - 1][j] + "; ");
        }
        System.out.print("\n");
    }

    private int sumStepsPerMonth(int month) {  //удалена ненужная переменная month1

            int summ = 0;
            for (int j = 0; j < monthToData[month - 1].length; j++) {
                summ = summ + monthToData[month - 1][j];
            }
            return summ;
    }

    private void findMaxSteps(int month) {    //удалена ненужная переменная month1

        int maxStep = 0;
        for (int j = 0; j < monthToData[month - 1].length; j++) {
            if (monthToData[month - 1][j] > maxStep) {
                maxStep = monthToData[month - 1][j];
            }
        }
        System.out.println("Максимальное количество шагов сделанно в " + month + " месяце составляет " + maxStep);
    }

    private int findbestSeries(int month) {  //удалена ненужная переменная month1

        int bestSeries = 0;
        int currentSeries = 0;
        for (int j = 0; j < 30; j++) {   // оптимимизирован поиск серии, удалена лишняя проверка
            if (monthToData[month - 1][j] >= dayTarget) { // откорректировн поиск лучшей серии
                currentSeries++;
                if (bestSeries < currentSeries)
                    bestSeries = currentSeries;
            } else {
                currentSeries = 0;
            }
        }
        return bestSeries;
    }

    public void showMecurentTarget () {
            System.out.println("Текущая цель составляет " + dayTarget + "\n" + "* * *");
        }
    }