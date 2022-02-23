package moreUnicorns;

public class Unicorn
{
  String color;
  double numOfHorns;
  Power specialPower;

  public Unicorn(String color, double numOfHorns, Power specialPower)
  {
    this.color = color;
    this.numOfHorns = numOfHorns;
    this.specialPower = specialPower;
  }

  @Override
  public String toString()
  {
    return "Unicorn{" +
      "color='" + color + '\'' +
      ", numOfHorns=" + numOfHorns +
      ", specialPower=" + specialPower +
      '}';
  }
}
