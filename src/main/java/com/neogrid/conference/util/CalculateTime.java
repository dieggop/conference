package com.neogrid.conference.util;

import java.util.Date;

public class CalculateTime {
//	Construtor público implicito gerado para satisfazer solução compatível por indicação do SonarLint
	private CalculateTime() {throw new IllegalStateException("Utility class");}
	
//	estática para adicionar minutos a uma determinada hora 
	public static Date addMinute(String time, Integer minutes) {
		String myTime = time;
		int minsToAdd = minutes;
		Date date = new Date();
		date.setTime((((Integer.parseInt(myTime.split(":")[0]))*60 + (Integer.parseInt(myTime.split(":")[1])))+ date.getTimezoneOffset())*60000);
		date.setTime(date.getTime()+ minsToAdd *60000);
		return date;
	}
	
}
