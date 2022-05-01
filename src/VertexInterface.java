public interface VertexInterface<T> {

    /** Gets this vertex's label.
     @return  The object that labels the vertex. */
    public T getLabel();

    /** Marks this vertex as visited. */
    public void visit();
}
