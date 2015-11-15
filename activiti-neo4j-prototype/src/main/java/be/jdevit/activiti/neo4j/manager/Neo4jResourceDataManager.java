package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.persistence.entity.ResourceEntity;
import org.activiti.engine.impl.persistence.entity.data.ResourceDataManager;

import java.util.List;

public class Neo4jResourceDataManager extends AbstractNeo4jDataManager<ResourceEntity> implements ResourceDataManager {

    public Neo4jResourceDataManager() {
    }

    public Neo4jResourceDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(processEngineConfiguration);
    }

    public void deleteResourcesByDeploymentId(String deploymentId) {

    }

    public ResourceEntity findResourceByDeploymentIdAndResourceName(String deploymentId, String resourceName) {
        return null;
    }

    public List<ResourceEntity> findResourcesByDeploymentId(String deploymentId) {
        return null;
    }
}
