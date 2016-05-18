package be.jdevit.activiti.neo4j.nodes;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;

public interface ExecutionNode {

    Label LABEL = DynamicLabel.label("Execution");

    String ID_ = "id";

}
