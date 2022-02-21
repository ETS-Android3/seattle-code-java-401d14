package garden.plant.fruit;

import garden.plant.Plant;

public class Tomato extends Plant
{
  String type;
  public boolean isIndoor;

  public Tomato(String type, double heightInFeet)
  {
    super(true, true, true, heightInFeet, "Tomato");
    this.type = type;
  }
}
