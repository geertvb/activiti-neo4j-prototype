package be.jdevit.activiti.neo4j.nodemappers;

import org.activiti.engine.impl.persistence.entity.ResourceEntity;
import org.activiti.engine.impl.persistence.entity.ResourceEntityImpl;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import static be.jdevit.activiti.neo4j.nodes.ResourceNode.*;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component("resourceNodeMapper")
public class ResourceNodeMapper extends AbstractNodeMapper<ResourceEntity> {

    public ResourceEntity newEntity() {
        return new ResourceEntityImpl();
    }

    public void doNode2entity(Node node, ResourceEntity entity) {
        entity.setId((String) node.getProperty(ID_, null));
        entity.setName((String) node.getProperty(NAME_, null));
        entity.setDeploymentId((String) node.getProperty(DEPLOYMENT_ID_, null));
        entity.setBytes((byte[]) node.getProperty(BYTES_, null));
        entity.setGenerated((Boolean) node.getProperty(GENERATED_, null));
    }

    public void doEntity2node(ResourceEntity entity, Node node) {
        setString(node, ID_, entity.getId());
        setString(node, NAME_, entity.getName());
        setString(node, DEPLOYMENT_ID_, entity.getDeploymentId());
        setByteArray(node, BYTES_, entity.getBytes());
        setBoolean(node, GENERATED_, entity.isGenerated());
    }

}
