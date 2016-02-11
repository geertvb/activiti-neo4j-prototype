package be.jdevit.activiti.neo4j.manager;

import be.jdevit.activiti.neo4j.relationships.ExecutionRelationships;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.TaskQueryImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.TaskDataManager;
import org.activiti.engine.task.Task;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Neo4jTaskDataManager extends AbstractNeo4jDataManager<TaskEntity> implements TaskDataManager {

    public static final String LABEL = "Task";

    public static final String ID_ = "id";

    public Neo4jTaskDataManager() {
        super(TaskEntityImpl.class);
    }

    public Neo4jTaskDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(TaskEntityImpl.class);
    }

    public TaskEntity findById(String taskId, boolean checkCache) {
        return null;
    }

    public List<TaskEntity> findTasksByExecutionId(String executionId) {
        List<TaskEntity> result = new ArrayList<>();
        Node executionNode = graphDatabaseService.findNode(DynamicLabel.label(LABEL), ID_, executionId);
        if (executionNode != null) {
            Iterable<Relationship> relationships = executionNode.getRelationships(Direction.OUTGOING, ExecutionRelationships.TASK);
            for (Relationship relationship : relationships) {
                Node taskNode = relationship.getEndNode();
                TaskEntityImpl task = new TaskEntityImpl();
                task.setId((String) taskNode.getProperty(ID_, null));
                // TODO
//                execution.set
                result.add(task);
            }
        }
        return result;
    }

    public List<TaskEntity> findTasksByProcessInstanceId(String processInstanceId) {
        return null;
    }

    public List<Task> findTasksByQueryCriteria(TaskQueryImpl taskQuery) {
        return null;
    }

    public List<Task> findTasksAndVariablesByQueryCriteria(TaskQueryImpl taskQuery) {
        return null;
    }

    public long findTaskCountByQueryCriteria(TaskQueryImpl taskQuery) {
        return 0;
    }

    public List<Task> findTasksByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        return null;
    }

    public long findTaskCountByNativeQuery(Map<String, Object> parameterMap) {
        return 0;
    }

    public List<Task> findTasksByParentTaskId(String parentTaskId) {
        return null;
    }

    public void updateTaskTenantIdForDeployment(String deploymentId, String newTenantId) {

    }
}
