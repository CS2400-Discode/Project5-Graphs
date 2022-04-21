public class LinkedQueue<T> implements QueueInterface<T>
{
  private Node firstNode;
  private Node lastNode;
  
  public LinkedQueue()
  {
    firstNode = null;
    lastNode = null;
  }
}
