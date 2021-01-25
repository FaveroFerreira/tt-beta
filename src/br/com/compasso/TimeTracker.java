package br.com.compasso;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.format.DateTimeFormatter.ofPattern;

import br.com.compasso.constants.BrMonth;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class TimeTracker {

    public static final DateTimeFormatter dateFormatter = ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        BrMonth currMonth = BrMonth.getCurrentMonth();

        System.out.println("GERANDO TIMESHEET DE: " + currMonth + " \b");

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("        DATA        |    INICIO     |    ALMOÇO     |    RETORNO    |      FIM     ");
        System.out.println("-----------------------------------------------------------------------------------");

        LocalDate startOfMonth = YearMonth.now().atDay(1);
        LocalDate endOfMonth = YearMonth.now().atEndOfMonth();

        for (LocalDate date = startOfMonth; date.isBefore(endOfMonth); date = date.plusDays(1)) {
            if (isWeekend(date.getDayOfWeek())) {
                continue;
            }

            generateDayOfWork(date);
        }
    }

    private static void generateDayOfWork(LocalDate date) {
        DayOfWork dayOfWork = new DayOfWork(date);
        System.out.println(dayOfWork);
    }

    private static boolean isWeekend(DayOfWeek dayOfWeek) {
        return SATURDAY == dayOfWeek || SUNDAY == dayOfWeek;
    }
}
