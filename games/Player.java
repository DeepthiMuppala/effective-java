import java.util.*;

class Player {

    private Player() {
    }

    public static Player getPlayerInstance() {
        return new Player();
    }

    int aceCount = 0;
    int faceValueCount = 0;
    String[] highCards = { "K", "J", "Q", "A" };
    Set<String> set = new HashSet<>(Arrays.asList(highCards));

    public void initialize(Deck deck) {
        System.out.println("Initializing Player: ");
        Card card1 = deck.randomCard();
        Card card2 = deck.randomCard();
        faceValueCount = handleCount(card1);
        faceValueCount = handleCount(card2);
        System.out.println(card1);
        System.out.println(card2);
    }

    // check the count of cards you have until now.
    // Check if the incoming card is ace if it is ace then special handling with
    // count

    public Integer hit(Deck deck) {
        Card card = deck.randomCard();
        System.out.println(card);
        faceValueCount = handleCount(card);
        Integer count = checkWinLooseCondition();
        return count;
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

    public Integer checkWinLooseCondition() {
        System.out.println("faceValueCount " + faceValueCount);
        if (faceValueCount > 21 && aceCount > 0) {
            faceValueCount -= ((aceCount * 10) + aceCount);
            aceCount = 0;
            return checkWinLooseCondition();
        } else if (faceValueCount > 21) {
            System.out.println("Sorry u Lost :(");
            return faceValueCount;
        }
        return faceValueCount;
    }
}