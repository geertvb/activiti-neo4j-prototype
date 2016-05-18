package be.jdevit.activiti.neo4j.nodemappers;

import org.neo4j.graphdb.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractNodeMapper<T> implements NodeMapper<T> {

    public abstract T newEntity();

    public T node2entity(Node node) {
        T result = null;

        if (node != null) {
            result = newEntity();
            node2entity(node, result);
        }

        return result;
    }

    public abstract void doNode2entity(Node node, T entity);

    public void node2entity(Node node, T entity) {
        if (node != null && entity != null) {
            doNode2entity(node, entity);
        }
    }

    public abstract void doEntity2node(T entity, Node node);

    public void entity2node(T entity, Node node) {
        if (entity != null && node != null) {
            doEntity2node(entity, node);
        }
    }

    public List<T> nodes2entities(Iterable<Node> nodes) {
        List<T> result=null;

        if (nodes != null) {
            result = new ArrayList<>();
            Iterator<Node> iterator = nodes.iterator();
            while (iterator.hasNext()) {
                Node node = iterator.next();
                result.add(node2entity(node));
            }
        }

        return result;
    }

}
