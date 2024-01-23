

public class Card implements Comparable<Card>{
	private Suit suit;
	private Figure figure;
	
	public static enum Suit{
		SPADE("Pik"), HEART("Karo"), CLUB("Trefl"), DIAMOND("Kier");
		
		String sign;
		
		Suit(String sign){
			this.sign = sign;
		}
	}
	
	public static enum Figure {
		NINE("9", 1), TEN("10", 2) , JACK("J", 3), QUEEN("Q", 4), KING("K", 5), AS("A", 6);
		
		private String sign;
		private int weight;
		
		Figure(String sign, int weight){
			this.sign = sign;
			this.weight = weight;
		}
		
		public int getWeight() {
			return this.weight;
		}

	}

	public Card(Card.Suit suit, Card.Figure figure) {
		this.suit = suit;
		this.figure = figure;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}
	
	public int getFigureWeight() {
		return this.figure.getWeight();
	}
	
	
	
	@Override
	public String toString() {
		return this.figure.sign + "(" + this.suit.sign + ") ";
	}

	@Override
	public int compareTo(Card o) {
		return Integer.compare(this.getFigureWeight(), o.getFigureWeight());
	}
}
