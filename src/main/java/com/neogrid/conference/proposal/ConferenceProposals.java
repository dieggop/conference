package com.neogrid.conference.proposal;

import com.neogrid.conference.model.Conference;
import com.neogrid.conference.util.LerArquivoInput;

import java.text.ParseException;
import java.util.List;

public class ConferenceProposals {

	private ConferenceProposals() {throw new IllegalStateException("Utility class");}

	private static void fittingProposals() {
		List<Conference> conferences = LerArquivoInput.lerArquivoInput();
		MontarFaixas m = new MontarFaixas();
		try {
			m.MontarFaixas(conferences);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void init() {
		fittingProposals();
	}
}
