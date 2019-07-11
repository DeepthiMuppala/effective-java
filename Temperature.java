/**
* 
* This class demonstrates creation of objects using
* static static factory methods instead of constructors.
*
*/
class Temperature {
  private double centigrade;

  private Temperature(double temp) {
    this.centigrade = temp;
  }

  public static Temperature fromCentigrade(double centigrade) {
    Temperature t1 = new Temperature(centigrade);
    return t1;
  }

  public static Temperature fromFahrenheit(double fahrenheit) {
    double kelvin = (fahrenheit - 32) * (0.5556);
    Temperature t2 = new Temperature(kelvin);
    return t2;
  }

  public double getCentigrade() {
    return this.centigrade;
  }

  public double getFahrenheit() {
    double f = (this.centigrade * 9 / 5) + 32;
    return f;
  }

}
