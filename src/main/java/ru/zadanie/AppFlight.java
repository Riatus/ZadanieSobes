package main.java.ru.zadanie;

import main.java.ru.zadanie.data.Ticket;
import main.java.ru.zadanie.services.Calculate;
import main.java.ru.zadanie.services.TicketService;

import java.util.ArrayList;
import java.util.List;

public class AppFlight {

    public static void main(String[] args) {

        // парсер JSON
        List<Ticket> tickets = new ArrayList<>(
                TicketService.getTicketsJson("D:\\ZadanieOtRab\\src\\main\\java\\ru\\zadanie\\services\\tickets.json"));

        // Расчет Среднего времени полета
        long averagTimeFlight = Calculate.averageTimeOfFlight(tickets);
        System.out.println("Среднее время полета: " + averagTimeFlight / 60 / 60 + " часов " + (averagTimeFlight / 60) % 60 + " мин.");

        // Расчет процентиля
        long percentile = Calculate.percentileTimeOfFlight(tickets, 0.90);
        System.out.println("90-й процентиль времени полета между городами  Владивосток и Тель-Авив = "
                + percentile / 60 / 60 + " часов " + (percentile / 60) % 60 + " мин.");
    }
}

