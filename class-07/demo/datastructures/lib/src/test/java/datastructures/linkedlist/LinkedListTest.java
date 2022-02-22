package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest
{
  @Test void testAMethod()
    {
      LinkedList<Integer> sut = new LinkedList<>();
      System.out.println(sut);
      sut.insert(3);
      sut.insert(2);
      LinkedList<String> sut2 = new LinkedList<>();
      sut2.insert("4");
      assertTrue(true);
    }
}
