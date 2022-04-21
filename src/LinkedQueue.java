public class LinkedQueue<T> implements QueueInterface<T>
{
  private Node firstNode;
  private Node lastNode;
  
  public LinkedQueue()
  {
    firstNode = null;
    lastNode = null;
  }
  
  public void enqueue(T newEntry)
  {
    Node newNode = new Node(newEntry, null);
    
    if (isEmpty())
      firstNode = newNode;
    else
      lastNode.setNextNode(newNode);
      
    lastNode = newNode;
  }
  
  public T dequeue()
   {
        T front = getFront();  // Might throw EmptyQueueException
                               // Assertion: firstNode != null
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null)
           lastNode = null;

        return front;
  } // end dequeue

  
  
  /***
     * Creates nodes that can be used in other classes
     */
    private class Node
    {
        private T data;
        private Node next;

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        private void setData(T newData)
        {
            data = newData;
        }

        private T getData()
        {
            return data;
        }

        private Node getNextNode()
        {
            return next;
        }

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        }
    }
}
