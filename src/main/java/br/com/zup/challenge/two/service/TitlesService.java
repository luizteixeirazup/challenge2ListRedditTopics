package br.com.zup.challenge.two.service;

import br.com.zup.challenge.two.repository.TitlesRepository;

public class TitlesService {
	
	TitlesRepository repository = new TitlesRepository();
	
	public String[] sortAlpha() {
		
		String[] input = repository.listTitle();
		
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
