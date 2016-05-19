package be.jdevit.activiti.neo4j.manager;

import be.jdevit.activiti.neo4j.NotImplementedException;
import be.jdevit.activiti.neo4j.nodemappers.NodeMapper;
import be.jdevit.activiti.neo4j.nodes.ExecutionNode;
import be.jdevit.activiti.neo4j.nodes.ProcessInstanceNode;
import be.jdevit.activiti.neo4j.nodes.TaskNode;
import be.jdevit.activiti.neo4j.relationships.ExecutionRelationships;
import be.jdevit.activiti.neo4j.relationships.ProcessInstanceRelationships;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.TaskQueryImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.TaskDataManager;
import org.activiti.engine.task.Task;
import org.neo4j.graphdb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Neo4jTaskDataManager extends AbstractNeo4jDataManager<TaskEntity> implements TaskDataManager {

    @Autowired
    protected NodeMapper<TaskEntity> taskNodeMapper;

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
        TaskEntity result = null;

        if (entityId != null) {
            Node node = graphDatabaseService.findNode(TaskNode.LABEL, TaskNode.ID_, entityId);
            result = taskNodeMapper.node2entity(node);
        }

        return result;
    }

    @Override
    public void insert(TaskEntity taskEntity) {
        if (taskEntity.getId() == null) {
            taskEntity.setId(idGenerator.getNextId());
        }

        // TODO Move to mapper?
        Node node = graphDatabaseService.createNode();
        node.addLabel(TaskNode.LABEL);

        taskNodeMapper.entity2node(taskEntity, node);
    }

    @Override
    public TaskEntity update(TaskEntity entity) {
        // TODO: 18/05/2016
        return entity;
    }

    @Override
    public void delete(String id) {
        Node node = graphDatabaseService.findNode(TaskNode.LABEL, TaskNode.ID_, id);
        if (node != null) {
            node.delete();
        }
    }

    @Override
    public void delete(TaskEntity entity) {
        if (entity != null) {
            delete(entity.getId());
        }
    }

    public TaskEntity findById(String taskId, boolean checkCache) {
        throw new NotImplementedException();
    }

    public List<TaskEntity> findTasksByExecutionId(String executionId) {
        List<TaskEntity> result = new ArrayList<>();

        // Get executionNode
        Node executionNode = graphDatabaseService.findNode(ExecutionNode.LABEL, ExecutionNode.ID_, executionId);

        if (executionNode != null) {
            List<Node> nodes = new ArrayList<>();
            Iterable<Relationship> relationships = executionNode.getRelationships(Direction.OUTGOING, ExecutionRelationships.TASK);
            for (Relationship relationship : relationships) {
                Node node = relationship.getEndNode();
                nodes.add(node);
            }
            result.addAll(taskNodeMapper.nodes2entities(nodes));
        }

        return result;
    }

    public List<TaskEntity> findTasksByProcessInstanceId(String processInstanceId) {
        List<TaskEntity> result = new ArrayList<>();

        // Get executionNode
        Node processInstanceNode = graphDatabaseService.findNode(ProcessInstanceNode.LABEL, ProcessInstanceNode.ID_, processInstanceId);

        if (processInstanceNode != null) {
            List<Node> nodes = new ArrayList<>();
            Iterable<Relationship> relationships = processInstanceNode.getRelationships(Direction.OUTGOING, ProcessInstanceRelationships.TASK);
            for (Relationship relationship : relationships) {
                Node node = relationship.getEndNode();
                nodes.add(node);
            }
            result.addAll(taskNodeMapper.nodes2entities(nodes));
        }

        return result;
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
            TaskEntity task = taskNodeMapper.node2entity(node);
            result.add(task);
        }
        return result;
    }

    public List<Task> findTasksAndVariablesByQueryCriteria(TaskQueryImpl taskQuery) {
        throw new NotImplementedException();
    }

    public long findTaskCountByQueryCriteria(TaskQueryImpl taskQuery) {
        throw new NotImplementedException();
    }

    public List<Task> findTasksByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new NotImplementedException();
    }

    public long findTaskCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new NotImplementedException();
    }

    public List<Task> findTasksByParentTaskId(String parentTaskId) {
        //// TODO: 18/05/2016
        List<Task> result = new ArrayList<>();
        return result;
    }

    public void updateTaskTenantIdForDeployment(String deploymentId, String newTenantId) {
        throw new NotImplementedException();
    }

}
