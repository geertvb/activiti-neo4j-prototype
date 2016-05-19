package be.jdevit.activiti.neo4j.manager;

import be.jdevit.activiti.neo4j.NotImplementedException;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.HistoricProcessInstanceQueryImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.HistoricProcessInstanceEntity;
import org.activiti.engine.impl.persistence.entity.HistoricProcessInstanceEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.HistoricProcessInstanceDataManager;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.setString;

@Component
public class Neo4jHistoricProcessInstanceDataManager extends AbstractNeo4jDataManager<HistoricProcessInstanceEntity> implements HistoricProcessInstanceDataManager {

    public static final Label LABEL = DynamicLabel.label("HistoricProcessInstance");

    public static final String ID_ = "id";

    public Neo4jHistoricProcessInstanceDataManager() {
    }

    public Neo4jHistoricProcessInstanceDataManager(ProcessEngineConfiguration processEngineConfiguration) {
    }

    public HistoricProcessInstanceEntity create(ExecutionEntity processInstanceExecutionEntity) {
        return new HistoricProcessInstanceEntityImpl(processInstanceExecutionEntity);
    }

    public List<String> findHistoricProcessInstanceIdsByProcessDefinitionId(String processDefinitionId) {
        throw new NotImplementedException();
    }

    public List<HistoricProcessInstanceEntity> findHistoricProcessInstancesBySuperProcessInstanceId(String superProcessInstanceId) {
        throw new NotImplementedException();
    }

    public long findHistoricProcessInstanceCountByQueryCriteria(HistoricProcessInstanceQueryImpl historicProcessInstanceQuery) {
        throw new NotImplementedException();
    }

    public List<HistoricProcessInstance> findHistoricProcessInstancesByQueryCriteria(HistoricProcessInstanceQueryImpl historicProcessInstanceQuery) {
        throw new NotImplementedException();
    }

    public List<HistoricProcessInstance> findHistoricProcessInstancesAndVariablesByQueryCriteria(HistoricProcessInstanceQueryImpl historicProcessInstanceQuery) {
        throw new NotImplementedException();
    }

    public List<HistoricProcessInstance> findHistoricProcessInstancesByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new NotImplementedException();
    }

    public long findHistoricProcessInstanceCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new NotImplementedException();
    }

    @Override
    public HistoricProcessInstanceEntity create() {
        HistoricProcessInstanceEntityImpl historicProcessInstance = new HistoricProcessInstanceEntityImpl();
        historicProcessInstance.setId(idGenerator.getNextId());
        return historicProcessInstance;
    }

    @Override
    public HistoricProcessInstanceEntity findById(String entityId) {
        Node node = graphDatabaseService.findNode(LABEL, ID_, entityId);
        if (node == null) {
            return null;
        }
        HistoricProcessInstanceEntityImpl historicProcessInstance = new HistoricProcessInstanceEntityImpl();
        historicProcessInstance.setId((String) node.getProperty(ID_, null));
        return historicProcessInstance;
    }

    @Override
    public void insert(HistoricProcessInstanceEntity entity) {
        if (entity.getId() == null) {
            entity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);
        setString(node, ID_, entity.getId());
        // TODO
    }

    @Override
    public HistoricProcessInstanceEntity update(HistoricProcessInstanceEntity entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(String id) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(HistoricProcessInstanceEntity entity) {
        throw new NotImplementedException();
    }
}
