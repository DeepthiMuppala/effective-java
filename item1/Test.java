class Test {
  public static void main(String[] args) {
    double tempC = 38.9;
    double tempF = 42.8;

    Temperature t1 = Temperature.fromCentigrade(tempC);
    Temperature t2 = Temperature.fromFahrenheit(tempF);

    System.out.println("TempC in Fahrenheit is " + t1.getFahrenheit());
    System.out.println("TempF in Centigrade is " + t2.getCentigrade());
  }
}
