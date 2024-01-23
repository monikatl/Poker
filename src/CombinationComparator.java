import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationComparator {
	
	private final static int MAX = 4;
	private final static int MIN = 0;
	
	
	public static int compareHigh_Card(List<Card> f, List<Card> s) {
		return f.get(MAX).compareTo(s.get(MAX));
	}
	
	
	public static int compareNumberCombinations(List<Card> f, List<Card> s, int type) {
		int w1 = extractCombinationWeight(f, type);
		int w2 = extractCombinationWeight(s, type);
		if(w1==w2) {
			return compareHigh_Card(f,s);
		}
		return Integer.compare(w1, w2);
	}
	
	public static int compareTwoPairs(List<Card> f, List<Card> s) {
		return 0;
		
	}
	
	private static int extractCombinationWeight(List<Card> f, int type){
		Set<Map.Entry<Card.Figure, List<Card>>> entries = f.stream().collect(Collectors.groupingBy(Card::getFigure)).entrySet();
		int combination = entries.stream().filter(x->x.getValue().size()==type).toList().get(MIN).getKey().getWeight();
		return combination;
	}

	public static int compareStraights(List<Card> f, List<Card> s) {
		int first = weightOfStraight(f);
		int second = weightOfStraight(s);
		return Integer.compare(first, second);
	}
	
	private static int weightOfStraight(List<Card> f) {
		List<Integer> weightsFlowF = f.stream().map(card->card.getFigure().getWeight()).toList();
		if(weightsFlowF.equals(Arrays.asList(Combination.WEIGHTS).subList(0, 5))) {
			return 0;
		}else {
			return 1;
		}
	}

	
}
