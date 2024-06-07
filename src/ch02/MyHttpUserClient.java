package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyHttpUserClient {

	public static void main(String[] args) {

		// 순수 자바코드에서 HTTP 통신
		// 1. 서버주소 경로
		// 2. URL 클래스 필요
		// 3. url.openConnection() <-- 스트림 I/O

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users/1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("content-type", "application/json");

			int responsedCode = conn.getResponseCode();
			System.out.println("responseCod : " + responsedCode);

			BufferedReader in = new BufferedReader((new InputStreamReader(conn.getInputStream())));
			String inputLine;
			StringBuffer buffer = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);

			}
			in.close();
			System.out.println(buffer.toString());
			System.out.println("------------------------");

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			User userDTO = gson.fromJson(buffer.toString(), User.class);

			System.out.println(userDTO.getId());
			System.out.println(userDTO.getName());
			System.out.println(userDTO.getUsername());
			System.out.println(userDTO.getEmail());
			System.out.println(userDTO.getAddress().getStreet());
			System.out.println(userDTO.getAddress().getSuite());
			System.out.println(userDTO.getAddress().getCity());
			System.out.println(userDTO.getAddress().getZipcode());
			System.out.println(userDTO.getAddress().getGeo().getLat());
			System.out.println(userDTO.getAddress().getGeo().getLng());
			System.out.println(userDTO.getPhone());
			System.out.println(userDTO.getWebsite());
			System.out.println(userDTO.getCompany().getName());
			System.out.println(userDTO.getCompany().getCatchPhrase());
			System.out.println(userDTO.getCompany().getBs());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
