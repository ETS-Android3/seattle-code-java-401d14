package datastructures.linkedlist;

public class LinkedList<T>
{
  Node<T> head = null;
  Node<T> tail = null;  // not truly required, but can be useful
  int size = 0;

  public void insert(T value)
  {
    if (head == null)
    {
      head = new Node<>(value);
    }
    else
    {
      Node<T> newNode = new Node<>(value);
      newNode.next = head;
      head = newNode;
    }
  }

  public boolean includes(int value)
  {
    return false;  // TODO implement me
  }

  @Override
  public String toString()
  {
    return "null";  // TODO: implement me
  }
}
