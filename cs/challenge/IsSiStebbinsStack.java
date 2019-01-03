/** */

public class IsSiStebbinsStack {
	boolean DEBUG = false;
	int isSiStebbinsStack(String deck) {

		char[] suits = new char[]{'C','H','S','D'};

		int suit = -1;
		int val = -1;

		String[] cards = deck.split(" ");
		switch(cards[0].charAt(cards[0].length() - 1)){
			case 'C': suit = 0; break;
			case 'H': suit = 1; break;
			case 'S': suit = 2; break;
			case 'D': suit = 3; break;
			default: System.out.println("bad suit: " + cards[0]); break;
		}

		try {
			val = Integer.parseInt(cards[0].substring(0,cards[0].length() - 1));
		}
		catch (Exception e){
			char paint = cards[0].charAt(0);
			if(paint == 'J'){
				val = 11;
			}
			else if(paint == 'Q'){
				val = 12;
			}
			else if(paint == 'K'){
				val = 13;
			}
			else if(paint == 'A'){
				val = 1;
			}
			else {
				throw e;
			}
		}
		if(DEBUG) System.out.println("card: " + val + " of " + suits[suit]);

		if(val == -1 || suit == -1 ){
			return -1;
		}

		int i = 1;
		boolean stebbins = true;
		while(stebbins && i < cards.length){

			val += 3;
			if(val > 13) {
				val -= 13;
			}
			suit++;
			if(suit == 4) 
				suit = 0;


			String toMatch = null;
			if(val >= 2 && val <= 10){
				toMatch = (Integer.toString(val) + Character.toString(suits[suit]));
			}
			else {
				switch(val){
					case 1: toMatch = "A"; break;
					case 11: toMatch = "J"; break;
					case 12: toMatch = "Q"; break;
					case 13: toMatch = "K"; break;
					default: break;
				}
				toMatch += Character.toString(suits[suit]);
			}

			if(cards[i].equals(toMatch)){
				i++;    
			}
			else {
				stebbins = false;
			}
		}

		if(stebbins == false){
			return i+1;
		}
		else 
		   return 1;
	}
} // class
