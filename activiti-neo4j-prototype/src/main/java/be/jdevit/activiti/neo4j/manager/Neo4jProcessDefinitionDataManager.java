package be.jdevit.activiti.neo4j.manager;

import be.jdevit.activiti.neo4j.NotImplementedException;
import be.jdevit.activiti.neo4j.nodemappers.NodeMapper;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.ProcessDefinitionQueryImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.ProcessDefinitionDataManager;
import org.activiti.engine.repository.ProcessDefinition;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static be.jdevit.activiti.neo4j.nodes.ProcessDefinitionNode.LABEL;

@Component
public class Neo4jProcessDefinitionDataManager extends AbstractNeo4jDataManager<ProcessDefinitionEntity> implements ProcessDefinitionDataManager {

    @Autowired
    protected NodeMapper<ProcessDefinitionEntity> processDefinitionNodeMapper;

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
        throw new NotImplementedException();
    }

    public void insert(ProcessDefinitionEntity processDefinitionEntity) {
        if (processDefinitionEntity.getId() == null) {
            processDefinitionEntity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);

        processDefinitionNodeMapper.entity2node(processDefinitionEntity, node);
    }

    @Override
    public ProcessDefinitionEntity update(ProcessDefinitionEntity entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(String id) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(ProcessDefinitionEntity entity) {
        throw new NotImplementedException();
    }

    public ProcessDefinitionEntity findLatestProcessDefinitionByKey(String processDefinitionKey) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("processDefinitionKey", processDefinitionKey);

        Result result = graphDatabaseService.execute("" +
                        "MATCH (" +
                        "  d : ProcessDefinition {" +
                        "    key: {processDefinitionKey}" +
                        "  }) " +
                        "RETURN d " +
                        "ORDER BY d.version DESC " +
                        "LIMIT 1 ",
                parameters);

        ResourceIterator<Node> deployments = result.columnAs("d");
        if (deployments.hasNext()) {
            Node node = deployments.next();
            return processDefinitionNodeMapper.node2entity(node);
        } else {
            return null;
        }
    }

    public ProcessDefinitionEntity findLatestProcessDefinitionByKeyAndTenantId(String processDefinitionKey, String tenantId) {
        throw new NotImplementedException();
    }

    public void deleteProcessDefinitionsByDeploymentId(String deploymentId) {
        throw new NotImplementedException();
    }

    public List<ProcessDefinition> findProcessDefinitionsByQueryCriteria(ProcessDefinitionQueryImpl processDefinitionQuery, Page page) {
        throw new NotImplementedException();
    }

    public long findProcessDefinitionCountByQueryCriteria(ProcessDefinitionQueryImpl processDefinitionQuery) {
        throw new NotImplementedException();
    }

    public ProcessDefinitionEntity findProcessDefinitionByDeploymentAndKey(String deploymentId, String processDefinitionKey) {
// TODO
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("deploymentId", deploymentId);
        parameters.put("processDefinitionKey", processDefinitionKey);

        Result result = graphDatabaseService.execute("" +
                        "MATCH (" +
                        "  d : ProcessDefinition {" +
                        "    deploymentId: {deploymentId}," +
                        "    key: {processDefinitionKey}" +
                        "  }) " +
                        "RETURN d " +
                        "ORDER BY d.deploymentTime DESC " +
                        "LIMIT 1 ",
                parameters);

        ResourceIterator<Node> deployments = result.columnAs("d");
        if (deployments.hasNext()) {
            Node deployment = deployments.next();
            return processDefinitionNodeMapper.node2entity(deployment);
        } else {
            return null;
        }
    }

    public ProcessDefinitionEntity findProcessDefinitionByDeploymentAndKeyAndTenantId(String deploymentId, String processDefinitionKey, String tenantId) {
        throw new NotImplementedException();
    }

    public ProcessDefinitionEntity findProcessDefinitionByKeyAndVersion(String processDefinitionKey, Integer processDefinitionVersion) {
        throw new NotImplementedException();
    }

    public ProcessDefinitionEntity findProcessDefinitionByKeyAndVersionAndTenantId(String processDefinitionKey, Integer processDefinitionVersion, String tenantId) {
        throw new NotImplementedException();
    }

    public List<ProcessDefinition> findProcessDefinitionsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new NotImplementedException();
    }

    public long findProcessDefinitionCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new NotImplementedException();
    }

    public void updateProcessDefinitionTenantIdForDeployment(String deploymentId, String newTenantId) {
        throw new NotImplementedException();
    }
}
