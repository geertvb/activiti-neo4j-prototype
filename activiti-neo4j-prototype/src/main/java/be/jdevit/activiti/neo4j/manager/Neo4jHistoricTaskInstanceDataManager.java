package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.HistoricTaskInstanceQueryImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntity;
import org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntityImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.data.HistoricTaskInstanceDataManager;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.*;

@Component
public class Neo4jHistoricTaskInstanceDataManager extends AbstractNeo4jDataManager<HistoricTaskInstanceEntity> implements HistoricTaskInstanceDataManager {

    public static final Label LABEL = DynamicLabel.label("HistoricTaskInstance");

    public static final String ID_ = "id";
    public static final String PROC_DEF_ID_ = "processDefinitionId";
    public static final String TASK_DEF_KEY_ = "taskDefinitionKey";
    public static final String PROC_INST_ID_ = "processInstanceId";
    public static final String EXECUTION_ID_ = "executionId";
    public static final String PARENT_TASK_ID_ = "parentTaskId";
    public static final String NAME_ = "name";
    public static final String DESCRIPTION_ = "description";
    public static final String OWNER_ = "owner";
    public static final String ASSIGNEE_ = "assignee";
    public static final String START_TIME_ = "startTime";
    public static final String CLAIM_TIME_ = "claimTime";
    public static final String END_TIME_ = "endTime";
    public static final String DURATION_ = "durationInMillis";
    public static final String DELETE_REASON_ = "deleteReason";
    public static final String PRIORITY_ = "priority";
    public static final String DUE_DATE_ = "dueDate";
    public static final String FORM_KEY_ = "formKey";
    public static final String CATEGORY_ = "category";
    public static final String TENANT_ID_ = "tenantId";

    public Neo4jHistoricTaskInstanceDataManager() {
    }

    public Neo4jHistoricTaskInstanceDataManager(ProcessEngineConfiguration processEngineConfiguration) {
    }

    public HistoricTaskInstanceEntity create(TaskEntity task, ExecutionEntity execution) {
        return new HistoricTaskInstanceEntityImpl(task, execution);
    }

    @Override
    public List<HistoricTaskInstanceEntity> findHistoricTasksByParentTaskId(String s) {
        return null;
    }

    public List<HistoricTaskInstanceEntity> findHistoricTaskInstanceByProcessInstanceId(String processInstanceId) {
        return null;
    }

    public long findHistoricTaskInstanceCountByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
        return 0;
    }

    public List<HistoricTaskInstance> findHistoricTaskInstancesByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
        return null;
    }

    public List<HistoricTaskInstance> findHistoricTaskInstancesAndVariablesByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
        return null;
    }

    public List<HistoricTaskInstance> findHistoricTaskInstancesByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        return null;
    }

    public long findHistoricTaskInstanceCountByNativeQuery(Map<String, Object> parameterMap) {
        return 0;
    }

    @Override
    public HistoricTaskInstanceEntity create() {
        HistoricTaskInstanceEntityImpl historicTaskInstance = new HistoricTaskInstanceEntityImpl();
        historicTaskInstance.setId(idGenerator.getNextId());
        return historicTaskInstance;
    }

    @Override
    public HistoricTaskInstanceEntity findById(String entityId) {
        Node node = graphDatabaseService.findNode(LABEL, ID_, entityId);
        if (node == null) {
            return null;
        }
        HistoricTaskInstanceEntityImpl historicTaskInstance = new HistoricTaskInstanceEntityImpl();
        historicTaskInstance.setId((String) node.getProperty(ID_, null));
        historicTaskInstance.setProcessDefinitionId((String) node.getProperty(PROC_DEF_ID_, null));
        historicTaskInstance.setTaskDefinitionKey((String) node.getProperty(TASK_DEF_KEY_, null));
        historicTaskInstance.setProcessInstanceId((String) node.getProperty(PROC_INST_ID_, null));
        historicTaskInstance.setExecutionId((String) node.getProperty(EXECUTION_ID_, null));
        historicTaskInstance.setParentTaskId((String) node.getProperty(PARENT_TASK_ID_, null));
        historicTaskInstance.setName((String) node.getProperty(NAME_, null));
        historicTaskInstance.setDescription((String) node.getProperty(DESCRIPTION_, null));
        historicTaskInstance.setOwner((String) node.getProperty(OWNER_, null));
        historicTaskInstance.setAssignee((String) node.getProperty(ASSIGNEE_, null));
        historicTaskInstance.setStartTime(getDate(node, START_TIME_));
        historicTaskInstance.setClaimTime(getDate(node, CLAIM_TIME_));
        historicTaskInstance.setEndTime(getDate(node, END_TIME_));
        historicTaskInstance.setDurationInMillis((Long) node.getProperty(DURATION_, null));
        historicTaskInstance.setDeleteReason((String) node.getProperty(DELETE_REASON_, null));
        historicTaskInstance.setPriority((Integer) node.getProperty(PRIORITY_, null));
        historicTaskInstance.setDueDate(getDate(node, DUE_DATE_));
        historicTaskInstance.setFormKey((String) node.getProperty(FORM_KEY_, null));
        historicTaskInstance.setCategory((String) node.getProperty(CATEGORY_, null));
        historicTaskInstance.setTenantId((String) node.getProperty(TENANT_ID_, null));
        return historicTaskInstance;
    }

    @Override
    public void insert(HistoricTaskInstanceEntity entity) {
        if (entity.getId() == null) {
            entity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);
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

    @Override
    public HistoricTaskInstanceEntity update(HistoricTaskInstanceEntity entity) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(HistoricTaskInstanceEntity entity) {

    }
}
