package moreUnicorns;

public class Power
{
  String name;
  String description;

  public Power(String name, String description)
  {
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString()
  {
    return "Power{" +
      "name='" + name + '\'' +
      ", description='" + description + '\'' +
      '}';
  }
}
