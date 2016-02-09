package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.ProcessDefinitionQueryImpl;
import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.ProcessDefinitionDataManager;
import org.activiti.engine.repository.ProcessDefinition;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.addLabel;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.setDate;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.setString;

@Component
public class Neo4jProcessDefinitionDataManager extends AbstractNeo4jDataManager<ProcessDefinitionEntity> implements ProcessDefinitionDataManager {

    public static final String LABEL = "Deployment";

    public static final String ID_ = "id";
    public static final String KEY_ = "key";
    public static final String DEPLOYMENT_ID_ = "deploymentId";

    public Neo4jProcessDefinitionDataManager() {
        super(ProcessDefinitionEntityImpl.class);
    }

    public Neo4jProcessDefinitionDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(ProcessDefinitionEntityImpl.class);
    }

    public void insert(ProcessDefinitionEntity processDefinitionEntity) {
        if (processDefinitionEntity.getId() == null) {
            processDefinitionEntity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        addLabel(node, LABEL);
        setString(node, ID_, processDefinitionEntity.getId());
        setString(node, KEY_, processDefinitionEntity.getKey());
//        setString(node, NAME_, processDefinitionEntity.getName());
//        setString(node, CATEGORY_, processDefinitionEntity.getCategory());
//        setString(node, TENANT_ID_, processDefinitionEntity.getTenantId());
//        setDate(node, DEPLOY_TIME_, processDefinitionEntity.getDeploymentTime());
//        setString(node, ENGINE_VERSION_, processDefinitionEntity.getEngineVersion());
        setString(node, DEPLOYMENT_ID_, processDefinitionEntity.getDeploymentId());
    }

    public ProcessDefinitionEntity findLatestProcessDefinitionByKey(String processDefinitionKey) {
        ResourceIterator<Node> nodeIterator = graphDatabaseService.findNodes(DynamicLabel.label(LABEL), KEY_, processDefinitionKey);
        if (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            ProcessDefinitionEntityImpl result = new ProcessDefinitionEntityImpl();
            result.setId((String) node.getProperty(ID_));
            result.setKey((String) node.getProperty(KEY_));
            result.setDeploymentId((String) node.getProperty(DEPLOYMENT_ID_));
            return result;
        } else {
            return null;
        }
    }

    public ProcessDefinitionEntity findLatestProcessDefinitionByKeyAndTenantId(String processDefinitionKey, String tenantId) {
        return null;
    }

    public void deleteProcessDefinitionsByDeploymentId(String deploymentId) {

    }

    public List<ProcessDefinition> findProcessDefinitionsByQueryCriteria(ProcessDefinitionQueryImpl processDefinitionQuery, Page page) {
        return null;
    }

    public long findProcessDefinitionCountByQueryCriteria(ProcessDefinitionQueryImpl processDefinitionQuery) {
        return 0;
    }

    public ProcessDefinitionEntity findProcessDefinitionByDeploymentAndKey(String deploymentId, String processDefinitionKey) {
        return null;
    }

    public ProcessDefinitionEntity findProcessDefinitionByDeploymentAndKeyAndTenantId(String deploymentId, String processDefinitionKey, String tenantId) {
        return null;
    }

    public ProcessDefinitionEntity findProcessDefinitionByKeyAndVersion(String processDefinitionKey, Integer processDefinitionVersion) {
        return null;
    }

    public ProcessDefinitionEntity findProcessDefinitionByKeyAndVersionAndTenantId(String processDefinitionKey, Integer processDefinitionVersion, String tenantId) {
        return null;
    }

    public List<ProcessDefinition> findProcessDefinitionsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        return null;
    }

    public long findProcessDefinitionCountByNativeQuery(Map<String, Object> parameterMap) {
        return 0;
    }

    public void updateProcessDefinitionTenantIdForDeployment(String deploymentId, String newTenantId) {

    }
}
