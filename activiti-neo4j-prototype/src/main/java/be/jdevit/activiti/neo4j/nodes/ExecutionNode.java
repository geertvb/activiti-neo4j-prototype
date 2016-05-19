package be.jdevit.activiti.neo4j.nodes;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;

public interface ExecutionNode {

    Label LABEL = DynamicLabel.label("Execution");

    String ID_ = "id";
    String REV_ = "revision";
    String PROC_INST_ID_ = "processInstanceId";
    String BUSINESS_KEY_ = "businessKey";
    String PARENT_ID_ = "parentId";
    String PROC_DEF_ID_ = "processDefinitionId";
    String SUPER_EXEC_ = "superExecution";
    String ROOT_PROC_INST_ID_ = "rootProcessInstanceId";
    String ACT_ID_ = "activityId";
    String IS_ACTIVE_ = "isActive";
    String IS_CONCURRENT_ = "isConcurrent";
    String IS_SCOPE_ = "isScope";
    String IS_EVENT_SCOPE_ = "isEventScope";
    String IS_MI_ROOT_ = "isMultiInstanceRoot";
    String SUSPENSION_STATE_ = "suspensionState";
    String CACHED_ENT_STATE_ = "cachedEntityState";
    String TENANT_ID_ = "tenantId";
    String NAME_ = "name";
    String LOCK_TIME_ = "lockTime";

}
