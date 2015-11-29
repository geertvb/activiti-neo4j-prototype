package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.impl.DeploymentQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.impl.persistence.entity.DeploymentEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.DeploymentDataManager;
import org.activiti.engine.repository.Deployment;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component
public class Neo4jDeploymentDataManager extends AbstractNeo4jDataManager<DeploymentEntity> implements DeploymentDataManager {

    public static final String LABEL = "Deployment";

    public static final String ID_ = "id";
    public static final String NAME_ = "name";
    public static final String CATEGORY_ = "category";
    public static final String TENANT_ID_ = "tenantId";
    public static final String DEPLOY_TIME_ = "deploymentTime";
    public static final String ENGINE_VERSION_ = "engineVersion";

    public Neo4jDeploymentDataManager() {
        super(DeploymentEntityImpl.class);
    }


    @Override
    public void insert(DeploymentEntity deploymentEntity) {
        if (deploymentEntity.getId() == null) {
            deploymentEntity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        addLabel(node, LABEL);
        setString(node, ID_, deploymentEntity.getId());
        setString(node, NAME_, deploymentEntity.getName());
        setString(node, CATEGORY_, deploymentEntity.getCategory());
        setString(node, TENANT_ID_, deploymentEntity.getTenantId());
        setDate(node, DEPLOY_TIME_, deploymentEntity.getDeploymentTime());
        setString(node, ENGINE_VERSION_, deploymentEntity.getEngineVersion());
    }

    public DeploymentEntity findLatestDeploymentByName(String deploymentName) {
        return null;
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
