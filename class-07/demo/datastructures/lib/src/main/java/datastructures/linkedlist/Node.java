package datastructures.linkedlist;

public class Node<T>
{
  public T value;
  public Node<T> next = null;

  Node(T value)
  {
    this.value = value;
  }
}
