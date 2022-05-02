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

   public T getFront()
     {
        if (isEmpty())
           throw new IllegalStateException();
        else
           return firstNode.getData();
     }
  
  public boolean isEmpty()
   {
      return (firstNode == null) && (lastNode == null);
   } // end isEmpty

  public void clear()
     {
        firstNode = null;
        lastNode = null;
     } // end clear

  public QueueInterface<T> getBreadthFirstTraversal(T origin)
    {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<T>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<VertexInterface<T>>();
        
        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexQueue.enqueue(originVertex);
        
        while (!vertexQueue.isEmpty())
        {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
            
            while (neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited())
                {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                }
            }
        }
        return traversalOrder;
    }

  public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        //Assumes graph is not empty
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<T>();
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();
        
        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexStack.push(originVertex);
        
        while (!vertexStack.isEmpty())
        {
            VertexInterface<T> topVertex = vertexStack.peek();
            VertexInterface<T> nextNeighbor = topVertex.getUnVisitedNeighbor();
            
            if (nextNeighbor != null)
            {
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexStack.push(nextNeighbor);
            }
            else //All neighbors are visited
                vertexStack.pop();
        }
        
        return traversalOrder;
    }
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
