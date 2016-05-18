package be.jdevit.activiti.neo4j.nodes;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;

public interface TaskNode {

    Label LABEL = DynamicLabel.label("Task");

    String ID_ = "id";
    String REV_ = "revision";
    String EXECUTION_ID_ = "executionId";
    String PROC_INST_ID_ = "processInstanceId";
    String PROC_DEF_ID_ = "processDefinitionId";
    String NAME_ = "name";
    String PARENT_TASK_ID_ = "parentTaskId";
    String DESCRIPTION_ = "description";
    String TASK_DEF_KEY_ = "taskDefinitionKey";
    String OWNER_ = "owner";
    String ASSIGNEE_ = "assignee";
    String DELEGATION_ = "delegation";
    String PRIORITY_ = "priority";
    String CREATE_TIME_ = "createTime";
    String DUE_DATE_ = "dueDate";
    String CATEGORY_ = "category";
    String SUSPENSION_STATE_ = "suspensionState";
    String TENANT_ID_ = "tenantId";
    String FORM_KEY_ = "formKey";

}
