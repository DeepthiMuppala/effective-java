import java.util.Scanner;

class BlackJack {


  public BlackJack(Deck deck, Dealer dealer, Player player) {
    PlayUtil playUtil1 = new PlayUtil();
    dealer.initialize(deck, playUtil1);

    PlayUtil playUtil2 = new PlayUtil();
    player.initialize(deck, playUtil2);
  }

  public static void main(String[] args) {
    InstanceFactory inst = InstanceFactory.getFactoryInstance();
    Deck deck = inst.getDeckInstance((int) Math.random() * 100);
    Dealer dealer = inst.getDealerInstance();
    Player player = inst.getPlayerInstance();
    BlackJack bj = new BlackJack(deck, dealer, player);
    String option;
    Integer playerCount = 0;
    do {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter \"H\" to Hit or Any other Key to fold: ");
      option = scanner.next();
      if ((option.equals("H") || option.equals("h"))) {
        playerCount = player.hit(deck);
      }
    } while ((playerCount < 22) && (option.equals("H") || option.equals("h")));
    if ((playerCount < 22)) {
      Integer dealerCount = dealer.play(deck);
      if (dealerCount < 22 && playerCount < dealerCount) {
        System.out.println("Dealer Won!!");
      } else {
        System.out.println("Player Won!!");
      }
    } else{
      System.out.println("Sorry u lost :(");
    }
  }
}
