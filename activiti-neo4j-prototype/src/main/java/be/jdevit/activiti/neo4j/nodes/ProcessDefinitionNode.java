package be.jdevit.activiti.neo4j.nodes;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;

public interface ProcessDefinitionNode {

    Label LABEL = DynamicLabel.label("ProcessDefinition");

    String ID_ = "id";
    String REV_ = "revision";
    String CATEGORY_ = "category";
    String NAME_ = "name";
    String KEY_ = "key";
    String VERSION_ = "version";
    String DEPLOYMENT_ID_ = "deploymentId";
    String RESOURCE_NAME_ = "resourceName";
    String DGRM_RESOURCE_NAME_ = "diagramResourceName";
    String DESCRIPTION_ = "description";
    String HAS_START_FORM_KEY_ = "hasStartFormKey";
    String HAS_GRAPHICAL_NOTATION_ = "hasGraphicalNotation";
    String SUSPENSION_STATE_ = "suspensionState";
    String TENANT_ID_ = "tenantId";
    String ENGINE_VERSION_ = "engineVersion";

}
