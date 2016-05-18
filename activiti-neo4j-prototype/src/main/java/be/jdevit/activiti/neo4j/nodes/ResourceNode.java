package be.jdevit.activiti.neo4j.nodes;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;

public interface ResourceNode {

    Label LABEL = DynamicLabel.label("Resource");

    String ID_ = "id";
    String NAME_ = "name";
    String DEPLOYMENT_ID_ = "deploymentId";
    String BYTES_ = "bytes";
    String GENERATED_ = "generated";

}
