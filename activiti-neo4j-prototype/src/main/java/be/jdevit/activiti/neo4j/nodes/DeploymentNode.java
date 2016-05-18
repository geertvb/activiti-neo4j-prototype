package be.jdevit.activiti.neo4j.nodes;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;

public interface DeploymentNode {

    Label LABEL = DynamicLabel.label("Deployment");

    String ID_ = "id";
    String NAME_ = "name";
    String CATEGORY_ = "category";
    String TENANT_ID_ = "tenantId";
    String DEPLOY_TIME_ = "deploymentTime";
    String ENGINE_VERSION_ = "engineVersion";

}
