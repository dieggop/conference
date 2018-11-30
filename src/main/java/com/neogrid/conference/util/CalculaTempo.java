package com.neogrid.conference.util;

import java.util.Date;

/**
 * Classe util criada para suprir necessidade de trabalhar com horas
 */
public class CalculaTempo {
    /**
     * Construtor público implicito gerado para satisfazer solução compatível por indicação do SonarLint.
     * Classe com método estático que não deve ser instanciada.
     */
	private CalculaTempo() {throw new IllegalStateException("Utility class");}


	/**
	 * Método criado para fazer o acréscimo de minutos a determinada hora.
	 * Enviando como argumento para este método estático A hora em formato String e o minuto a ser acrescentado
	 * em formato Integer. O Método faz a inserção desde minuto a determinada hora, convertendo a hora em
	 * milisegundos e assim fazendo a conversão dos minutos também me milisegundos e somando-os.
	 * Após isto é criado um objeto tipo Date para inserir a hora e assim retornar.
	 *
	 * @param time
	 * @param minutes
	 * @return Date
	 */
	public static Date addMinute(String time, Integer minutes) {
		String myTime = time;
		int minAdd = minutes;
		Date date = new Date();
		date.setTime((((Integer.parseInt(myTime.split(":")[0]))*60 + (Integer.parseInt(myTime.split(":")[1])))+ date.getTimezoneOffset())*60000);
		date.setTime(date.getTime()+ minAdd *60000);
		return date;
	}
	
}
