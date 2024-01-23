import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	List<Card> deck;
	
	public Deck() {
		 deck = new ArrayList<Card>(24);
		 
		 for(Card.Suit suit : Card.Suit.values()) {
			 for(Card.Figure figure : Card.Figure.values()) {
				 addCardToDeck(suit, figure);
			 }
		 } 
	}
	
	private void addCardToDeck(Card.Suit suit, Card.Figure figure) {
		this.deck.add(new Card(suit, figure));
	}
	
	public void showDeck() {
		deck.forEach(System.out::print);
		System.out.println();
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public List<Card> getCardsFromDeck(int i) {	
		if(i>5) 
			throw new IllegalArgumentException();
		else
			return deck.subList(0, i);
	}
	
}
