package com.neogrid.conference.proposal;

import com.neogrid.conference.model.Conference;
import com.neogrid.conference.util.LerArquivoInput;

import java.util.List;

public class ConferenceProposals {

	private ConferenceProposals() {throw new IllegalStateException("Utility class");}

	private static void fittingProposals() {
		List<Conference> conferences = LerArquivoInput.lerArquivoInput();
        System.out.println(conferences.toString());
		MontarFaixas.MontarFaixas(conferences);
	}
	
	public static void init() {
		fittingProposals();
	}
}
