package com.neogrid.conference;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.neogrid.conference.util.CalculateTime;

public class ConferenceApplication {
	
	static LocalTime specificTime = LocalTime.of(11,20,25,40);
	
	public static void main(String[] args) {
		
		conferenceMount();
		
	}
	
	
	
	static void conferenceMount() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm");
		
		System.out.println("Hora original: " + df.format(specificTime));
		 
		Date retorno = CalculateTime.addMinute(df.format(specificTime), 10);
		
		df = DateTimeFormatter.ofPattern("hh:mm a");
		System.out.println("Hora Modificada: " + df.format(LocalTime.of(retorno.getHours(), retorno.getMinutes())));

	}

}
