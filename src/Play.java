import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Play {
	
	private static final int HAND = 5;
	private static final Scanner input = new Scanner(System.in);
	
	Deck deck;
	Combination p1;
	Combination p2;
	Player player1;
	Player player2;

	public Play(String n1, String n2) {
		this.player1 = new Player(n1);
		this.player2 = new Player(n2);
		deck = new Deck();
	}
	
	public void play(boolean randomCards) {
		
		System.out.println("Talia: ");
		deck.showDeck();
		
		deck.shuffleDeck();
		System.out.println("Po tasowaniu: ");
		deck.showDeck();

		if(randomCards) {
			dealCards();
		}else{
			getCardsFromDeck();
		}
		
		System.out.println("Karty gracza " + player1.getName() + ": ");
		player1.showHand();
		
		System.out.println("Karty gracza " + player2.getName() + ": ");
		player2.showHand();
		
		System.out.println("Pozostało w talii: " + deck.deck.size() + " kart: ");
		deck.showDeck();
		
		playerMove(deck, this.player1);
		playerMove(deck, this.player2);

		p1 = Combination.createCombination(player1.getHand());
		p2 = Combination.createCombination(player2.getHand());
		p1.checkCombination();
		p2.checkCombination();

		System.out.println("Kombinacja Gracza " + player1.getName() + " " + p1.getComb());
		System.out.println("Kombinacja Gracza " + player2.getName() + " " + p2.getComb());
		
		int compare = p1.compareTo(p2);
				
		if(compare==0) {
			System.out.println("Remis...");
		}else if(compare>0){
			System.out.print("WYGRYWA GRACZ: " + player1.getName());
		}else {
			System.out.print("WYGRYWA GRACZ: " + player2.getName());
		}		
	}
	
	private static void getCards(Deck deck, Player player, int size) {
		List<Card> list = deck.getCardsFromDeck(size);
		player.addChangedCards(list);
		list.clear();
		player.showHand();
	}
	
	private static void playerMove(Deck deck, Player player) {
		while(true) {
			try{
				System.out.println("Ruch gracza "+ player.getName() + ": ");
				changeCards(deck, player);
				break;
			}catch(InputMismatchException e) {
				System.out.println("Wprowadz prawidlowa liczbe od 1 do 5");
				input.next();
				continue;
			}
			
		}
	}
	
	private static void changeCards(Deck deck, Player player) throws InputMismatchException  {
		System.out.print("Podaj liczbe kart do wymiany: ");
		int num = input.nextInt();
		System.out.println("Wskaz karty do wymiany od lewej: ");
		int [] index = new int [num];
		
		for(int i = 0; i<num; i++) 
			index[i] = input.nextInt()-1;

		Arrays.sort(index);
		for(int i = num-1; i>=0; i--) {	
			player.removeCard(index[i]);	
		}
		
		System.out.println("Pozostale karty gracza " + player.getName());
		player.showHand();
		System.out.println("Po dobraniu kart przez gracza " + player.getName());
		getCards(deck, player, num);
	}
	
	
	private void dealCards() {
		Iterator<Card> iterator = deck.deck.iterator(); 
		int i = 1;
		while(iterator.hasNext()&&i<=HAND) {
			Card p1 = iterator.next();
			iterator.remove();
			Card p2 = iterator.next();
			iterator.remove();
			this.player1.hand.add(p1);
			this.player2.hand.add(p2);
			i++;
		}	
	}
	
	private void getCardsFromDeck() {
		deck.deck.removeAll(player1.getHand());
		deck.deck.removeAll(player2.getHand());
	}
	
		

	
}
