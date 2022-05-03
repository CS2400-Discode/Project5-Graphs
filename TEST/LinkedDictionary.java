package ADTPackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 A class that implements the ADT dictionary by using a chain of linked nodes.
 The dictionary is sorted and has distinct search keys.
 Search keys and associated values are not null.

 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.0
 */
public class LinkedDictionary<K extends Comparable<? super K>, V>
        implements DictionaryInterface<K, V>
{
    private Node firstNode; // Reference to first node of chain
    private int  numberOfEntries;

    public LinkedDictionary() {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor

    public V add(K key, V value)
    {
        V result = null;
        if ((key == null) || (value == null))
            throw new IllegalArgumentException("Cannot add null to a dictionary.");
        else
        {
            // Search chain until you either find a node containing key
            // or locate where it should be
            Node currentNode = firstNode;
            Node nodeBefore = null;

            while ( (currentNode != null) && (key.compareTo(currentNode.getKey()) > 0) )
            {
                nodeBefore = currentNode;
                currentNode = currentNode.getNextNode();
            } // end while

            if ( (currentNode != null) && key.equals(currentNode.getKey()) )
            {
                // Key in dictionary; replace corresponding value
                result = currentNode.getValue(); // Get old value
                currentNode.setValue(value);     // Replace value
            }
            else // Key not in dictionary; add new node in proper order
            {
                // Assertion: key and value are not null
                Node newNode = new Node(key, value); // Create new node

                if (nodeBefore == null)
                {                                    // Add at beginning (includes empty chain)
                    newNode.setNextNode(firstNode);
                    firstNode = newNode;
                }
                else                                 // Add elsewhere in non-empty chain
                {
                    newNode.setNextNode(currentNode); // currentNode is after new node
                    nodeBefore.setNextNode(newNode);  // nodeBefore is before new node
                } // end if

                numberOfEntries++;                   // Increase length for both cases
            } // end if
        } // end if
        return result;
    } // end add

    // returns value if found, or NULL
    public V remove(K key)
    {
            V result = null;
     
            // Search chain until you either find a node containing key
            // or locate where it should be
            Node currentNode = firstNode;
            Node nodeBefore = null;

            while ( (currentNode != null) && (key.compareTo(currentNode.getKey()) > 0) )
            {
                nodeBefore = currentNode;
                currentNode = currentNode.getNextNode();
            } // end while

            if ( (currentNode != null) && key.equals(currentNode.getKey()) )
            {
                // Key in dictionary; remove key
                result = currentNode.getValue(); // Get old value
                currentNode = currentNode.getNextNode(); // Replace node with next node
                nodeBefore.setNextNode(currentNode); // nodeBefore is before replaced node
                numberOfEntries--;                   // Decrease length 
            } // end if
        return result;
    }

    // returns value if found, or NULL
    public V getValue(K key)
    {
        V result = null;
        Node currentNode = firstNode;
     
      while ( (currentNode != null) && (key.compareTo(currentNode.getKey()) > 0) )
            {
                nodeBefore = currentNode;
                currentNode = currentNode.getNextNode();
            } // end while
  
        return null;
    }

    // NOT DONE
    public boolean contains(K key)
    {
        return false;
    }

    // NOT DONE
    public Iterator<K> getKeyIterator()
    {
        return null;
    }

    // NOT DONE
    public Iterator<V> getValueIterator()
    {
        return null;
    }

    public boolean isEmpty()
    {
        if(firstNode != null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public int getSize()
    {
        return numberOfEntries;
    }

    public void clear()
    {
        firstNode.next = null;
    }

    private class Node
    {
        private K key;
        private V value;
        private Node next;

        private Node(K key, V value)
        {
            this.key = key;
            setValue(value);
        }

        private void setValue(V newValue)
        {
            value = newValue;
        }

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        }

        private K getKey()
        {
            return key;
        }

        private V getValue()
        {
            return value;
        }

        private Node getNextNode()
        {
            return next;
        }
    } // end Node
} // end SortedLinkedDictionary
