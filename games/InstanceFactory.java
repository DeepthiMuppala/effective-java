class InstanceFactory{

  private InstanceFactory(){}

  public static InstanceFactory getFactoryInstance(){
    return new InstanceFactory();   
  }

  public static Player getPlayerInstance(){
    return Player.getPlayerInstance();
  }

  public static Dealer getDealerInstance(){
    return Dealer.getDealerInstance();
  }

  public static Deck getDeckInstance(int num){
    return Deck.getDeckInstance(num);
  }

  public Card getCardInstance(String type, Card.Symbol symbol){
    return new Card(type, symbol); 
  }
}