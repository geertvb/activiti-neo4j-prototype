package be.jdevit.activiti.neo4j.nodemappers;

import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.impl.persistence.entity.DeploymentEntityImpl;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import static be.jdevit.activiti.neo4j.nodes.DeploymentNode.*;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component("deploymentNodeMapper")
public class DeploymentNodeMapper extends AbstractNodeMapper<DeploymentEntity> {

    public DeploymentEntity newEntity() {
        return new DeploymentEntityImpl();
    }

    public void doNode2entity(Node node, DeploymentEntity result) {
        result.setId((String) node.getProperty(ID_));
        result.setName((String) node.getProperty(NAME_, null));
        result.setCategory((String) node.getProperty(CATEGORY_, null));
        result.setTenantId((String) node.getProperty(TENANT_ID_, null));
        result.setDeploymentTime(getDate(node, DEPLOY_TIME_));
        result.setEngineVersion((String) node.getProperty(ENGINE_VERSION_, null));
    }

    public void doEntity2node(DeploymentEntity entity, Node node) {
        setString(node, ID_, entity.getId());
        setString(node, NAME_, entity.getName());
        setString(node, CATEGORY_, entity.getCategory());
        setString(node, TENANT_ID_, entity.getTenantId());
        setDate(node, DEPLOY_TIME_, entity.getDeploymentTime());
        setString(node, ENGINE_VERSION_, entity.getEngineVersion());
    }

}
