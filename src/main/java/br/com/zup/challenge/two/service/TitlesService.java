package br.com.zup.challenge.two.service;

import br.com.zup.challenge.two.integration.TitlesIntegration;

public class TitlesService {
	
	TitlesIntegration integration = new TitlesIntegration();
	
	public String[] sortAlpha() {
		
		String[] input = integration.listTitles();
		
		String temp;
		
		for (int i = 1 ; i < input.length; i++) {
			for (int j = i ; j > 0 ; j--) {
				if (input[j].compareTo(input[j-1]) < 0) {
					temp = input[j];
					input[j] = input[j-1];
					input[j-1] = temp;
				}
			}
		}
		
		return input;
	}
}
