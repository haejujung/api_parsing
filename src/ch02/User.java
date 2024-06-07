package ch02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//{
//	  "id": 1,
//	  "name": "Leanne Graham",
//	  "username": "Bret",
//	  "email": "Sincere@april.biz",
//	  "address": {
//	    "street": "Kulas Light",
//	    "suite": "Apt. 556",
//	    "city": "Gwenborough",
//	    "zipcode": "92998-3874",
//	    "geo": {
//	      "lat": "-37.3159",
//	      "lng": "81.1496"
//	    }
//	  },
//	  "phone": "1-770-736-8031 x56442",
//	  "website": "hildegard.org",
//	  "company": {
//	    "name": "Romaguera-Crona",
//	    "catchPhrase": "Multi-layered client-server neural-net",
//	    "bs": "harness real-time e-markets"
//	  }
//	}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {

	private int id;
	private String name;
	private String username;
	private String email;
	private Address address;
	private String phone;
	private String website;
	private Company company;

	@Getter
	@Setter
	public class Address {

		private String street;
		private String suite;
		private String city;
		private String zipcode;
		private Geo geo;
		
		
		
	@Override
		public String toString() {
			return "Address [street=" + street + ", suite=" + suite + ", city=" + city + ", zipcode=" + zipcode
					+ ", geo=" + geo + "]";
		}



	@Getter
	@Setter
		public class Geo {
			private String lat;
			private String lng;
			@Override
			public String toString() {
				return "Geo [lat=" + lat + ", lng=" + lng + "]";
			}
			
			
			
		}
	

	}

	@Getter
	@Setter

	public class Company {

		private String name;
		private String catchPhrase;
		private String bs;
		@Override
		public String toString() {
			return "Company [name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + "]";
		}
		
		

	}

}
