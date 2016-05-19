package be.jdevit.activiti.neo4j.manager;

import be.jdevit.activiti.neo4j.NotImplementedException;
import be.jdevit.activiti.neo4j.nodemappers.NodeMapper;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.ExecutionQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.ProcessInstanceQueryImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.ExecutionDataManager;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static be.jdevit.activiti.neo4j.nodes.ExecutionNode.ID_;
import static be.jdevit.activiti.neo4j.nodes.ExecutionNode.LABEL;

@Component
public class Neo4jExecutionDataManager extends AbstractNeo4jDataManager<ExecutionEntity> implements ExecutionDataManager {

    @Autowired
    protected NodeMapper<ExecutionEntity> executionNodeMapper;

    @Override
    public ExecutionEntity create() {
        ExecutionEntityImpl execution = new ExecutionEntityImpl();
        execution.setId(idGenerator.getNextId());
        return execution;
    }

    @Override
    public ExecutionEntity findById(String entityId) {
        Node node = graphDatabaseService.findNode(LABEL, ID_, entityId);
        ExecutionEntity result = executionNodeMapper.node2entity(node);
        return result;
    }

    @Override
    public void insert(ExecutionEntity executionEntity) {
        if (executionEntity.getId() == null) {
            executionEntity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);
        executionNodeMapper.entity2node(executionEntity, node);
    }

    @Override
    public ExecutionEntity update(ExecutionEntity entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(String id) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(ExecutionEntity entity) {
        throw new NotImplementedException();
    }

    public Neo4jExecutionDataManager() {
    }

    public Neo4jExecutionDataManager(ProcessEngineConfiguration processEngineConfiguration) {
    }

    public ExecutionEntity findSubProcessInstanceBySuperExecutionId(String superExecutionId) {
        throw new NotImplementedException();
    }

    public List<ExecutionEntity> findChildExecutionsByParentExecutionId(String parentExecutionId) {
        List<ExecutionEntity> result = new ArrayList<>();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("parentId", parentExecutionId);

        Result r = graphDatabaseService.execute("" +
                        "MATCH (" +
                        "  d : Execution {" +
                        "    parentId: {parentId}" +
                        "  }) " +
                        "RETURN d ",
                parameters);

        ResourceIterator<Node> executions = r.columnAs("d");

            while (executions.hasNext()) {
                Node node = executions.next();
                ExecutionEntity execution = executionNodeMapper.node2entity(node);
                result.add(execution);
            }

        return result;
    }

    public List<ExecutionEntity> findChildExecutionsByProcessInstanceId(String processInstanceId) {
        throw new NotImplementedException();
    }

    public List<ExecutionEntity> findExecutionsByParentExecutionAndActivityIds(String parentExecutionId, Collection<String> activityIds) {
        throw new NotImplementedException();
    }

    public long findExecutionCountByQueryCriteria(ExecutionQueryImpl executionQuery) {
        throw new NotImplementedException();
    }

    public List<ExecutionEntity> findExecutionsByQueryCriteria(ExecutionQueryImpl executionQuery, Page page) {
        throw new NotImplementedException();
    }

    public long findProcessInstanceCountByQueryCriteria(ProcessInstanceQueryImpl executionQuery) {
        throw new NotImplementedException();
    }

    public List<ProcessInstance> findProcessInstanceByQueryCriteria(ProcessInstanceQueryImpl executionQuery) {
        throw new NotImplementedException();
    }

    public List<ExecutionEntity> findExecutionsByRootProcessInstanceId(String rootProcessInstanceId) {
        throw new NotImplementedException();
    }

    public List<ExecutionEntity> findExecutionsByProcessInstanceId(String processInstanceId) {
        throw new NotImplementedException();
    }

    public List<ProcessInstance> findProcessInstanceAndVariablesByQueryCriteria(ProcessInstanceQueryImpl executionQuery) {
        throw new NotImplementedException();
    }

    public List<ExecutionEntity> findEventScopeExecutionsByActivityId(String activityRef, String parentExecutionId) {
        throw new NotImplementedException();
    }

    public Collection<ExecutionEntity> findInactiveExecutionsByActivityId(String activityId) {
        throw new NotImplementedException();
    }

    public Collection<ExecutionEntity> findInactiveExecutionsByProcessInstanceId(String processInstanceId) {
        throw new NotImplementedException();
    }

    public Collection<ExecutionEntity> findInactiveExecutionsByActivityIdAndProcessInstanceId(String activityId, String processInstanceId) {
        throw new NotImplementedException();
    }

    public List<String> findProcessInstanceIdsByProcessDefinitionId(String processDefinitionId) {
        throw new NotImplementedException();
    }

    public List<Execution> findExecutionsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new NotImplementedException();
    }

    public List<ProcessInstance> findProcessInstanceByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new NotImplementedException();
    }

    public long findExecutionCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new NotImplementedException();
    }

    public void updateExecutionTenantIdForDeployment(String deploymentId, String newTenantId) {
        throw new NotImplementedException();
    }

    public void updateProcessInstanceLockTime(String processInstanceId, Date lockDate, Date expirationTime) {
        throw new NotImplementedException();
    }

    public void clearProcessInstanceLockTime(String processInstanceId) {
        throw new NotImplementedException();
    }

}
