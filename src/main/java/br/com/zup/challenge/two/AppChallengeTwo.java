package br.com.zup.challenge.two;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class AppChallengeTwo {

	public static void main(String[] args) throws Exception {

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.reddit.com/r/programming/")).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
//		System.out.println(response.body());

		String[] responseSplit = response.body().split("<h3");

//		System.out.println(responseSplit[0]);
		
		String[] titles = new String[responseSplit.length - 1];
				
		for (int i = 1 ; i < responseSplit.length ; i++) {
			titles[i-1] = responseSplit[i].substring(responseSplit[i].indexOf(">") + 1, responseSplit[i].indexOf("<"));
//			System.out.println(responseSplit[i].substring(responseSplit[i].indexOf(">") + 1, responseSplit[i].indexOf("<")));
		}
		
		String[] sortedTitles = doInsertionSort(titles);
		
		for (String st : sortedTitles) {
			System.out.println(st);
		}
		
	}
		
	public static String[] doInsertionSort(String[] input) {
		
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
