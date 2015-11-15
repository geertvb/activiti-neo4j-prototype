package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.DeploymentQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.impl.persistence.entity.data.DeploymentDataManager;
import org.activiti.engine.repository.Deployment;

import java.util.List;
import java.util.Map;

public class Neo4jDeploymentDataManager extends AbstractNeo4jDataManager<DeploymentEntity> implements DeploymentDataManager {

    public Neo4jDeploymentDataManager() {
    }

    public Neo4jDeploymentDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(processEngineConfiguration);
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
