package be.jdevit.activiti.neo4j.nodemappers;

import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntityImpl;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import static be.jdevit.activiti.neo4j.nodes.ProcessDefinitionNode.*;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component("processDefinitionNodeMapper")
public class ProcessDefinitionNodeMapper extends AbstractNodeMapper<ProcessDefinitionEntity> {

    public ProcessDefinitionEntity newEntity() {
        return new ProcessDefinitionEntityImpl();
    }

    public void doNode2entity(Node node, ProcessDefinitionEntity entity) {
        entity.setId(getString(node, ID_));
        entity.setRevision((Integer) node.getProperty(REV_, null));
        entity.setCategory(getString(node, CATEGORY_));
        entity.setName(getString(node, NAME_));
        entity.setKey(getString(node, KEY_));
        entity.setVersion((Integer) node.getProperty(VERSION_, null));
        entity.setDeploymentId(getString(node, DEPLOYMENT_ID_));
        entity.setResourceName(getString(node, RESOURCE_NAME_));
        entity.setDiagramResourceName(getString(node, DGRM_RESOURCE_NAME_));
        entity.setDescription(getString(node, DESCRIPTION_));
        entity.setHasStartFormKey(getBoolean(node, HAS_START_FORM_KEY_));
        entity.setGraphicalNotationDefined(getBoolean(node, HAS_GRAPHICAL_NOTATION_));
        entity.setTenantId(getString(node, TENANT_ID_));
        entity.setEngineVersion(getString(node, ENGINE_VERSION_));
    }

    public void doEntity2node(ProcessDefinitionEntity entity, Node node) {
        setString(node, ID_, entity.getId());
        setInteger(node, REV_, entity.getRevision());
        setString(node, CATEGORY_, entity.getCategory());
        setString(node, NAME_, entity.getName());
        setString(node, KEY_, entity.getKey());
        setInteger(node, VERSION_, entity.getVersion());
        setString(node, DEPLOYMENT_ID_, entity.getDeploymentId());
        setString(node, RESOURCE_NAME_, entity.getResourceName());
        setString(node, DGRM_RESOURCE_NAME_, entity.getDiagramResourceName());
        setString(node, DESCRIPTION_, entity.getDescription());
        setBoolean(node, HAS_START_FORM_KEY_, entity.hasStartFormKey());
        setBoolean(node, HAS_GRAPHICAL_NOTATION_, entity.hasGraphicalNotation());
        setInteger(node, SUSPENSION_STATE_, entity.getSuspensionState());
        setString(node, TENANT_ID_, entity.getTenantId());
        setString(node, ENGINE_VERSION_, entity.getEngineVersion());
    }

}
