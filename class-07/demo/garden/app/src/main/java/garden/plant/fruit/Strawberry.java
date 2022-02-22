package garden.plant.fruit;

import garden.plant.Kelp;
import garden.plant.Plant;
import garden.plant.Prunable;
import garden.plant.Waterable;

public class Strawberry extends Plant implements Waterable, Prunable
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


  @Override
  public void water()
  {
    System.out.println("Glug glug");
  }

  @Override
  public boolean prune()
  {
    boolean wasPruned = false;

    if (heightInFeet > 1)
    {
      heightInFeet = heightInFeet - .5;
      wasPruned = true;
    }

    return wasPruned;
  }
}
