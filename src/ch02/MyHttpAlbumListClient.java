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

// 

public class MyHttpAlbumListClient {

	public static void main(String[] args) {

		try {
			// 경로 변경
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			int responseCode = conn.getResponseCode();
			System.out.println("response code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);

			}
			in.close();
			System.out.println(buffer.toString());
			System.err.println("----------------------------");

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			// 하나의 JSON Object 형태 파싱
//			Album albumDTO = gson.fromJson(buffer.toString(), Album.class);

			// [{...},{...},{...}]
			// Gson 제공하는 Type 이라는 데이터 타입을 활용할 수 있다.

			// Json 배열 형태를 쉽게 파싱하는 방법 -> TypeToken 안에 List<T> 을 활용한다.
			Type albumType = new TypeToken<List<Album>>() {}.getType();
			List<Album> albumList = gson.fromJson(buffer.toString(), albumType);
			System.out.println(albumList.size());
			// 이니셜라이즈 for 공부
			for (Album a : albumList) {
				System.out.println(a.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class
