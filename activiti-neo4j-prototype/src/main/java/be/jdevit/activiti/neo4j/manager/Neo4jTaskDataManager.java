package be.jdevit.activiti.neo4j.manager;

import be.jdevit.activiti.neo4j.relationships.ExecutionRelationships;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.TaskQueryImpl;
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

import static be.jdevit.activiti.neo4j.utils.VertexUtils.setDate;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.setInteger;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.setString;

@Component
public class Neo4jTaskDataManager extends AbstractNeo4jDataManager<TaskEntity> implements TaskDataManager {

    public static final Label LABEL = DynamicLabel.label("Task");

    public static final String ID_ = "id";
    public static final String REV_ = "revision";
    public static final String EXECUTION_ID_ = "executionId";
    public static final String PROC_INST_ID_ = "processInstanceId";
    public static final String PROC_DEF_ID_ = "processDefinitionId";
    public static final String NAME_ = "name";
    public static final String PARENT_TASK_ID_ = "parentTaskId";
    public static final String DESCRIPTION_ = "description";
    public static final String TASK_DEF_KEY_ = "taskDefinitionKey";
    public static final String OWNER_ = "owner";
    public static final String ASSIGNEE_ = "assignee";
    public static final String DELEGATION_ = "delegation";
    public static final String PRIORITY_ = "priority";
    public static final String CREATE_TIME_ = "createTime";
    public static final String DUE_DATE_ = "dueDate";
    public static final String CATEGORY_ = "category";
    public static final String SUSPENSION_STATE_ = "suspensionState";
    public static final String TENANT_ID_ = "tenantId";
    public static final String FORM_KEY_ = "formKey";

    public Neo4jTaskDataManager() {
    }

    public Neo4jTaskDataManager(ProcessEngineConfiguration processEngineConfiguration) {
    }


    @Override
    public TaskEntity create() {
        TaskEntityImpl task = new TaskEntityImpl();
        task.setId(idGenerator.getNextId());
        return task;
    }

    @Override
    public TaskEntity findById(String entityId) {
        Node node = graphDatabaseService.findNode(LABEL, ID_, entityId);
        if (node == null) {
            return null;
        }

        TaskEntityImpl result = new TaskEntityImpl();
        result.setId((String) node.getProperty(ID_));
        return result;
    }

    @Override
    public void insert(TaskEntity taskEntity) {
        if (taskEntity.getId() == null) {
            taskEntity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);
        setString(node, ID_, taskEntity.getId());
        setInteger(node, REV_, taskEntity.getRevision());
        setString(node, EXECUTION_ID_, taskEntity.getExecutionId());
        setString(node, PROC_INST_ID_, taskEntity.getProcessInstanceId());
        setString(node, PROC_DEF_ID_, taskEntity.getProcessDefinitionId());
        setString(node, NAME_, taskEntity.getName());
        setString(node, PARENT_TASK_ID_, taskEntity.getParentTaskId());
        setString(node, DESCRIPTION_, taskEntity.getDescription());
        setString(node, TASK_DEF_KEY_, taskEntity.getTaskDefinitionKey());
        setString(node, OWNER_, taskEntity.getOwner());
        setString(node, ASSIGNEE_, taskEntity.getAssignee());
//        setString(node, DELEGATION_, taskEntity.getDelegationState());
        setInteger(node, PRIORITY_, taskEntity.getPriority());
        setDate(node, CREATE_TIME_, taskEntity.getCreateTime());
        setDate(node, DUE_DATE_, taskEntity.getDueDate());
        setString(node, CATEGORY_, taskEntity.getCategory());
//        setString(node, SUSPENSION_STATE_, taskEntity.getSuspensionState());
        setString(node, TENANT_ID_, taskEntity.getTenantId());
        setString(node, FORM_KEY_, taskEntity.getFormKey());
        // TODO
    }

    @Override
    public TaskEntity update(TaskEntity entity) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(TaskEntity entity) {

    }

    public TaskEntity findById(String taskId, boolean checkCache) {
        return null;
    }

    public List<TaskEntity> findTasksByExecutionId(String executionId) {
        List<TaskEntity> result = new ArrayList<>();
        Node executionNode = graphDatabaseService.findNode(LABEL, ID_, executionId);
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
                "MATCH (n:Task) " +
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
        List<Task> result = new ArrayList<>();
        return result;
    }

    public void updateTaskTenantIdForDeployment(String deploymentId, String newTenantId) {

    }
}
