import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Combination implements Comparable<Combination>{
	
	final static Integer[] WEIGHTS = {1,2,3,4,5,6};
	
	private Comb comb;
	private List<Card> cards;
	
	public List<Card> getCards() {
		return cards;
	}

	public Comb getComb() {
		return comb;
	}

	public Combination(List<Card> hand) {
		this.cards = hand;
	}
	
	private void isFlushStritRoyalFlushStritFlush() {
		flush();
		if(this.comb.equals(Comb.FLUSH)) {
			straight();
			if(this.comb.equals(Comb.STRAIGHT)) {
				System.out.println(this.comb);
				if(cards.get(cards.size()-1).getFigure().equals(Card.Figure.AS)) {
					System.out.println(cards.get(cards.size()-1).getFigure());
					this.comb = Comb.ROYAL_FLUSH;
				}				
				else {
					this.comb = Comb.STRAIGHT_FLUSH;
				}
							
			}else {
				this.comb = Comb.FLUSH;
			}
		}else {
			this.comb = Comb.NOT_YET;
		}
	}
	
	
	private void flush() {
		Card.Suit suit = cards.get(0).getSuit();
		long count = this.cards.stream().filter(card -> card.getSuit().equals(suit)).count();
		if(count==5)
			this.comb = Comb.FLUSH;
		else
			this.comb = Comb.NOT_YET;
	}
	
	private void straight() {
		List<Integer> weightsFlow = this.cards.stream().map(card->card.getFigure().getWeight()).toList();
		boolean a = weightsFlow.equals(Arrays.asList(WEIGHTS).subList(0, 5));
		boolean b = weightsFlow.equals(Arrays.asList(WEIGHTS).subList(1, 6));
 		if(a||b)
 			this.comb = Comb.STRAIGHT;
 		else
 			this.comb = Comb.NOT_YET;
	}
	
	private void quads() {
		Set<Map.Entry<Card.Figure, List<Card>>> entries = this.cards.stream()
				.collect(Collectors.groupingBy(Card::getFigure)).entrySet();
		
		long isQuad = entries.stream().filter(x -> x.getValue().size()==4).count(); //0 nie jest 1 jest
		long isThree = entries.stream().filter(x -> x.getValue().size()==3).count(); //0 nie jest 1 jest - sprawdzić czy nie ma jeszcze dwójki
		long isTwo = entries.stream().filter(x -> x.getValue().size()==2).count(); //0 nie ma 1 sprawdzic czy nie ma trójki 2 dwójki 2
 
		if(isQuad==1) 
			this.comb = Comb.QUADS;

		if(isThree==1) {
			if(isTwo==1) this.comb = Comb.FULL;
			else this.comb = Comb.THREE;			
		}
		
		if(isTwo==2) {
			this.comb = Comb.TWO_PAIRS;
		}
		
		if(isTwo==1) {
			this.comb = Comb.PAIR;
			if(isThree==1) this.comb = Comb.FULL;
		}	
	}
	
	public void checkCombination() {
		isFlushStritRoyalFlushStritFlush();
		if(this.comb.equals(Comb.NOT_YET)) {
			straight();
			if(this.comb.equals(Comb.NOT_YET))
				quads();
		}
		if(this.comb.equals(Comb.NOT_YET)) {
			this.comb = Comb.HIGH_CARD;
		}
	}

	@Override
	public int compareTo(Combination o) {
		if(this.comb.equals(o.comb)) {
			switch(o.comb) {
				case QUADS: 
					return CombinationComparator.compareNumberCombinations(this.cards, o.cards,  4);
				case FULL:
					return CombinationComparator.compareNumberCombinations(o.cards, this.cards, 3);
				case FLUSH:
					return CombinationComparator.compareHigh_Card(o.cards, this.cards);
				case STRAIGHT:
					return CombinationComparator.compareStraights(o.cards, this.cards);
				case THREE:
					return CombinationComparator.compareNumberCombinations(this.cards, o.cards,  3);
				case TWO_PAIRS:
					return 0;
				case PAIR:
					return CombinationComparator.compareNumberCombinations(this.cards, o.cards,  2);
				case HIGH_CARD:
					return CombinationComparator.compareHigh_Card(o.cards, this.cards);
				default:
					break;
			}
			return 0;
		}else {
			return Integer.compare(o.comb.weight, this.comb.weight);
		}
		
	}

	public static Combination createCombination(List<Card> hand) {
		return new Combination(hand);
	}
	


}
