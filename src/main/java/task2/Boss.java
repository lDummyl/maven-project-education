package task2;

public class Boss extends Employee {

   /* static double getKpiFromHrToEstimateFactor(double KPI) { //Взять у HR KPI для проставления рейтинга по которому сотрудники получат бонус
        return KPI;
    }*/

    double tellAccountantFactorForBonus(double KPI) {   //сообщить какой коэффициент у сотрудника для распределения премии

         // получить коэффициенты для выставления бонуса
        return factorForBonus * KPI;
    }
    double factorForBonus;

    public Boss(String name, int age, int rate, int workingHours, int overtimeHours, double factorForBonus) {
        super(name, age, rate, workingHours, overtimeHours);
        this.factorForBonus = factorForBonus;
    }
}
