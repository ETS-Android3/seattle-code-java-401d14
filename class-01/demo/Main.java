import java.util.Arrays;

public class Main
{
  public static void main(String args[])
  {
    int int1 = 5;
    long long1 = 100;
    byte byte1 = (byte)0xFF;
    short short1 = (short)0xFFFF;
    boolean boolean1 = true;

    int maxInt = Integer.MAX_VALUE;
    System.out.println("Maximum integer is: " + maxInt);
    int minInt = Integer.MIN_VALUE;
    System.out.println("Mininum integer is: " + minInt);

    float float1 = 0.1f;
    float float2 = 0.2f;
    float float3 = float1 + float2;
    boolean booleanFloat = (float3 == 0.3f);  // true
    System.out.println("booleanFloat: " + booleanFloat);
    System.out.println("float3: " + float3);

    double double1 = 0.1;
    double double2 = 0.2;
    double double3 = double1 + double2;
    boolean booleanDouble = (double3 == 0.3);  // false!
    System.out.println("booleanDouble: " + booleanDouble);
    System.out.println("double3: " + double3);

    char char1 = 'a';
    char char2 = 'b';
    System.out.println("char1: " + char1);
    System.out.println(char1 + char2);

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

    int int2 = 20;
    String numberString1 = "30";
    System.out.println("int2 + numberString1: " + (int2 + numberString1));  // 2030
    System.out.println("int2 + Integer.fromString(numberString1): " + (int2 + Integer.valueOf(numberString1)));  // 50

    int counter = 0;
    while (counter < 5)
    {
        System.out.println("counter: " + counter);
        counter++;
        if (counter > 2)
        {
          break;
        }
    }

    int[] intArray1 = {3, 2, 5};

    for(int i = 0; i < intArray1.length; i++)
    {
        System.out.println("intArray[" + i + "]: " + intArray1[i]);
        
        //if (i >= 1)
        //{
        //  break;
        //}
    }

    for(int currentInt : intArray1)
    {
        System.out.println("currentInt: " + currentInt);
    }

    System.out.println("intArray: " + intArray1);
    System.out.println("intArray: " + Arrays.toString(intArray1));

    int newInt = 5;
    newInt = returnInt(3);
    System.out.println("newInt: " + newInt);
  }

  // public static TYPEOFRETURN NAMEOFFUNCTION(ARGUMENTS) {}
  public static int returnInt(int intArg)
  {
      return intArg;
  }
}