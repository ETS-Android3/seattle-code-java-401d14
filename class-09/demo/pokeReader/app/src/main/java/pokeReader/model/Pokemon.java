package pokeReader.model;

import java.util.Arrays;

public class Pokemon
{
  AbilityDescription[] abilities;
  int base_experience;

  @Override
  public String toString()
  {
    return "Pokemon{" +
      "abilities=" + Arrays.toString(abilities) +
      ", base_experience=" + base_experience +
      '}';
  }
}
