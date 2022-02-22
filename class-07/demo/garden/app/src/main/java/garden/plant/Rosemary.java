package garden.plant;

public class Rosemary extends Plant
{
  Rosemary()
  {
    this(.6, "Rosemary");  // this is the default height
  }

  Rosemary(String species)
  {
    this(.6, species);
  }

  public Rosemary(double height)
  {
    this(height, "Rosemary");
  }

  Rosemary(double height, String species)
  {
    super(true, true, true, height, species);
  }

  public void test()
  {
  }

  @Override
  public String description()
  {
    return "My species is rosemary, not my name";
  }
}
