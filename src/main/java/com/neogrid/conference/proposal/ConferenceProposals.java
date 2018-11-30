package com.neogrid.conference.proposal;

import com.neogrid.conference.model.Conference;
import com.neogrid.conference.util.LerArquivoInput;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalTime;
import java.util.List;

public class ConferenceProposals {

	static LocalTime specificTime = LocalTime.of(11,20,25,40);
	private ConferenceProposals() {throw new IllegalStateException("Utility class");}

	private static void fittingProposals() {
		List<Conference> conferences = LerArquivoInput.lerArquivoInput();
		MontarFaixas.MontarFaixas(conferences);
	}
	
	public static void init() {
		fittingProposals();
	}
}
