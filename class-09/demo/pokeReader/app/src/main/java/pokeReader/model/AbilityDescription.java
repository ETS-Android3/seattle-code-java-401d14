package pokeReader.model;

public class AbilityDescription
{
  Ability ability;
  boolean is_hidden;
  int slot;

  @Override
  public String toString()
  {
    return "Ability{" +
      "ability=" + ability +
      ", is_hidden=" + is_hidden +
      ", slot=" + slot +
      '}';
  }
}
