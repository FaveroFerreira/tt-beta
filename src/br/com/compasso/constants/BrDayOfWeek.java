package br.com.compasso.constants;

import java.time.DayOfWeek;

public enum BrDayOfWeek {

    SEGUNDA(DayOfWeek.MONDAY),
    TERÇA(DayOfWeek.TUESDAY),
    QUARTA(DayOfWeek.WEDNESDAY),
    QUINTA(DayOfWeek.THURSDAY),
    SEXTA(DayOfWeek.FRIDAY),
    SÁBADO(DayOfWeek.SATURDAY),
    DOMINGO(DayOfWeek.SUNDAY);

    private DayOfWeek dayOfWeek;

    BrDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
