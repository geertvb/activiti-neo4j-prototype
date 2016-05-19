package be.jdevit.activiti.neo4j.manager;

import be.jdevit.activiti.neo4j.NotImplementedException;
import be.jdevit.activiti.neo4j.nodemappers.NodeMapper;
import org.activiti.engine.impl.DeploymentQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.impl.persistence.entity.DeploymentEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.DeploymentDataManager;
import org.activiti.engine.repository.Deployment;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static be.jdevit.activiti.neo4j.nodes.DeploymentNode.ID_;
import static be.jdevit.activiti.neo4j.nodes.DeploymentNode.LABEL;

@Component
public class Neo4jDeploymentDataManager extends AbstractNeo4jDataManager<DeploymentEntity> implements DeploymentDataManager {

    @Autowired
    protected NodeMapper<DeploymentEntity> deploymentNodeMapper;

    @Override
    public DeploymentEntity create() {
        DeploymentEntityImpl deployment = new DeploymentEntityImpl();
        deployment.setId(idGenerator.getNextId());
        return deployment;
    }

    @Override
    public DeploymentEntity findById(String entityId) {
        if (entityId == null) {
            return null;
        }

        Node node = graphDatabaseService.findNode(LABEL, ID_, entityId);
        return deploymentNodeMapper.node2entity(node);
    }

    @Override
    public void insert(DeploymentEntity deploymentEntity) {
        if (deploymentEntity == null) {
            return;
        }

        if (deploymentEntity.getId() == null) {
            deploymentEntity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);

        deploymentNodeMapper.entity2node(deploymentEntity, node);
    }

    @Override
    public DeploymentEntity update(DeploymentEntity entity) {
        if (entity == null) {
            return null;
        }

        Node node = graphDatabaseService.findNode(LABEL, ID_, entity.getId());
        deploymentNodeMapper.entity2node(entity, node);

        return entity;
    }

    @Override
    public void delete(String id) {
        graphDatabaseService.findNode(LABEL, ID_, id).delete();
    }

    @Override
    public void delete(DeploymentEntity entity) {
        graphDatabaseService.findNode(LABEL, ID_, entity.getId()).delete();
    }

    public DeploymentEntity findLatestDeploymentByName(String deploymentName) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("deploymentName", deploymentName);

        Result result = graphDatabaseService.execute("" +
                        "MATCH (" +
                        "  d : Deployment {" +
                        "    name: {deploymentName}" +
                        "  }) " +
                        "RETURN d " +
                        "ORDER BY d.deploymentTime DESC " +
                        "LIMIT 1 ",
                parameters);

        ResourceIterator<Node> deployments = result.columnAs("d");
        if (deployments.hasNext()) {
            Node deployment = deployments.next();
            return deploymentNodeMapper.node2entity(deployment);
        } else {
            return null;
        }
    }

    public long findDeploymentCountByQueryCriteria(DeploymentQueryImpl deploymentQuery) {
        throw new NotImplementedException();
    }

    public List<Deployment> findDeploymentsByQueryCriteria(DeploymentQueryImpl deploymentQuery, Page page) {
        throw new NotImplementedException();
    }

    public List<String> getDeploymentResourceNames(String deploymentId) {
        throw new NotImplementedException();
    }

    public List<Deployment> findDeploymentsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new NotImplementedException();
    }

    public long findDeploymentCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new NotImplementedException();
    }

}
