public class Converter {
    private double STEPS_TO_KM = 0.00075; // коэффициент для перевода вынесен в приватное поле класса
    private double STEPS_TO_CCL = 0.05;   // коэффициент для перевода вынесен в приватное поле класса

    public double convertToKm(int step) {   //добавлен модификатор доступа "public"

        return step*STEPS_TO_KM; // 1. не вводим новую переменную - сразу делаем возврат 2. Работаем напрямую с параметром из метода
    }

    public double convertToKiloCls(int step) {   //добавлен модификатор доступа "public"

        return step*STEPS_TO_CCL; // не вводим новую переменную - сразу делаем возврат 2. Работаем напрямую с параметром из метода
    }
}