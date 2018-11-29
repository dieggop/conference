package com.neogrid.conference.com.neogrid.conference;

import java.time.LocalTime;
import java.util.List;

import com.neogrid.conference.model.Conference;
import com.neogrid.conference.util.LerArquivoInput;

public class ConferenceProposals {

	static LocalTime specificTime = LocalTime.of(11,20,25,40);
	private ConferenceProposals() {throw new IllegalStateException("Utility class");}
	
	private static void fittingProposals() {

		List<Conference> conferences = LerArquivoInput.lerArquivoInput();
		
		System.out.println(conferences.toString());
	}
	
	public static void init() {
		fittingProposals();
	}
}
