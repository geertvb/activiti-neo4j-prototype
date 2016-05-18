package be.jdevit.activiti.neo4j.nodes;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;

public interface ProcessInstanceNode {

    Label LABEL = DynamicLabel.label("ProcessInstance");

    String ID_ = "id";

}
