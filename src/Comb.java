
public enum Comb {

		ROYAL_FLUSH(1),    // ok
		STRAIGHT_FLUSH(2), // ok
		QUADS(3),		   // 4 te same figury
		FULL(4),		   //  para + trójka
		FLUSH(5),		  // ten sam kolor
		STRAIGHT(6),      //12345/23456
		THREE(7),		  // trzy te same figury
		TWO_PAIRS(8),
		PAIR(9),		 // dwie te same figury
		HIGH_CARD(10),
		NOT_YET(0);
		
		int weight;
		
		Comb(int weight){
			this.weight = weight;
		}	
	}

