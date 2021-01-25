package br.com.compasso;

import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DayOfWork {

    private static final DateTimeFormatter hourFormatter = ofPattern("HH:mm");
    private static final DateTimeFormatter dateFormatter = ofPattern("dd/MM/yyyy");

    private LocalDate date;
    private LocalDateTime morningJourneyStart;
    private LocalDateTime morningJourneyFinish;
    private LocalDateTime eveningJourneyStart;
    private LocalDateTime eveningJourneyFinish;

    public DayOfWork(LocalDate date) {
        int gracePeriod1 = getRandomInt(15);
        int gracePeriod2 = getRandomInt(21);

        this.date = date;
        this.morningJourneyStart = date.atStartOfDay().withHour(8).withMinute(25).plusMinutes(gracePeriod1);
        this.morningJourneyFinish = date.atStartOfDay().withHour(11).withMinute(55).plusMinutes(gracePeriod2);
        this.eveningJourneyStart = date.atStartOfDay().withHour(12).withMinute(55).plusMinutes(gracePeriod2);
        this.eveningJourneyFinish = date.atStartOfDay().withHour(18).withMinute(13).plusMinutes(gracePeriod1);
    }

    public int minuteRandomFactor() {
        int num = getRandomInt(100);

        if (num < 30) {
            return num / ((int) (pow(10, (int) log(num))));
        }

        return 0;
    }

    private int getRandomInt(int max) {
        return new Random().nextInt(max);
    }

    public static DateTimeFormatter getHourFormatter() {
        return hourFormatter;
    }

    public LocalDateTime getMorningJourneyStart() {
        return morningJourneyStart;
    }

    public void setMorningJourneyStart(LocalDateTime morningJourneyStart) {
        this.morningJourneyStart = morningJourneyStart;
    }

    public LocalDateTime getMorningJourneyFinish() {
        return morningJourneyFinish;
    }

    public void setMorningJourneyFinish(LocalDateTime morningJourneyFinish) {
        this.morningJourneyFinish = morningJourneyFinish;
    }

    public LocalDateTime getEveningJourneyStart() {
        return eveningJourneyStart;
    }

    public void setEveningJourneyStart(LocalDateTime eveningJourneyStart) {
        this.eveningJourneyStart = eveningJourneyStart;
    }

    public LocalDateTime getEveningJourneyFinish() {
        return eveningJourneyFinish;
    }

    public void setEveningJourneyFinish(LocalDateTime eveningJourneyFinish) {
        this.eveningJourneyFinish = eveningJourneyFinish;
    }

    @Override
    public String toString() {
        return String.format("     %s     |     %s     |     %s     |     %s     |     %s     ",
                date.format(dateFormatter), morningJourneyStart.format(hourFormatter), morningJourneyFinish.format(hourFormatter),
                eveningJourneyStart.format(hourFormatter), eveningJourneyFinish.format(hourFormatter));
    }
}
