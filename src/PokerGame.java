public class PokerGame {
	

	public static void main(String[] args) {

		Play game = new Play("Monika", "Jakub");
// aby użyć wartości na sztywno należy zmienić true na false w metodzie play obiektu game
			
//		game.player1.setCard(new Card(Card.Suit.SPADE, Card.Figure.KING));
//		game.player1.setCard(new Card(Card.Suit.HEART, Card.Figure.NINE));
//		game.player1.setCard(new Card(Card.Suit.SPADE, Card.Figure.QUEEN));
//		game.player1.setCard(new Card(Card.Suit.SPADE, Card.Figure.AS));
//		game.player1.setCard(new Card(Card.Suit.SPADE, Card.Figure.TEN));
//	
//		game.player2.setCard(new Card(Card.Suit.HEART, Card.Figure.KING));
//		game.player2.setCard(new Card(Card.Suit.HEART, Card.Figure.TEN));
//		game.player2.setCard(new Card(Card.Suit.DIAMOND, Card.Figure.QUEEN));
//		game.player2.setCard(new Card(Card.Suit.HEART, Card.Figure.NINE));
//		game.player2.setCard(new Card(Card.Suit.HEART, Card.Figure.JACK));

		game.play(true);

		
	}
	

	
	
	
	


}
