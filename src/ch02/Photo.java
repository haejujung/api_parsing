package ch02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//{
//	  "albumId": 1,
//	  "id": 1,
//	  "title": "accusamus beatae ad facilis cum similique qui sunt",
//	  "url": "https://via.placeholder.com/600/92c952",
//	  "thumbnailUrl": "https://via.placeholder.com/150/92c952"
//	}
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Photo {

	private int albumId;
	private int id;
	private String title;
	private String thumbnailUrl;

}
