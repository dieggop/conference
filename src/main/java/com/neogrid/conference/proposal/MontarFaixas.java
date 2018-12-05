package com.neogrid.conference.proposal;

import com.neogrid.conference.model.Conference;
import com.neogrid.conference.util.CalculaTempo;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MontarFaixas {
    private List<Conference> conferences = null;
    private List<Conference> conferenciasManha = new ArrayList<>();
    private List<Conference> conferenciasTarde = new ArrayList<>();
    static SimpleDateFormat formatter = null;

    private String hora = "08:00";
    private long horasManha = 180;
    private long horasTarde = 240;

    public void MontarFaixas(List<Conference> con) throws ParseException {
        conferences = con;


        montaConferenciasManha();
        montaConferenciasTarde();
        Date horaSomada = CalculaTempo.addMinute(hora, 0);

        for (Conference conf : conferenciasManha) {
            horaSomada = CalculaTempo.addMinute(formatter.format(horaSomada), conf.getTime());

            System.out.println(conf.getName() + " - " + conf.getTime() + " -- " + horaSomada);
        }
        System.out.println("Tarde");
        for (Conference conf : conferenciasTarde) {
            System.out.println(conf.getName() + " - " + conf.getTime());
        }
    }

    private void montaConferenciasTarde() {
        Date horaSomada = CalculaTempo.addMinute(hora, 0);
        formatter = new SimpleDateFormat("HH:mm");
        List<Conference> conferencesIterar = new ArrayList<>();
        conferencesIterar = conferences;
        Iterator<Conference> it = conferencesIterar.iterator();

        while (it.hasNext()) {
            Conference conference = it.next();
            horaSomada = CalculaTempo.addMinute(formatter.format(horaSomada), conference.getTime());
            if (horasTarde > 0 && conference.getTime() < horasTarde) {
                conferenciasTarde.add(conference);
                horasTarde = horasTarde-conference.getTime();
            }
        }


    }

    private void montaConferenciasManha() {
        Date horaSomada = CalculaTempo.addMinute(hora, 0);
        formatter = new SimpleDateFormat("HH:mm");

        List<Conference> conferencesIterar = new ArrayList<>();
        conferencesIterar = conferences;
        Iterator<Conference> it = conferencesIterar.iterator();

        while (it.hasNext()) {
            Conference conference = it.next();
            horaSomada = CalculaTempo.addMinute(formatter.format(horaSomada), conference.getTime());
            if (horasManha > 0 && conference.getTime() < horasManha) {
                conferenciasManha.add(conference);
                horasManha = horasManha-conference.getTime();
            }
        }


    }


    public static boolean isBetween(LocalTime candidate, LocalTime start, LocalTime end) {
        formatter = new SimpleDateFormat("HH:mm");
        candidate = LocalTime.parse(formatter.format(candidate));
        return !candidate.isBefore(start) && !candidate.isAfter(end);  // compara se esta entre.
    }
    public static boolean isBefore(LocalTime candidate, LocalTime compare) {
        formatter = new SimpleDateFormat("HH:mm");

        return !candidate.isBefore(compare);  // compara se esta após.
    }
    public static boolean isAfter(Date candidate, LocalTime compare) {
        formatter = new SimpleDateFormat("HH:mm");
        LocalTime lCandidate = LocalTime.parse(formatter.format(candidate));

        return !lCandidate.isAfter(compare);  // compara se está antes.
    }

    
}
