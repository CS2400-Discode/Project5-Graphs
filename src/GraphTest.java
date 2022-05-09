import ADTPackage.QueueInterface;
import GraphPackage.Graph;
import GraphPackage.GraphInterface;

public class GraphTest {

    public static void main(String[] args) {
        GraphInterface<String> breadthFirstGraph = new Graph<String>();
        breadthFirstGraph.addVertex("A");
        breadthFirstGraph.addVertex("B");
        breadthFirstGraph.addVertex("C");
        breadthFirstGraph.addVertex("D");
        breadthFirstGraph.addVertex("E");
        breadthFirstGraph.addVertex("F");
        breadthFirstGraph.addVertex("G");
        breadthFirstGraph.addVertex("H");
        breadthFirstGraph.addVertex("I");

        breadthFirstGraph.addEdge("A","B");
        breadthFirstGraph.addEdge("A","D");
        breadthFirstGraph.addEdge("A","E");
        breadthFirstGraph.addEdge("B","E");
        breadthFirstGraph.addEdge("D","G");
        breadthFirstGraph.addEdge("E","F");
        breadthFirstGraph.addEdge("E","H");
        breadthFirstGraph.addEdge("G","H");
        breadthFirstGraph.addEdge("F","C");
        breadthFirstGraph.addEdge("F","H");
        breadthFirstGraph.addEdge("H","I");
        breadthFirstGraph.addEdge("C","B");
        breadthFirstGraph.addEdge("I","F");

        System.out.println("Breadth First Traversal: ");
        QueueInterface<String> output1 = breadthFirstGraph.getBreadthFirstTraversal("A");
        while(!output1.isEmpty())
        {
            System.out.print(output1.dequeue());
        }
        System.out.println();

        GraphInterface<String> depthFirstGraph = new Graph<String>();
        depthFirstGraph.addVertex("A");
        depthFirstGraph.addVertex("B");
        depthFirstGraph.addVertex("C");
        depthFirstGraph.addVertex("D");
        depthFirstGraph.addVertex("E");
        depthFirstGraph.addVertex("F");
        depthFirstGraph.addVertex("G");
        depthFirstGraph.addVertex("H");
        depthFirstGraph.addVertex("I");

        depthFirstGraph.addEdge("A","B");
        depthFirstGraph.addEdge("A","D");
        depthFirstGraph.addEdge("A","E");
        depthFirstGraph.addEdge("B","E");
        depthFirstGraph.addEdge("D","G");
        depthFirstGraph.addEdge("E","F");
        depthFirstGraph.addEdge("E","H");
        depthFirstGraph.addEdge("G","H");
        depthFirstGraph.addEdge("F","C");
        depthFirstGraph.addEdge("F","H");
        depthFirstGraph.addEdge("H","I");
        depthFirstGraph.addEdge("C","B");
        depthFirstGraph.addEdge("I","F");


        System.out.println("Depth First Traversal: ");
        QueueInterface<String> output2 =  depthFirstGraph.getDepthFirstTraversal("A");
        while(!output2.isEmpty())
        {
            System.out.print(output2.dequeue());
        }
    }
}
