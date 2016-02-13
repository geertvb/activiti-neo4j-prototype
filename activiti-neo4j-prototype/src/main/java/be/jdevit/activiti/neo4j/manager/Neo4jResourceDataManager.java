package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.persistence.entity.ResourceEntity;
import org.activiti.engine.impl.persistence.entity.ResourceEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.ResourceDataManager;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component
public class Neo4jResourceDataManager extends AbstractNeo4jDataManager<ResourceEntity> implements ResourceDataManager {

    public static final Label LABEL = DynamicLabel.label("Resource");

    public static final String ID_ = "id";
    public static final String NAME_ = "name";
    public static final String DEPLOYMENT_ID_ = "deploymentId";
    public static final String BYTES_ = "bytes";
    public static final String GENERATED_ = "generated";

    public Neo4jResourceDataManager() {
    }

    public Neo4jResourceDataManager(ProcessEngineConfiguration processEngineConfiguration) {
    }

    @Override
    public ResourceEntity create() {
        ResourceEntityImpl resource = new ResourceEntityImpl();
        resource.setId(idGenerator.getNextId());
        return resource;
    }

    public ResourceEntity findById(String entityId) {
        Node node = graphDatabaseService.findNode(LABEL, ID_, entityId);
        if (node == null) {
            return null;
        }

        ResourceEntityImpl result = new ResourceEntityImpl();
        result.setId((String) node.getProperty(ID_));
        return result;
    }

    @Override
    public void insert(ResourceEntity resourceEntity) {
        if (resourceEntity.getId() == null) {
            resourceEntity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);
        setString(node, ID_, resourceEntity.getId());
        setString(node, NAME_, resourceEntity.getName());
        setString(node, DEPLOYMENT_ID_, resourceEntity.getDeploymentId());
        setByteArray(node, BYTES_, resourceEntity.getBytes());
        setBoolean(node, GENERATED_, resourceEntity.isGenerated());
    }

    @Override
    public ResourceEntity update(ResourceEntity entity) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(ResourceEntity entity) {

    }

    public void deleteResourcesByDeploymentId(String deploymentId) {

    }

    public ResourceEntity findResourceByDeploymentIdAndResourceName(String deploymentId, String resourceName) {
        return null;
    }

    public List<ResourceEntity> findResourcesByDeploymentId(String deploymentId) {
        ResourceIterator<Node> nodeIterator = graphDatabaseService
                .findNodes(LABEL, DEPLOYMENT_ID_, deploymentId);

        List<ResourceEntity> result = new ArrayList<>();

        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            ResourceEntityImpl resourceEntity = new ResourceEntityImpl();
            resourceEntity.setId((String) node.getProperty(ID_, null));
            resourceEntity.setName((String) node.getProperty(NAME_, null));
            resourceEntity.setDeploymentId((String) node.getProperty(DEPLOYMENT_ID_, null));
            resourceEntity.setBytes((byte[]) node.getProperty(BYTES_, null));
            resourceEntity.setGenerated((Boolean) node.getProperty(GENERATED_, null));
            result.add(resourceEntity);
        }
        return result;
    }
}
