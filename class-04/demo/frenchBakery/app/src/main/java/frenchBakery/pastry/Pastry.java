package frenchBakery.pastry;

public class Pastry
{
  String name;
  boolean isSweet;
  boolean isSavory;
  int calories;
  Filling filling;
  public static final boolean IS_TASTY;

  static
  {
    IS_TASTY = true;
  }

  public Pastry(String _name, boolean isSweet, boolean isSavory, int calories, Filling filling)
  {
    name = _name;
    this.isSweet = isSweet;
    this.isSavory = isSavory;
    this.calories = calories;
    this.filling = filling;
  }

  @Override
  public String toString()
  {
    return "Pastry{" +
      "name='" + name + '\'' +
      ", isSweet=" + isSweet +
      ", isSavory=" + isSavory +
      ", calories=" + calories +
      ", filling=" + filling +
      ", isTasty=" + IS_TASTY +
      '}';
  }

  public static String getBakeryName()
  {
    return "Ed's Bakery";
  }

  public static int addNums(int int1, int int2)
  {
    return int1 + int2;
  }

  public void omNomNom()
  {
    System.out.println("Yum yum it's a pastry");
  }
}
