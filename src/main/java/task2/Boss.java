package task2;

public class Boss {

    double getKpiFromHrToEstimateFactor(double KPI) { //Взять у HR KPI для проставления рейтинга по которому сотрудники получат бонус
        return KPI;
    }

    double tellAccountantFactorForBonus(double KPI) {   //сообщить какой коэффициент у сотрудника для распределения премии

        double factorForBonus = 22.5 * getKpiFromHrToEstimateFactor(KPI);   // получить коэффициенты для выставления бонуса
        return factorForBonus;
    }
}
