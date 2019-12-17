package br.com.zup.challenge.two;

import br.com.zup.challenge.two.service.TitlesService;

public class AppChallengeTwo {

	public static void main(String[] args) throws Exception {
		
		TitlesService service = new TitlesService();
		
		String[] sortedTitles = service.sortAlpha();
		
		for (String st : sortedTitles) {
			System.out.println(st);
		}
	}
}
