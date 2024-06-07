package ch02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* 
 * {
	"userId": 1,
	"id": 1,
	"title": "quidem molestiae enim"
	}
*/

// DTO -- 데이터 트랜스터 오브젝트 
// private --> Gson lib 가 변수에 접근해서 json 값을 넣어 준다.
// 그래서 setter 가 필요하다.

@Setter
@Getter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor //
@ToString

public class Album {

	private int userId;
	private int id;
	private String title;

}
