package be.jdevit.activiti.neo4j.nodemappers;

import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import static be.jdevit.activiti.neo4j.nodes.TaskNode.*;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component("taskNodeMapper")
public class TaskNodeMapper extends AbstractNodeMapper<TaskEntity> {

    public TaskEntity newEntity() {
        return new TaskEntityImpl();
    }

    public void doNode2entity(Node node, TaskEntity entity) {
        entity.setId(getString(node, ID_));
        entity.setRevision(getInteger(node, REV_));
        entity.setExecutionId(getString(node, EXECUTION_ID_));
        entity.setProcessInstanceId(getString(node, PROC_INST_ID_));
        entity.setProcessDefinitionId(getString(node, PROC_DEF_ID_));
        entity.setName(getString(node, NAME_));
        entity.setParentTaskId(getString(node, PARENT_TASK_ID_));
        entity.setDescription(getString(node, DESCRIPTION_));
        entity.setTaskDefinitionKey(getString(node, TASK_DEF_KEY_));
        entity.setOwner(getString(node, OWNER_));
        entity.setAssignee(getString(node, ASSIGNEE_));
//        entity.setDelegationState(getString(node, DELEGATION_));
        entity.setPriority(getInteger(node, PRIORITY_));
        entity.setCreateTime(getDate(node, CREATE_TIME_));
        entity.setDueDate(getDate(node, DUE_DATE_));
        entity.setCategory(getString(node, CATEGORY_));
//        entity.setSuspensionState(getString(node, SUSPENSION_STATE_));
        entity.setTenantId(getString(node, TENANT_ID_));
        entity.setFormKey(getString(node, FORM_KEY_));
    }

    public void doEntity2node(TaskEntity entity, Node node) {
        setString(node, ID_, entity.getId());
        setInteger(node, REV_, entity.getRevision());
        setString(node, EXECUTION_ID_, entity.getExecutionId());
        setString(node, PROC_INST_ID_, entity.getProcessInstanceId());
        setString(node, PROC_DEF_ID_, entity.getProcessDefinitionId());
        setString(node, NAME_, entity.getName());
        setString(node, PARENT_TASK_ID_, entity.getParentTaskId());
        setString(node, DESCRIPTION_, entity.getDescription());
        setString(node, TASK_DEF_KEY_, entity.getTaskDefinitionKey());
        setString(node, OWNER_, entity.getOwner());
        setString(node, ASSIGNEE_, entity.getAssignee());
//        setString(node, DELEGATION_, taskEntity.getDelegationState());
        setInteger(node, PRIORITY_, entity.getPriority());
        setDate(node, CREATE_TIME_, entity.getCreateTime());
        setDate(node, DUE_DATE_, entity.getDueDate());
        setString(node, CATEGORY_, entity.getCategory());
//        setString(node, SUSPENSION_STATE_, taskEntity.getSuspensionState());
        setString(node, TENANT_ID_, entity.getTenantId());
        setString(node, FORM_KEY_, entity.getFormKey());
        // TODO
    }

}
