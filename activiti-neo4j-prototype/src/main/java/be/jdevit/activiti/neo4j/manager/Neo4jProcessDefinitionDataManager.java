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
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component
public class Neo4jProcessDefinitionDataManager extends AbstractNeo4jDataManager<ProcessDefinitionEntity> implements ProcessDefinitionDataManager {

    public static final Label LABEL = DynamicLabel.label("ProcessDefinition");

    public static final String ID_ = "id";
    public static final String REV_ = "revision";
    public static final String CATEGORY_ = "category";
    public static final String NAME_ = "name";
    public static final String KEY_ = "key";
    public static final String VERSION_ = "version";
    public static final String DEPLOYMENT_ID_ = "deploymentId";
    public static final String RESOURCE_NAME_ = "resourceName";
    public static final String DGRM_RESOURCE_NAME_ = "diagramResourceName";
    public static final String DESCRIPTION_ = "description";
    public static final String HAS_START_FORM_KEY_ = "hasStartFormKey";
    public static final String HAS_GRAPHICAL_NOTATION_ = "hasGraphicalNotation";
    public static final String SUSPENSION_STATE_ = "suspensionState";
    public static final String TENANT_ID_ = "tenantId";
    public static final String ENGINE_VERSION_ = "engineVersion";

    public Neo4jProcessDefinitionDataManager() {
    }

    public Neo4jProcessDefinitionDataManager(ProcessEngineConfiguration processEngineConfiguration) {
    }

    @Override
    public ProcessDefinitionEntity create() {
        ProcessDefinitionEntityImpl processDefinition = new ProcessDefinitionEntityImpl();
        processDefinition.setId(idGenerator.getNextId());
        return processDefinition;
    }

    @Override
    public ProcessDefinitionEntity findById(String entityId) {
        return null;
    }

    public void insert(ProcessDefinitionEntity processDefinitionEntity) {
        if (processDefinitionEntity.getId() == null) {
            processDefinitionEntity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);
        setString(node, ID_, processDefinitionEntity.getId());
        setInteger(node, REV_, processDefinitionEntity.getRevision());
        setString(node, CATEGORY_, processDefinitionEntity.getCategory());
        setString(node, NAME_, processDefinitionEntity.getName());
        setString(node, KEY_, processDefinitionEntity.getKey());
        setInteger(node, VERSION_, processDefinitionEntity.getVersion());
        setString(node, DEPLOYMENT_ID_, processDefinitionEntity.getDeploymentId());
        setString(node, RESOURCE_NAME_, processDefinitionEntity.getResourceName());
        setString(node, DGRM_RESOURCE_NAME_, processDefinitionEntity.getDiagramResourceName());
        setString(node, DESCRIPTION_, processDefinitionEntity.getDescription());
        setBoolean(node, HAS_START_FORM_KEY_, processDefinitionEntity.hasStartFormKey());
        setBoolean(node, HAS_GRAPHICAL_NOTATION_, processDefinitionEntity.hasGraphicalNotation());
        setInteger(node, SUSPENSION_STATE_, processDefinitionEntity.getSuspensionState());
        setString(node, TENANT_ID_, processDefinitionEntity.getTenantId());
        setString(node, ENGINE_VERSION_, processDefinitionEntity.getEngineVersion());
    }

    @Override
    public ProcessDefinitionEntity update(ProcessDefinitionEntity entity) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(ProcessDefinitionEntity entity) {

    }

    public ProcessDefinitionEntity findLatestProcessDefinitionByKey(String processDefinitionKey) {
        ResourceIterator<Node> nodeIterator = graphDatabaseService.findNodes(LABEL, KEY_, processDefinitionKey);
        if (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            ProcessDefinitionEntityImpl result = new ProcessDefinitionEntityImpl();
            result.setId(getString(node, ID_));
            result.setRevision((Integer) node.getProperty(REV_, null));
            result.setCategory(getString(node, CATEGORY_));
            result.setName(getString(node, NAME_));
            result.setKey(getString(node, KEY_));
            result.setVersion((Integer) node.getProperty(VERSION_, null));
            result.setDeploymentId(getString(node, DEPLOYMENT_ID_));
            result.setResourceName(getString(node, RESOURCE_NAME_));
            result.setDiagramResourceName(getString(node, DGRM_RESOURCE_NAME_));
            result.setDescription(getString(node, DESCRIPTION_));
            result.setHasStartFormKey(getBoolean(node, HAS_START_FORM_KEY_));
            result.setGraphicalNotationDefined(getBoolean(node, HAS_GRAPHICAL_NOTATION_));
            result.setTenantId(getString(node, TENANT_ID_));
            result.setEngineVersion(getString(node, ENGINE_VERSION_));
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
// TODO
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
