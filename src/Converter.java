public class Converter {
    double STEPS_TO_KM = 0.00075; // коэффициент для перевода вынесен в приватное поле класса
    double STEPS_TO_CCL = 0.05;   // коэффициент для перевода вынесен в приватное поле класса

    public double convertToKm(int step) {   //добавлен модификатор доступа "public"
        double stp = step;
        return stp*STEPS_TO_KM; // не вводим новую переменную - сразу делаем возврат
    }

    public double convertToKiloCls(int step) {   //добавлен модификатор доступа "public"
        double stp = step;
        return stp*STEPS_TO_CCL; // не вводим новую переменную - сразу делаем возврат
    }
}