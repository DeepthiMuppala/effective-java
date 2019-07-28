import java.util.*;

class Dealer {
    private Dealer() {
    }

    int aceCount = 0;
    int faceValueCount = 0;
    String[] highCards = { "K", "J", "Q", "A" };
    Set<String> set = new HashSet<>(Arrays.asList(highCards));
    Card card1;

    public static Dealer getDealerInstance() {
        return new Dealer();
    }

    public void initialize(Deck deck) {
        System.out.println("Initializing Dealer: ");
        card1 = deck.randomCard();
        Card card2 = deck.randomCard();
        faceValueCount = handleCount(card1);
        faceValueCount = handleCount(card2);
        System.out.println(card2);
    }

    public Integer handleCount(Card card) {
        int value;
        if (set.contains(card.getFaceValue())) {
            if (card.getFaceValue().equals("A")) {
                aceCount++;
            }
            faceValueCount += 10;
        } else {
            value = Integer.parseInt(card.getFaceValue());
            faceValueCount += value;
        }
        return faceValueCount;
    }

    public Integer play(Deck deck) {
        System.out.println("Card 1: " + card1);
        while (faceValueCount < 18) {
            Card card = deck.randomCard();
            System.out.println(card);
            faceValueCount = handleCount(card);
        }
        return faceValueCount;
    }

    public Integer checkWinLooseCondition() {
        System.out.println("faceValueCount " + faceValueCount);
        if (faceValueCount > 21 && aceCount > 0) {
            faceValueCount -= ((aceCount * 10) + aceCount);
            aceCount = 0;
            return checkWinLooseCondition();
        } else if (faceValueCount > 21) {
            return faceValueCount;
        }
        return faceValueCount;
    }

}