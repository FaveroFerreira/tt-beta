package br.com.compasso.constants;

import java.time.LocalDate;
import java.time.Month;

public enum BrMonth {

    JANEIRO(Month.JANUARY),
    FEVEREIRO(Month.FEBRUARY),
    MARÇO(Month.MARCH),
    ABRIL(Month.APRIL),
    MAIO(Month.MAY),
    JUNHO(Month.JUNE),
    JULHO(Month.JULY),
    AGOSTO(Month.AUGUST),
    SETEMBRO(Month.SEPTEMBER),
    OUTUBRO(Month.OCTOBER),
    NOVEMBRO(Month.NOVEMBER),
    DEZEMBRO(Month.DECEMBER);

    private Month month;

    BrMonth(Month month) {
        this.month = month;
    }

    public static BrMonth getCurrentMonth() {
        Month month = Month.from(LocalDate.now());

        for (BrMonth iter : BrMonth.values()) {
            if (iter.month == month) {
                return iter;
            }
        }

        return null;
    }
}
