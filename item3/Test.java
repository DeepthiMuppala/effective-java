class Test {
  public String getClassName() {
    return this.getClass().getSimpleName();
  }

  public static void main(String[] args){
        Test t = new Test();
        String className = t.getClassName();
       Logger logger = Logger.getInstance();
       logger.log(className, Logger.LogLevel.ERROR, new String("I am dumb"));
    }
}
