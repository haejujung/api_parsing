package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonDog {

	public static void main(String[] args) {

		Dog dog1 = new Dog("로이", 3, "푸숑");
		Dog dog2 = new Dog("초롱", 9, "패니키즈");

		Dog[] dogArr = { dog1, dog2 };

	
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String dog1Str = gson.toJson(dog1);
		System.out.println(dog1Str);

		Gson gson2 = new Gson();
		System.out.println(dog1Str);

		// 배열로 설계할 떄
		// Dog[] transeObject = gson.fromJson(dog1Str, Dog[].class);
		Dog transeObject = gson.fromJson(dog1Str, Dog.class);
		System.out.println(transeObject.getName());

	}

}
