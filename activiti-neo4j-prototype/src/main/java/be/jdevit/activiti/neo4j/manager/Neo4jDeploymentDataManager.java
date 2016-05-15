package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.impl.DeploymentQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.impl.persistence.entity.DeploymentEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.DeploymentDataManager;
import org.activiti.engine.repository.Deployment;
import org.neo4j.graphdb.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component
public class Neo4jDeploymentDataManager extends AbstractNeo4jDataManager<DeploymentEntity> implements DeploymentDataManager {

    public static final Label LABEL = DynamicLabel.label("Deployment");

    public static final String ID_ = "id";
    public static final String NAME_ = "name";
    public static final String CATEGORY_ = "category";
    public static final String TENANT_ID_ = "tenantId";
    public static final String DEPLOY_TIME_ = "deploymentTime";
    public static final String ENGINE_VERSION_ = "engineVersion";

    @Override
    public DeploymentEntity create() {
        DeploymentEntityImpl deployment = new DeploymentEntityImpl();
        deployment.setId(idGenerator.getNextId());
        return deployment;
    }

    protected DeploymentEntity node2entity(Node node) {
        if (node == null) {
            return null;
        }

        DeploymentEntityImpl result = new DeploymentEntityImpl();
        result.setId((String) node.getProperty(ID_));
        result.setName((String) node.getProperty(NAME_, null));
        result.setCategory((String) node.getProperty(CATEGORY_, null));
        result.setTenantId((String) node.getProperty(TENANT_ID_, null));
        result.setDeploymentTime(getDate(node, DEPLOY_TIME_));
        result.setEngineVersion((String) node.getProperty(ENGINE_VERSION_, null));
        return result;
    }

    protected Node entity2node(DeploymentEntity entity) {
        if (entity == null) {
            return null;
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);
        entity2node(entity, node);
        return node;
    }

    protected void entity2node(DeploymentEntity entity, Node node) {
        setString(node, ID_, entity.getId());
        setString(node, NAME_, entity.getName());
        setString(node, CATEGORY_, entity.getCategory());
        setString(node, TENANT_ID_, entity.getTenantId());
        setDate(node, DEPLOY_TIME_, entity.getDeploymentTime());
        setString(node, ENGINE_VERSION_, entity.getEngineVersion());
    }

    @Override
    public DeploymentEntity findById(String entityId) {
        if (entityId == null) {
            return null;
        }

        Node node = graphDatabaseService.findNode(LABEL, ID_, entityId);
        DeploymentEntity deploymentEntity = node2entity(node);
        return deploymentEntity;
    }

    @Override
    public void insert(DeploymentEntity deploymentEntity) {
        if (deploymentEntity == null) {
            return;
        }

        if (deploymentEntity.getId() == null) {
            deploymentEntity.setId(idGenerator.getNextId());
        }

        Node node = entity2node(deploymentEntity);
    }

    @Override
    public DeploymentEntity update(DeploymentEntity entity) {
        if (entity == null) {
            return null;
        }

        Node node = graphDatabaseService.findNode(LABEL, ID_, entity.getId());
        entity2node(entity, node);

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
            return node2entity(deployment);
        } else {
            return null;
        }
    }

    public long findDeploymentCountByQueryCriteria(DeploymentQueryImpl deploymentQuery) {
        return 0;
    }

    public List<Deployment> findDeploymentsByQueryCriteria(DeploymentQueryImpl deploymentQuery, Page page) {
        return null;
    }

    public List<String> getDeploymentResourceNames(String deploymentId) {
        return null;
    }

    public List<Deployment> findDeploymentsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        return null;
    }

    public long findDeploymentCountByNativeQuery(Map<String, Object> parameterMap) {
        return 0;
    }

}
