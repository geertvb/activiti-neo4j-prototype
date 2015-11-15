package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.TaskQueryImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.TaskDataManager;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;

public class Neo4jTaskDataManager extends AbstractNeo4jDataManager<TaskEntity> implements TaskDataManager {

    public Neo4jTaskDataManager() {
    }

    public Neo4jTaskDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(TaskEntityImpl.class, processEngineConfiguration);
    }

    public TaskEntity findById(String taskId, boolean checkCache) {
        return null;
    }

    public List<TaskEntity> findTasksByExecutionId(String executionId) {
        return null;
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
