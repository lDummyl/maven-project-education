package task6;

/*
	Реализовать алгоритм интерполяционного многочлена Лагранжа
	по данной ссылке использовать реализацию C# и адаптировать ее в синтаксис Java
	https://ru.wikibooks.org/wiki/%D0%A0%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8_%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D0%BE%D0%B2/%D0%98%D0%BD%D1%82%D0%B5%D1%80%D0%BF%D0%BE%D0%BB%D1%8F%D1%86%D0%B8%D1%8F/%D0%9C%D0%BD%D0%BE%D0%B3%D0%BE%D1%87%D0%BB%D0%B5%D0%BD_%D0%9B%D0%B0%D0%B3%D1%80%D0%B0%D0%BD%D0%B6%D0%B0

 */

import task7.Calculation;
import task7.CirculatingPump;
import task7.Sales;
import task7.Writer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        {
            LagrangeInterpolator lagrangeInterpolator = new LagrangeInterpolator();
            lagrangeInterpolator.setPoints(Arrays.asList(new Point(1,1),new Point(2,4), new Point(3,9)));
            float y = lagrangeInterpolator.getY(5);
            Calculation calculation = new Calculation();
            Writer writer = new Writer();
            Sales sales = new Sales();
            File jsonFormatFile = new File("C:\\Users\\Krugl\\IdeaProjects\\maven-project-education\\circulatingPump.json");
            writer.getJsonFormatFile(jsonFormatFile, calculation.getListOfSuitablePump(calculation.getX()));
            List <CirculatingPump> list = writer.getJsonReport(jsonFormatFile);
            list.forEach(System.out::println);
            System.out.println(sales.getMiddleSum(list));
            System.out.println(sales.getTotalSum(list));


            // TODO: 01.04.2021 и тут мы точно знаем что он будет 25 потому что порабола y = x^2
            //  именно это и длает полином, по двум точкам он формирует линйную функцию, y = ax + с
            //  а по 3 квадратичную y = ax2 + bx + c
            //  это нужно поскольку нельзя просто так взять и посичтать производительность насоса, она характеризуется не цифрой
            //  а кривой
            //  и вот чтобы внести эту кривую нужно знать какой функцией она описывается, а мы не знаем и ниге этого нет
            //  и уж если на то пошло она вообще эмпирическая
            //  но ее всегда дают на графике, чтобы подбирать ручками, так вот можно снять линейкой всего 3 точки
            //  с этого графика запустить в интерполятор и он выдаст функцию, в данной реализации вычислит еще значение по x
            //  правда для подбора этого не достаточно поскольку мы знаем колько нужно водички нам в L м3/ч и то
            //  какое давление теряется в сети на трение P м
            //  простоты ради мы всего лишь должны убедится что точка наша l и p которую вводит пользователь в исходных
            //  данные для подбора находится ниже нашего графика насоса. То есть Х это расход и если давление(У) при этом X
            //  будет больше чез запросил клиент, то насос нам подходит. Но если нам подходят много насосв, как выбрать
            //  я в свое время решил эту задачу следующим образом---------------------------------------------------------------------------------------спойлер-----------------------------------> просто отсортировал все насаосы по цене и подбирал от самого дешевого по очереди пока не найду первый подходящий.
            //  есть примерно миллион нюансов с этим всем связанный, но сильно не стоит усложнять
            //  я в свое время хранил в качестве характеристики насоса коэфициенты трехчлена
            //  собственно значения a, b, c из ф-ции y = ax2 + bx + c, потом подставлял и решал через дискриминант
            //  в данной реализации можно просто хранить точки в вычилсять каждый раз через интерполятор.
            //
            System.out.println("y = " + y);

        }
    }
}
