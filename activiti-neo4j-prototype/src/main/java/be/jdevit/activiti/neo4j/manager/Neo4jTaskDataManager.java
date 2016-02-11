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
import org.neo4j.graphdb.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.addLabel;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.setString;

@Component
public class Neo4jTaskDataManager extends AbstractNeo4jDataManager<TaskEntity> implements TaskDataManager {

    public static final String LABEL = "Task";

    public static final String ID_ = "id";
    public static final String PROC_INST_ID_ = "processInstanceId";

    public Neo4jTaskDataManager() {
        super(TaskEntityImpl.class);
    }

    public Neo4jTaskDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(TaskEntityImpl.class);
    }


    @Override
    public void insert(TaskEntity taskEntity) {
        if (taskEntity.getId() == null) {
            taskEntity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        addLabel(node, LABEL);
        setString(node, ID_, taskEntity.getId());
        setString(node, PROC_INST_ID_, taskEntity.getProcessInstanceId());
        // TODO
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
        List<Task> result = new ArrayList<>();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("processInstanceId", taskQuery.getProcessInstanceId());

        // TODO: build query statement
        Result r = graphDatabaseService.execute("" +
                "MATCH (n) " +
                "WHERE n.processInstanceId = {processInstanceId} " +
                "RETURN n", parameters);

        ResourceIterator<Node> nodes = r.columnAs("n");
        while (nodes.hasNext()) {
            Node node = nodes.next();
            TaskEntityImpl task = new TaskEntityImpl();
            task.setId((String) node.getProperty(ID_, null));
            result.add(task);
        }
        return result;
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
