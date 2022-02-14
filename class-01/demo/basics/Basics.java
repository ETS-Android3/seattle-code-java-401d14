import java.util.Arrays;
import java.util.Random;

public class Basics
{
  public static void main(String[] args)
  {
    int myInt = 2;
    myInt = Integer.MAX_VALUE;
    int myInt2 = Integer.MAX_VALUE;
    System.out.println(myInt);
    long myLong = Long.MAX_VALUE;
    System.out.println(myLong);
    float myFloat = 2.3f;
    double myDouble = 2.0;
    System.out.println(myFloat);

    boolean areMyIntsEqual = (myInt == myInt2);
    System.out.println("areIntsEqual: " + areMyIntsEqual);

    float float1 = 0.1f;
    float float2 = 0.2f;
    float float3 = float1 + float2;

    System.out.println("float1: " + float1);
    System.out.println("float2: " + float2);
    System.out.println("float3: " + float3);

    double double1 = 0.1 + myInt;
    double double2 = 0.2;
    double double3 = double1 + double2;
    boolean areDoublesEqual = (double3 > 0.299999 && double3 < 0.3000001);

    System.out.println("double1: " + double1);
    System.out.println("double2: " + double2);
    System.out.println("double3: " + double3);
    System.out.println("areDoublesEqual: " + areDoublesEqual);

    byte myByte = (byte)0x8F;
    short myShort = (short)0x0A5B;

    char myChar = 'e';
    char myChar2 = 'd';

    System.out.println("myChar + myChar2: " + myChar + myChar2);

    String myString = "2";
    int twoInt = Integer.parseInt(myString);
    String myString2 = "Younskevicius";

    System.out.println(myString + " " + myString2);

    boolean areMyStringsEqual = (myString.equals(myString2));  // DON'T use == with Strings! Or any other object
    System.out.println("areMyStringsEqual: " + areMyStringsEqual);

    String hello = "hello";
    String hel = "hel";
    String lo = "lo";
    System.out.println("\"hello\" == \"hel\" + \"lo\": " + ("hello" == ("hel" + "lo")));
    System.out.println("\"hello\" == hel + lo: " + ("hello" == (hel + lo)));  // false!
    System.out.println("hello == \"hel\" + \"lo\": " + (hello == ("hel" + "lo")));
    System.out.println("hello == hel + lo: " + (hello == (hel + lo)));  // false!
    System.out.println("\"hello\".equals(\"hel\" + \"lo\"): " + ("hello".equals("hel" + "lo")));
    System.out.println("\"hello\".equals(hel + lo): " + ("hello".equals(hel + lo)));
    System.out.println("hello.equals(\"hel\" + \"lo\"): " + (hello.equals("hel" + "lo")));
    System.out.println("hello.equals(hel + lo): " + (hello.equals(hel + lo)));

    int[] myIntArray = new int[10];  // empty array with ten elements
    int[] myIntArray2 = {1, 2, 3};

    long[] myLongArray = {3, 4, 5};

    System.out.println("myIntArray2: " + myIntArray2); // yuck! memory address
    System.out.println("myIntArray2 (actually): " + Arrays.toString(myIntArray2));

    for(int i = 0; i < myLongArray.length; i++)
    {
      System.out.println("myLongArray[i]: " + myLongArray[i]);
      if (i < 2)
        continue;
      System.out.println("test");
    }

    for (long aLong : myLongArray)
    {
      System.out.println("myLongArray[i] 2: " + aLong);
    }

    int j = 0;
    while (j < myLongArray.length)
    {
      System.out.println("myLongArray[j]: " + myLongArray[j]);
      j++;
    }

    int returnInt = testFunc(10);
    System.out.println("returnInt: " + returnInt);
    System.out.println("testFunc return is: " + testFunc(10));

    Random myRandom = new Random();
    float myRandNum = myRandom.nextFloat();
  }

  // Function syntax basically is (for now): "public static TYPE_OF_RETURN NAME_OF_FUNCTION(ARGUMENTS)"
  public static int testFunc(int testInt)
  {
    System.out.println("My integer is: " + testInt);
    return testInt + 1;
  }
}
