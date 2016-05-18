package be.jdevit.activiti.neo4j.nodemappers;

import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.neo4j.graphdb.Node;

import java.util.List;

public interface NodeMapper<T> {

    T node2entity(Node node);

    void node2entity(Node node, T entity);

    void entity2node(T entity, Node node);

    List<T> nodes2entities(Iterable<Node> nodes);

}
