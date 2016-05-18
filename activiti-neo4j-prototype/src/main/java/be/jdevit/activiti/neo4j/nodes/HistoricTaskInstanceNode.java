package be.jdevit.activiti.neo4j.nodes;


import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;

public interface HistoricTaskInstanceNode {

    Label LABEL = DynamicLabel.label("HistoricTaskInstance");

    String ID_ = "id";
    String PROC_DEF_ID_ = "processDefinitionId";
    String TASK_DEF_KEY_ = "taskDefinitionKey";
    String PROC_INST_ID_ = "processInstanceId";
    String EXECUTION_ID_ = "executionId";
    String PARENT_TASK_ID_ = "parentTaskId";
    String NAME_ = "name";
    String DESCRIPTION_ = "description";
    String OWNER_ = "owner";
    String ASSIGNEE_ = "assignee";
    String START_TIME_ = "startTime";
    String CLAIM_TIME_ = "claimTime";
    String END_TIME_ = "endTime";
    String DURATION_ = "durationInMillis";
    String DELETE_REASON_ = "deleteReason";
    String PRIORITY_ = "priority";
    String DUE_DATE_ = "dueDate";
    String FORM_KEY_ = "formKey";
    String CATEGORY_ = "category";
    String TENANT_ID_ = "tenantId";

}
