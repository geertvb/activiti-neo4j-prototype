package be.jdevit.activiti.neo4j.nodemappers;

import be.jdevit.activiti.neo4j.nodes.TaskNode;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component("taskNodeMapper")
public class TaskNodeMapper extends AbstractNodeMapper<TaskEntity> {

    public TaskEntity newEntity() {
        return new TaskEntityImpl();
    }

    public void doNode2entity(Node node, TaskEntity taskEntity) {
        taskEntity.setId(getString(node, TaskNode.ID_));
        // TODO
    }

    public void doEntity2node(TaskEntity taskEntity, Node node) {
        setString(node, TaskNode.ID_, taskEntity.getId());
        setInteger(node, TaskNode.REV_, taskEntity.getRevision());
        setString(node, TaskNode.EXECUTION_ID_, taskEntity.getExecutionId());
        setString(node, TaskNode.PROC_INST_ID_, taskEntity.getProcessInstanceId());
        setString(node, TaskNode.PROC_DEF_ID_, taskEntity.getProcessDefinitionId());
        setString(node, TaskNode.NAME_, taskEntity.getName());
        setString(node, TaskNode.PARENT_TASK_ID_, taskEntity.getParentTaskId());
        setString(node, TaskNode.DESCRIPTION_, taskEntity.getDescription());
        setString(node, TaskNode.TASK_DEF_KEY_, taskEntity.getTaskDefinitionKey());
        setString(node, TaskNode.OWNER_, taskEntity.getOwner());
        setString(node, TaskNode.ASSIGNEE_, taskEntity.getAssignee());
//        setString(node, TaskNode.DELEGATION_, taskEntity.getDelegationState());
        setInteger(node, TaskNode.PRIORITY_, taskEntity.getPriority());
        setDate(node, TaskNode.CREATE_TIME_, taskEntity.getCreateTime());
        setDate(node, TaskNode.DUE_DATE_, taskEntity.getDueDate());
        setString(node, TaskNode.CATEGORY_, taskEntity.getCategory());
//        setString(node, SUSPENSION_STATE_, taskEntity.getSuspensionState());
        setString(node, TaskNode.TENANT_ID_, taskEntity.getTenantId());
        setString(node, TaskNode.FORM_KEY_, taskEntity.getFormKey());
        // TODO
    }

}
