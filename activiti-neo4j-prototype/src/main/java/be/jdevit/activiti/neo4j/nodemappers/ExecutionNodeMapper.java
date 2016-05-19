package be.jdevit.activiti.neo4j.nodemappers;

import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityImpl;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import static be.jdevit.activiti.neo4j.nodes.ExecutionNode.*;
import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component("executionNodeMapper")
public class ExecutionNodeMapper extends AbstractNodeMapper<ExecutionEntity> {

    public ExecutionEntity newEntity() {
        return new ExecutionEntityImpl();
    }

    public void doNode2entity(Node node, ExecutionEntity entity) {
        entity.setId(getString(node, ID_));
        entity.setRevision(getInteger(node, REV_));
        entity.setProcessInstanceId(getString(node, PROC_INST_ID_));
        entity.setBusinessKey(getString(node, BUSINESS_KEY_));
        entity.setParentId(getString(node, PARENT_ID_));
        entity.setProcessDefinitionId(getString(node, PROC_DEF_ID_));
//        entity.setSuperExecution(getString(node, SUPER_EXEC_));\
        entity.setRootProcessInstanceId(getString(node, ROOT_PROC_INST_ID_));
//        entity.setActivityId(getString(node, ACT_ID_));
        entity.setActive(getBoolean(node, IS_ACTIVE_));
        entity.setConcurrent(getBoolean(node, IS_CONCURRENT_));
        entity.setScope(getBoolean(node, IS_SCOPE_));
        entity.setEventScope(getBoolean(node, IS_EVENT_SCOPE_));
        entity.setMultiInstanceRoot(getBoolean(node, IS_MI_ROOT_));
        entity.setSuspensionState(getInteger(node, SUSPENSION_STATE_));
//        entity.setCachedEntityState(getString(node, CACHED_ENT_STATE_));
        entity.setTenantId(getString(node, TENANT_ID_));
        entity.setName(getString(node, NAME_));
        entity.setLockTime(getDate(node, LOCK_TIME_));
    }

    public void doEntity2node(ExecutionEntity entity, Node node) {
        setString(node, ID_, entity.getId());
        setInteger(node, REV_, entity.getRevision());
        setString(node, PROC_INST_ID_, entity.getProcessInstanceId());
        setString(node, BUSINESS_KEY_, entity.getBusinessKey());
        setString(node, PARENT_ID_, entity.getParentId());
        setString(node, PROC_DEF_ID_, entity.getProcessDefinitionId());
        setString(node, SUPER_EXEC_, entity.getSuperExecutionId());
        setString(node, ROOT_PROC_INST_ID_, entity.getRootProcessInstanceId());
        setString(node, ACT_ID_, entity.getActivityId());
        setBoolean(node, IS_ACTIVE_, entity.isActive());
        setBoolean(node, IS_CONCURRENT_, entity.isConcurrent());
        setBoolean(node, IS_SCOPE_, entity.isScope());
        setBoolean(node, IS_EVENT_SCOPE_, entity.isEventScope());
        setBoolean(node, IS_MI_ROOT_, entity.isMultiInstanceRoot());
        setInteger(node, SUSPENSION_STATE_, entity.getSuspensionState());
//        setString(node, CACHED_ENT_STATE_, entity.getCachedEntityState());
        setString(node, TENANT_ID_, entity.getTenantId());
        setString(node, NAME_, entity.getName());
        setDate(node, LOCK_TIME_, entity.getLockTime());
    }

}
