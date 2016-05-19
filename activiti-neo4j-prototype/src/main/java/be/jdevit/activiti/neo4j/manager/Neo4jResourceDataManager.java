package be.jdevit.activiti.neo4j.manager;

import be.jdevit.activiti.neo4j.NotImplementedException;
import be.jdevit.activiti.neo4j.nodemappers.NodeMapper;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.persistence.entity.ResourceEntity;
import org.activiti.engine.impl.persistence.entity.ResourceEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.ResourceDataManager;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static be.jdevit.activiti.neo4j.nodes.ResourceNode.*;

@Component
public class Neo4jResourceDataManager extends AbstractNeo4jDataManager<ResourceEntity> implements ResourceDataManager {

    @Autowired
    protected NodeMapper<ResourceEntity> resourceNodeMapper;

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
        resourceNodeMapper.entity2node(resourceEntity, node);
    }

    @Override
    public ResourceEntity update(ResourceEntity entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(String id) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(ResourceEntity entity) {
        throw new NotImplementedException();
    }

    public void deleteResourcesByDeploymentId(String deploymentId) {
        throw new NotImplementedException();
    }

    public ResourceEntity findResourceByDeploymentIdAndResourceName(String deploymentId, String resourceName) {
        throw new NotImplementedException();
    }

    public List<ResourceEntity> findResourcesByDeploymentId(String deploymentId) {
        ResourceIterator<Node> nodeIterator = graphDatabaseService
                .findNodes(LABEL, DEPLOYMENT_ID_, deploymentId);

        List<ResourceEntity> result = new ArrayList<>();

        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            ResourceEntityImpl resourceEntity = new ResourceEntityImpl();
            resourceNodeMapper.node2entity(node, resourceEntity);
            result.add(resourceEntity);
        }
        return result;
    }
}
