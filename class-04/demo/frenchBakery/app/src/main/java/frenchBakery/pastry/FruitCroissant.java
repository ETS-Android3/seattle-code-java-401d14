package frenchBakery.pastry;

public class FruitCroissant extends Pastry
{
  public FruitCroissant()
  {
    super("Fruit Croissant", true, false, 144, Filling.FRUIT);
  }

  public FruitCroissant(String _name, boolean isSweet, boolean isSavory, int calories, Filling filling)
  {
    super(_name, isSweet, isSavory, calories, filling);
  }

  @Override
  public String toString()
  {
    return super.toString() + "\n and some extra stuff";
  }

  public static String getBakeryName()
  {
    return "JB's Bakery";
  }

  @Override
  public void omNomNom()
  {
    System.out.println("Yum oh God flakes everywhere");
  }
}
