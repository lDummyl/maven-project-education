package task2;

public class Boss {

   /* static double getKpiFromHrToEstimateFactor(double KPI) { //Взять у HR KPI для проставления рейтинга по которому сотрудники получат бонус
        return KPI;
    }*/

    static double tellAccountantFactorForBonus(double KPI) {   //сообщить какой коэффициент у сотрудника для распределения премии

        double factorForBonus = 10.5 * KPI;   // получить коэффициенты для выставления бонуса
        return factorForBonus;
    }
    double factorForBonus;
    Boss(double factorForBonus){
        this.factorForBonus = factorForBonus;
    }
}
