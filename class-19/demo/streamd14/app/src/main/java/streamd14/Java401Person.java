package streamd14;

public class Java401Person
{
  String firstName;
  int yearsOfExperience;
  String hobby;
  boolean areHotDogsSandwiches;
  boolean isHardWorker;

  public Java401Person(String firstName, int yearsOfExperience, String hobby, boolean areHotDogsSandwiches)
  {
    this.firstName = firstName;
    this.yearsOfExperience = yearsOfExperience;
    this.hobby = hobby;
    this.areHotDogsSandwiches = areHotDogsSandwiches;
    isHardWorker = true;
  }

  @Override
  public String toString()
  {
    return "Java401Person{" +
      "firstName='" + firstName + '\'' +
      ", yearsOfExperience=" + yearsOfExperience +
      '}';
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public int getYearsOfExperience()
  {
    return yearsOfExperience;
  }

  public void setYearsOfExperience(int yearsOfExperience)
  {
    this.yearsOfExperience = yearsOfExperience;
  }

  public String getHobby()
  {
    return hobby;
  }

  public String testString()
  {
    return "test";
  }

  public void setHobby(String hobby)
  {
    this.hobby = hobby;
  }

  public boolean isAreHotDogsSandwiches()
  {
    return areHotDogsSandwiches;
  }

  public void setAreHotDogsSandwiches(boolean areHotDogsSandwiches)
  {
    this.areHotDogsSandwiches = areHotDogsSandwiches;
  }

  public boolean isHardWorker()
  {
    return isHardWorker;
  }

  public void setHardWorker(boolean hardWorker)
  {
    isHardWorker = hardWorker;
  }
}
