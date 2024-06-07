package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpServer;

public class GsonHttpServer {

	public static void main(String[] args) {

		Todos todos1 = new Todos(1, 1, "delectus aut autem", "false");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String todos1Str = gson.toJson(todos1);
		System.out.print(todos1Str);
		
		System.out.println("-----------------------------");
		
		String urlString = "https://jsonplaceholder.typicode.com/todos/1";

		URL url;
		try {
			url = new URL(urlString);

			try {
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();

				conn.setRequestMethod("GET");

				int responseCode = conn.getResponseCode();
				System.out.println(" HTTP CODE : " + responseCode);

				BufferedReader brIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				String inputLine;
				StringBuffer responseBuffer = new StringBuffer();

				while ((inputLine = brIn.readLine()) != null) {
					responseBuffer.append(inputLine);
				}

				brIn.close();

				String[] strHtmls = responseBuffer.toString().split("\\s");
				for (String word : strHtmls) {
					System.out.println(word);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
