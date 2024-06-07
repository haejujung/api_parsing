package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class MyHttpUserListClient {

	public static void main(String[] args) {

		// 순수 자바코드에서 HTTP 통신
		// 1. 서버주소 경로
		// 2. URL 클래스 필요
		// 3. url.openConnection() <-- 스트림 I/O

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("content-type", "application/json");

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);

			}
			in.close();
			System.out.println(buffer.toString());
			System.out.println("---------------");

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Type userType = new TypeToken<List<User>>() {}.getType();
			List<User> userList = gson.fromJson(buffer.toString(), userType);
			System.out.println(userList.size());

			for (User a : userList) {
				System.out.println(a.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
