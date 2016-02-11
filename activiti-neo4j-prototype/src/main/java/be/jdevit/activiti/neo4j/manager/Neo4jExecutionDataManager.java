package be.jdevit.activiti.neo4j.manager;

import be.jdevit.activiti.neo4j.relationships.ExecutionRelationships;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.ExecutionQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.ProcessInstanceQueryImpl;
import org.activiti.engine.impl.persistence.entity.DeploymentEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.ExecutionDataManager;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.springframework.stereotype.Component;

import java.util.*;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.addLabel;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.setDate;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.setString;

@Component
public class Neo4jExecutionDataManager extends AbstractNeo4jDataManager<ExecutionEntity> implements ExecutionDataManager {

    public static final String LABEL = "Execution";

    public static final String ID_ = "id";

    @Override
    public void insert(ExecutionEntity executionEntity) {
        if (executionEntity.getId() == null) {
            executionEntity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        addLabel(node, LABEL);
        setString(node, ID_, executionEntity.getId());
        // TODO
    }

    public Neo4jExecutionDataManager() {
        super(ExecutionEntityImpl.class);
    }

    public Neo4jExecutionDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(ExecutionEntityImpl.class);
    }

    public ExecutionEntity findSubProcessInstanceBySuperExecutionId(String superExecutionId) {
        return null;
    }

    public List<ExecutionEntity> findChildExecutionsByParentExecutionId(String parentExecutionId) {
        List<ExecutionEntity> result = new ArrayList<>();
        Node parentNode = graphDatabaseService.findNode(DynamicLabel.label(LABEL), ID_, parentExecutionId);
        if (parentNode != null) {
            Iterable<Relationship> relationships = parentNode.getRelationships(Direction.OUTGOING, ExecutionRelationships.PARENT_OF);
            for (Relationship relationship : relationships) {
                Node childNode = relationship.getEndNode();
                ExecutionEntityImpl execution = new ExecutionEntityImpl();
                execution.setId((String) childNode.getProperty(ID_, null));
                // TODO
//                execution.set
                result.add(execution);
            }
        }
        return result;
    }

    public List<ExecutionEntity> findChildExecutionsByProcessInstanceId(String processInstanceId) {
        return null;
    }

    public List<ExecutionEntity> findExecutionsByParentExecutionAndActivityIds(String parentExecutionId, Collection<String> activityIds) {
        return null;
    }

    public long findExecutionCountByQueryCriteria(ExecutionQueryImpl executionQuery) {
        return 0;
    }

    public List<ExecutionEntity> findExecutionsByQueryCriteria(ExecutionQueryImpl executionQuery, Page page) {
        return null;
    }

    public long findProcessInstanceCountByQueryCriteria(ProcessInstanceQueryImpl executionQuery) {
        return 0;
    }

    public List<ProcessInstance> findProcessInstanceByQueryCriteria(ProcessInstanceQueryImpl executionQuery) {
        return null;
    }

    public List<ExecutionEntity> findExecutionsByRootProcessInstanceId(String rootProcessInstanceId) {
        return null;
    }

    public List<ExecutionEntity> findExecutionsByProcessInstanceId(String processInstanceId) {
        return null;
    }

    public List<ProcessInstance> findProcessInstanceAndVariablesByQueryCriteria(ProcessInstanceQueryImpl executionQuery) {
        return null;
    }

    public List<ExecutionEntity> findEventScopeExecutionsByActivityId(String activityRef, String parentExecutionId) {
        return null;
    }

    public Collection<ExecutionEntity> findInactiveExecutionsByActivityId(String activityId) {
        return null;
    }

    public Collection<ExecutionEntity> findInactiveExecutionsByProcessInstanceId(String processInstanceId) {
        return null;
    }

    public Collection<ExecutionEntity> findInactiveExecutionsByActivityIdAndProcessInstanceId(String activityId, String processInstanceId) {
        return null;
    }

    public List<String> findProcessInstanceIdsByProcessDefinitionId(String processDefinitionId) {
        return null;
    }

    public List<Execution> findExecutionsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        return null;
    }

    public List<ProcessInstance> findProcessInstanceByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        return null;
    }

    public long findExecutionCountByNativeQuery(Map<String, Object> parameterMap) {
        return 0;
    }

    public void updateExecutionTenantIdForDeployment(String deploymentId, String newTenantId) {

    }

    public void updateProcessInstanceLockTime(String processInstanceId, Date lockDate, Date expirationTime) {

    }

    public void clearProcessInstanceLockTime(String processInstanceId) {

    }

}
