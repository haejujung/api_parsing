package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyHttpAlbumClient {

	public static void main(String[] args) {

		// 순수 자바코드에서 HTTP 통신
		// 1. 서버주소 경로
		// 2. URL 클래스 필요
		// 3. url.openConnection() <-- 스트림 I/O

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums/1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			// 응답 코드 확인
			// 200 -> 통신성공 , 400, 405 -> 경로 x 500 -> 서버자체 연산이 잘못됨
			int responseCode = conn.getResponseCode();
			System.out.println("response code : " + responseCode);

			// HTTP 응답 메시지에 데이터를 추출 [] -- Stream -- []
			// 바이트 단위 읽는 기반스트림에 보조스트림 연결
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			// 반복문으로 인해 덮어쓰기가 됨
			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);

			}
			in.close();
			System.out.println(buffer.toString());
			System.err.println("----------------------------");

			// gson lib 활용
//			Gson gson = new Gson();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			// albumDTO 로 참조 주소값을 넣어준다.
			Album albumDTO = gson.fromJson(buffer.toString(), Album.class);

			System.out.println(albumDTO.getId());
			System.out.println(albumDTO.getUserId());
			System.out.println(albumDTO.getTitle());

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class
