package com.neogrid.conference.proposal;

import com.neogrid.conference.model.Conference;
import com.neogrid.conference.util.CalculaTempo;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class MontarFaixas {
    private List<Conference> conferences = null;
    private List<Conference> conferenciasMontadas = new ArrayList<>();
    static SimpleDateFormat formatter = null;

    private String hora = "08:00";
    private String horaMeioDia = "12:00";
    private String horaFimAceitavelDia = "16:00";
    private String horaFimDia = "17:00";
    private long horasManha = 180;
    private long horasTarde = 240;

    public void MontarFaixas(List<Conference> con) throws ParseException {
        conferences = con;
        formatter = new SimpleDateFormat("HH:mm");
        Collections.sort(conferences, Collections.reverseOrder(new Comparator<Conference>() {
            @Override
            public int compare(Conference conferencia1, Conference conferencia2)
            {
                return  conferencia1.getTime().compareTo(conferencia2.getTime());
            }
        }));

        Date horaSomada = CalculaTempo.addMinute(hora, 0);
//
        for (Conference conf : conferences) {
            horaSomada = CalculaTempo.addMinute(formatter.format(horaSomada), conf.getTime());

            System.out.println(conf.getName() + " - " + conf.getTime() + " -- " + horaSomada);
        }

        horaSomada = CalculaTempo.addMinute(hora, 0);
        for (Conference conference : conferences){
            if (horasManha > 0 && conference.getTime() < horasManha) {
                horaSomada = CalculaTempo.addMinute(formatter.format(horaSomada), conference.getTime());
                conferenciasMontadas.add(conference);
                horasManha = horasManha-conference.getTime();
                System.out.println(horasManha);
            }

            if (horasManha == 0) {
                horasManha =horasManha+60;
                conferenciasMontadas.add(new Conference("Lunch", 60));
            }
        }

        for (Conference conf : conferenciasMontadas) {
//            horaSomada = CalculaTempo.addMinute(formatter.format(horaSomada), conf.getTime());
            System.out.println(conf.getName() + " - " + conf.getTime());
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
