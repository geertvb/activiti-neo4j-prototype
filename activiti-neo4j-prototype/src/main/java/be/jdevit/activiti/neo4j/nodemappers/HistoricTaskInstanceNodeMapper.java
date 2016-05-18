package be.jdevit.activiti.neo4j.nodemappers;

import org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntity;
import org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntityImpl;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import static be.jdevit.activiti.neo4j.nodes.HistoricTaskInstanceNode.*;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component("historicTaskInstanceNodeMapper")
public class HistoricTaskInstanceNodeMapper extends AbstractNodeMapper<HistoricTaskInstanceEntity> {

    public HistoricTaskInstanceEntity newEntity() {
        return new HistoricTaskInstanceEntityImpl();
    }

    public void doNode2entity(Node node, HistoricTaskInstanceEntity entity) {
        entity.setId((String) node.getProperty(ID_, null));
        entity.setProcessDefinitionId((String) node.getProperty(PROC_DEF_ID_, null));
        entity.setTaskDefinitionKey((String) node.getProperty(TASK_DEF_KEY_, null));
        entity.setProcessInstanceId((String) node.getProperty(PROC_INST_ID_, null));
        entity.setExecutionId((String) node.getProperty(EXECUTION_ID_, null));
        entity.setParentTaskId((String) node.getProperty(PARENT_TASK_ID_, null));
        entity.setName((String) node.getProperty(NAME_, null));
        entity.setDescription((String) node.getProperty(DESCRIPTION_, null));
        entity.setOwner((String) node.getProperty(OWNER_, null));
        entity.setAssignee((String) node.getProperty(ASSIGNEE_, null));
        entity.setStartTime(getDate(node, START_TIME_));
        entity.setClaimTime(getDate(node, CLAIM_TIME_));
        entity.setEndTime(getDate(node, END_TIME_));
        entity.setDurationInMillis((Long) node.getProperty(DURATION_, null));
        entity.setDeleteReason((String) node.getProperty(DELETE_REASON_, null));
        entity.setPriority((Integer) node.getProperty(PRIORITY_, null));
        entity.setDueDate(getDate(node, DUE_DATE_));
        entity.setFormKey((String) node.getProperty(FORM_KEY_, null));
        entity.setCategory((String) node.getProperty(CATEGORY_, null));
        entity.setTenantId((String) node.getProperty(TENANT_ID_, null));
    }

    public void doEntity2node(HistoricTaskInstanceEntity entity, Node node) {
        setString(node, ID_, entity.getId());
        setString(node, PROC_DEF_ID_, entity.getProcessDefinitionId());
        setString(node, TASK_DEF_KEY_, entity.getTaskDefinitionKey());
        setString(node, PROC_INST_ID_, entity.getProcessInstanceId());
        setString(node, EXECUTION_ID_, entity.getExecutionId());
        setString(node, PARENT_TASK_ID_, entity.getParentTaskId());
        setString(node, NAME_, entity.getName());
        setString(node, DESCRIPTION_, entity.getDescription());
        setString(node, OWNER_, entity.getOwner());
        setString(node, ASSIGNEE_, entity.getAssignee());
        setDate(node, START_TIME_, entity.getStartTime());
        setDate(node, CLAIM_TIME_, entity.getClaimTime());
        setDate(node, END_TIME_, entity.getEndTime());
        setLong(node, DURATION_, entity.getDurationInMillis());
        setString(node, DELETE_REASON_, entity.getDeleteReason());
        setInteger(node, PRIORITY_, entity.getPriority());
        setDate(node, DUE_DATE_, entity.getDueDate());
        setString(node, FORM_KEY_, entity.getFormKey());
        setString(node, CATEGORY_, entity.getCategory());
        setString(node, TENANT_ID_, entity.getTenantId());
    }

}
