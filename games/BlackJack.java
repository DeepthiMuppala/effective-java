import java.util.Scanner;

class BlackJack {

  public BlackJack(Deck deck, Dealer dealer, Player player) {
    dealer.initialize(deck);
    player.initialize(deck);
  }

  public static void main(String[] args) {
    InstanceFactory inst = InstanceFactory.getFactoryInstance();
    Deck deck = inst.getDeckInstance((int) Math.random() * 100);
    Dealer dealer = inst.getDealerInstance();
    Player player = inst.getPlayerInstance();
    BlackJack bj = new BlackJack(deck, dealer, player);
    String option;
    do {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter \"H\" to Hit or Any other Key to fold: ");
      option = scanner.next();
      if ((option.equals("H") || option.equals("h"))) {
        player.hit(deck);
      }
    } while ((player.getCurrentCount() < 22) && (option.equals("H") || option.equals("h")));
    if ((player.getCurrentCount() < 22)) {
      dealer.play(deck);
      System.out.println("Dealer Count: " + dealer.getCurrentCount());
      System.out.println("Player Count: " + player.getCurrentCount());
      if (dealer.getCurrentCount() < 22 && player.getCurrentCount() < dealer.getCurrentCount()) {
        System.out.println("Dealer Won!!");
      } else {
        System.out.println("Player Won!!");
      }
    } else {
      System.out.println("Sorry u lost :(");
    }
  }
}
