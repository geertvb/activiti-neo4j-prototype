package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.HistoricActivityInstanceQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.HistoricActivityInstanceEntity;
import org.activiti.engine.impl.persistence.entity.HistoricActivityInstanceEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.HistoricActivityInstanceDataManager;

import java.util.List;
import java.util.Map;

public class Neo4jHistoricActivityInstanceDataManager extends AbstractNeo4jDataManager<HistoricActivityInstanceEntity> implements HistoricActivityInstanceDataManager {

    public Neo4jHistoricActivityInstanceDataManager() {
    }

    public Neo4jHistoricActivityInstanceDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(HistoricActivityInstanceEntityImpl.class, processEngineConfiguration);
    }

    public List<HistoricActivityInstanceEntity> findUnfinishedHistoricActivityInstancesByExecutionAndActivityId(String executionId, String activityId) {
        return null;
    }

    public void deleteHistoricActivityInstancesByProcessInstanceId(String historicProcessInstanceId) {

    }

    public long findHistoricActivityInstanceCountByQueryCriteria(HistoricActivityInstanceQueryImpl historicActivityInstanceQuery) {
        return 0;
    }

    public List<HistoricActivityInstance> findHistoricActivityInstancesByQueryCriteria(HistoricActivityInstanceQueryImpl historicActivityInstanceQuery, Page page) {
        return null;
    }

    public List<HistoricActivityInstance> findHistoricActivityInstancesByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        return null;
    }

    public long findHistoricActivityInstanceCountByNativeQuery(Map<String, Object> parameterMap) {
        return 0;
    }

}
