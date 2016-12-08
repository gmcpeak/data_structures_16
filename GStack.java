/**
 * Generic Stack class. Depends on the Generic Node class, which is included
 * as an INNER CLASS (java lets you make classes inside classes)
 * Provides a way to create a stack of any object type using java
 * generics. The three major stack operations are supported:
 * push, pop, and peek.
 * @author Mr. Kramer
 */
public class GStack<T>
{
    //Stack comes first
    Node<T> top;

    /**
     * Push a value on the stack. Will probably crash if passed null.
     * You could technically keep a pointer to the object you push, but
     * using it to modify the object would violate the stack principle
     * (don't modify things once they're in the stack)
     * @param v object to push on the stack. DOES NOT CLONE THE OBJECT.
     */
    public void push(T v) {
        Node<T> n = new Node(v);
        n.setNext(top);
        top = n;
    }

    /**
     * Pop an object off the stack.
     * @return object popped off stack
     */
    public T pop() {
        if (top == null) {
            return null;
        }
        Node<T> ret = top;
        top = top.getNext();
        ret.setNext(null);
        return ret.get();
    }

    /**
     * peek at the top object of the stack. Caution should be used as this could be used
     * to modify the top object of the stack, although that technically violates
     * how stacks should be used.
     * @return object at top of stack. DOES NOT CLONE OBJECT.
     */
    public T peek() {
        return top.get();
    }

    //Node starts here
    public class Node <X>
    {
        X value;
        Node next;

        public Node(X val) {
            value = val;
        }

        public X get() {
            return value;
        }

        public void set(X v) {
            value = v;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }
    }
}