package be.jdevit.activiti.neo4j.manager;

import be.jdevit.activiti.neo4j.NotImplementedException;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.HistoricActivityInstanceQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.HistoricActivityInstanceEntity;
import org.activiti.engine.impl.persistence.entity.HistoricActivityInstanceEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.HistoricActivityInstanceDataManager;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.setString;

@Component
public class Neo4jHistoricActivityInstanceDataManager extends AbstractNeo4jDataManager<HistoricActivityInstanceEntity> implements HistoricActivityInstanceDataManager {

    public static final Label LABEL = DynamicLabel.label("HistoricActivityInstance");

    public static final String ID_ = "id";

    public Neo4jHistoricActivityInstanceDataManager() {
    }

    public Neo4jHistoricActivityInstanceDataManager(ProcessEngineConfiguration processEngineConfiguration) {
    }

    public List<HistoricActivityInstanceEntity> findUnfinishedHistoricActivityInstancesByExecutionAndActivityId(String executionId, String activityId) {
        // TODO
       // throw new NotImplementedException();
        return new ArrayList<>();
    }

    public void deleteHistoricActivityInstancesByProcessInstanceId(String historicProcessInstanceId) {
        throw new NotImplementedException();
    }

    public long findHistoricActivityInstanceCountByQueryCriteria(HistoricActivityInstanceQueryImpl historicActivityInstanceQuery) {
        throw new NotImplementedException();
    }

    public List<HistoricActivityInstance> findHistoricActivityInstancesByQueryCriteria(HistoricActivityInstanceQueryImpl historicActivityInstanceQuery, Page page) {
        throw new NotImplementedException();
    }

    public List<HistoricActivityInstance> findHistoricActivityInstancesByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new NotImplementedException();
    }

    public long findHistoricActivityInstanceCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new NotImplementedException();
    }

    @Override
    public HistoricActivityInstanceEntity create() {
        HistoricActivityInstanceEntityImpl historicActivityInstance = new HistoricActivityInstanceEntityImpl();
        historicActivityInstance.setId(idGenerator.getNextId());
        return historicActivityInstance;
    }

    @Override
    public HistoricActivityInstanceEntity findById(String entityId) {
        Node node = graphDatabaseService.findNode(LABEL, ID_, entityId);
        if (node == null) {
            return null;
        }
        HistoricActivityInstanceEntityImpl historicActivityInstance = new HistoricActivityInstanceEntityImpl();
        historicActivityInstance.setId((String) node.getProperty(ID_, null));
        return historicActivityInstance;
    }

    @Override
    public void insert(HistoricActivityInstanceEntity entity) {
        if (entity.getId() == null) {
            entity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);
        setString(node, ID_, entity.getId());
        // TODO
    }

    @Override
    public HistoricActivityInstanceEntity update(HistoricActivityInstanceEntity entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(String id) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(HistoricActivityInstanceEntity entity) {
        throw new NotImplementedException();
    }
}
