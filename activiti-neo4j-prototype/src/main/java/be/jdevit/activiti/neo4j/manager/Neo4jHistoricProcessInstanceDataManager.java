package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.HistoricProcessInstanceQueryImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.HistoricProcessInstanceEntity;
import org.activiti.engine.impl.persistence.entity.HistoricProcessInstanceEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.HistoricProcessInstanceDataManager;

import java.util.List;
import java.util.Map;

public class Neo4jHistoricProcessInstanceDataManager extends AbstractNeo4jDataManager<HistoricProcessInstanceEntity> implements HistoricProcessInstanceDataManager {

    public Neo4jHistoricProcessInstanceDataManager() {
    }

    public Neo4jHistoricProcessInstanceDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(HistoricProcessInstanceEntityImpl.class);
    }

    public HistoricProcessInstanceEntity create(ExecutionEntity processInstanceExecutionEntity) {
        return new HistoricProcessInstanceEntityImpl(processInstanceExecutionEntity);
    }

    public List<String> findHistoricProcessInstanceIdsByProcessDefinitionId(String processDefinitionId) {
        return null;
    }

    public List<HistoricProcessInstanceEntity> findHistoricProcessInstancesBySuperProcessInstanceId(String superProcessInstanceId) {
        return null;
    }

    public long findHistoricProcessInstanceCountByQueryCriteria(HistoricProcessInstanceQueryImpl historicProcessInstanceQuery) {
        return 0;
    }

    public List<HistoricProcessInstance> findHistoricProcessInstancesByQueryCriteria(HistoricProcessInstanceQueryImpl historicProcessInstanceQuery) {
        return null;
    }

    public List<HistoricProcessInstance> findHistoricProcessInstancesAndVariablesByQueryCriteria(HistoricProcessInstanceQueryImpl historicProcessInstanceQuery) {
        return null;
    }

    public List<HistoricProcessInstance> findHistoricProcessInstancesByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        return null;
    }

    public long findHistoricProcessInstanceCountByNativeQuery(Map<String, Object> parameterMap) {
        return 0;
    }

}
