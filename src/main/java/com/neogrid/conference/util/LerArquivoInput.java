package com.neogrid.conference.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.neogrid.conference.model.Conference;


public class LerArquivoInput {

	private static String gerUrlInput() {
		Properties urlInputProp = PropertiesReader.getFuncionalProp("application.properties");
		return urlInputProp.getProperty("input.url");
	}
	
	public static List<Conference> lerArquivoInput(){
		BufferedReader lerArq = null;
		List<Conference> conferences = new ArrayList<>();
		try {
		FileReader arq = new FileReader(new File(gerUrlInput()));
		lerArq = new BufferedReader(arq);
	 
	    String linha = lerArq.readLine();
	    
	    while (linha != null) {
	        String[] linhaSplit = linha.split(" ");
	        String duracao = linhaSplit[linhaSplit.length-1].replace("min","");
	        Integer tempo = null;
	        if (duracao.equalsIgnoreCase("lightning")) {
	        	tempo = 5;
	        } else {
	        	tempo = Integer.parseInt(duracao); 
	        }
	        conferences.add(new Conference(linha,tempo));
	        linha = lerArq.readLine(); // lê da segunda até a última linha
	      }
	 
	      arq.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				lerArq.close();
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		return conferences;
	}
	
}
