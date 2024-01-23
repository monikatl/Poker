
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;


public class Player {
	private String name;
	List<Card> hand;
	
	
	public String getName() {
		return name;
	}
	
	public void setCard(Card card) {
		hand.add(card);
	}


	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<Card>();
	}
	
	
	public void showHand() {
		Collections.sort(this.hand);
		hand.forEach(System.out::print);
		System.out.println();
	}
	
	public Card removeCard(int i) {
		return this.hand.remove(i);
	}
	
	public void addChangedCards(List<Card> cards) {
		this.hand.addAll(cards);
	}


	public List<Card> getHand() {
		return this.hand;
	}
}
