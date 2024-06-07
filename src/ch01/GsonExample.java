package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExample {

	public static void main(String[] args) {

		//
		Student student1 = new Student("고길동", 40, "애완학과");
		Student student2 = new Student("둘리", 5, "문제학과");

		//
		Student[] studentArr = { student1, student2 };

		// --> 특정 형식 (구조화) 있는 문자열로 변환 하고 싶다.. --> JSON 형태

		// Builder 패턴에 사용하는 create 메서드
		// Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// 객체를 --> json 형식에 문자열로 변환 시켜! --> 메서드 toJson()
		String student1Str = gson.toJson(student1);
		System.out.println(student1Str);
		
		// setPrettyPrinting -> 이쁘게 출력하라 옵션..
		Gson gson2 = new Gson();
		Student student3 = new Student("고죠",22,"범부학과");
		String student3Str = gson2.toJson(student3);
		System.out.println(student3Str);

		// 객체에서 --> 문자열 형태로 파싱하는 방법 가능 그럼 반대로는??
		// 문자열에서 --> 클래스 형태로 어떻게 변경할까?
		
		
		// .class 라는 객체를 명시해줘야한다.
		
		Student studentObject = gson.fromJson(student3Str, Student.class);
		System.out.println(studentObject.getName());
		
	}

}
