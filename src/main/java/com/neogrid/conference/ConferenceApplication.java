package com.neogrid.conference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neogrid.conference.proposal.ConferenceProposals;

@SpringBootApplication
public class ConferenceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConferenceApplication.class, args);
		ConferenceProposals.init();
		
	}
}
