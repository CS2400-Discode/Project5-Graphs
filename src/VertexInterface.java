public interface VertexInterface<T> {
    

    /** Gets this vertex's label.
     @return  The object that labels the vertex. */
    public T getLabel();

    /** Marks this vertex as visited. */
    public void visit();

    /** Sees whether the vertex is marked as visited.
       @return  True if the vertex is visited. */
    public boolean isVisited();
    
}