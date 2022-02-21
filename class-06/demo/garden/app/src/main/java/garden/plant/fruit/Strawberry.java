package garden.plant.fruit;

import garden.plant.Plant;

public class Strawberry extends Plant
{
  public Strawberry(double height)
  {
    super(true, true, true, height, "Strawberry");
  }

  @Override
  public String description()
  {
    return "I'm red and sweet and the best fruit ever";
  }

  public String makeSweetPie()
  {
    return "Yum, I make a sweet strawberry pie!";
  }
}
