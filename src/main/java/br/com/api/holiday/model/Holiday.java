package br.com.api.holiday.model;

import br.com.api.holiday.service.form.HolidayForm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Holiday {

    private String name;
    private String country;
    private String location;
    private String type;
    private String date;
    private String week_day;

    public Holiday() {
    }

    public Holiday(HolidayForm holidayForm) {
        this.name = holidayForm.getName();
        this.country = holidayForm.getCountry();
        this.location = holidayForm.getLocation();
        this.type = holidayForm.getType();
        this.date = holidayForm.getDate();
        this.week_day = holidayForm.getWeek_day();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public static int consultarQtdDias(String mes) {

        switch (mes) {
            case "1":
                return 31;

            case "2":
                return 28;

            case "3":
                return 31;

            case "4":
                return 30;

            case "5":
                return 31;

            case "6":
                return 30;

            case "7":
                return 31;

            case "8":
                return 31;

            case "9":
                return 30;

            case "10":
                return 31;

            case "11":
                return 30;
            case "12":
                return 31;
            default:
                return -1;
        }
    }

    public static List<Holiday> converter(List<HolidayForm> holidayService) {
        List<Holiday> holidays = new ArrayList<>();
        for (HolidayForm h : holidayService){
            holidays.add(new Holiday(h));
        }
        return holidays;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", week_day='" + week_day + '\'' +
                '}';
    }
}
