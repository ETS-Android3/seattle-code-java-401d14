package frenchBakery.pastry;

public class CheeseGalette extends Pastry
{
  public CheeseGalette()
  {
    super("Cheese Galette", false, true, 150, Filling.CHEESE);
  }

  @Override
  public void omNomNom()
  {
    System.out.println("Oui it is a good galetee with fromage");
  }
}
