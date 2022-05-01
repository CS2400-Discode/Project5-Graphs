import java.util.LinkedList;
import java.util.List;

public class Vertex<T> implements VertexInterface<T> {

    private T label;
    private boolean visited;
    private List<Vertex<T>> edgeList = new LinkedList<>();

    public Vertex(T vertexLabel)
    {
        label = vertexLabel;
        edgeList = new LinkedList<>();
        visited = false;
    }
    
    public T getLabel(){
        return label;
    }

    public void visit(){
        visited = true;
    }

}