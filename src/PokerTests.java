import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class PokerTests extends TestCase {
	@Test
	public void royalFlush() {
		List<Card> royalFlush = new ArrayList<>();
		royalFlush.add( new Card (Card.Suit.HEART, Card.Figure.TEN));
		royalFlush.add( new Card (Card.Suit.HEART, Card.Figure.JACK));
		royalFlush.add( new Card (Card.Suit.HEART, Card.Figure.QUEEN));
		royalFlush.add( new Card (Card.Suit.HEART, Card.Figure.KING));
		royalFlush.add( new Card (Card.Suit.HEART, Card.Figure.AS));
		
		assertEquals(royalFlush, Comb.ROYAL_FLUSH);
	}
	
}
