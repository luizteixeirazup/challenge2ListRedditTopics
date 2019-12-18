package br.com.zup.challenge.two.integration;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class TitlesIntegration {
	
	public String[] listTitles() {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.reddit.com/r/programming/")).build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		System.out.println(response.body());

		String[] responseSplit = response.body().split("<h3");

//		System.out.println(responseSplit[0]);
		
		String[] titles = new String[responseSplit.length - 1];
				
		for (int i = 1 ; i < responseSplit.length ; i++) {
			titles[i-1] = responseSplit[i].substring(responseSplit[i].indexOf(">") + 1, responseSplit[i].indexOf("<"));
			
//			System.out.println(responseSplit[i].substring(responseSplit[i].indexOf(">") + 1, responseSplit[i].indexOf("<")));
		}
		
		return titles;
	}
}
