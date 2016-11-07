import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards; // 宣告變數cards-->型態:Card型態的ArrayList
	private ArrayList<Card> usedCard;
	public int nUsed = 0;
	//public int nDeck;
	public Random rnd = new Random();

	// implement the constructor
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();

		Card.Suit n = Card.Suit.Club;
		for (int i = 0; i < nDeck; i++) {
			for (Card.Suit s : Card.Suit.values()) {
				for (int k = 1; k <= 13; k++) {

					Card newCard = new Card(s, k);
					cards.add(newCard);
				}
			}
		}
	shuffle();
	}


	public void printDeck(int nDeck) {

		for (Card c : cards) {
			c.printCard();
		}
	}

	public Card getOneCard() {
		//Card getCard;
		//getCard = cards.get(nUsed);
		nUsed++;
		usedCard.add(cards.get(nUsed-1));
		if (nUsed == 52) {
			shuffle();
		}
		return cards.get(nUsed);
	}

	public void shuffle() {
		nUsed = 0;
		usedCard = new ArrayList<Card> ();
		for (int i = 0; i < 52; i++) {
			int index = rnd.nextInt(52);//between 0 (inclusive) and the specified value (exclusive
			Card temp = cards.get(index);
			cards.set(index, cards.get(i));
			cards.set(i, temp);
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}