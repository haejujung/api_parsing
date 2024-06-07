package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExplorer {

	public static void main(String[] args) throws IOException {

		StringBuilder urlbuBuilder = new StringBuilder("http://localhost:8080/test");
		urlbuBuilder.append("?" + URLEncoder.encode(null));

		URL url = new URL(urlbuBuilder.toString());

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");
		conn.setRequestProperty("content-type", "application/json");

		System.out.println("Response code : " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
		

		Todos todos1 = new Todos(1, 1, "delectus aut autem", "false");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String todos1Str = gson.toJson(todos1);
		System.out.print(todos1Str);
		
		Todos todoObject = gson.fromJson(todos1Str, Todos.class);
		System.out.println(todoObject.getCompleted());
		

	}

}
