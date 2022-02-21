package garden.plant;

public class Plant
{
  // Let's use all the access modifiers from least restrictive to most restrictive
  public boolean hasRoots;
  protected boolean isIndoor;
  boolean isOutdoor;  // "package-protected"
  private double heightInFeet;
  public String species;

  public Plant(boolean hasRoots, boolean isIndoor, boolean isOutdoor, double heightInFeet, String species)
  {
    this.hasRoots = hasRoots;
    this.isIndoor = isIndoor;
    this.isOutdoor = isOutdoor;
    this.heightInFeet = heightInFeet;
    this.species = species;
  }

  public String description()
  {
    return "I'm a plant";
  }

  public boolean isHasRoots()
  {
    return hasRoots;
  }

  public void setHasRoots(boolean hasRoots)
  {
    this.hasRoots = hasRoots;
  }

  /*public boolean isIndoor()
  {
    return isIndoor;
  }*/

  public void setIndoor(boolean indoor)
  {
    isIndoor = indoor;
  }

  /*public boolean isOutdoor()
  {
    return isOutdoor;
  }*/

  public void setOutdoor(boolean outdoor)
  {
    isOutdoor = outdoor;
  }

  public double getHeightInFeet()
  {
    return heightInFeet;
  }

  public void setHeightInFeet(double heightInFeet)
  {
    this.heightInFeet = heightInFeet;
  }

  public void setHeightInInches(double heightInInches)
  {
    this.heightInFeet = heightInInches * 12;
  }

  public String getSpecies()
  {
    return species;
  }

  public void setSpecies(String species)
  {
    this.species = species;
  }
}
