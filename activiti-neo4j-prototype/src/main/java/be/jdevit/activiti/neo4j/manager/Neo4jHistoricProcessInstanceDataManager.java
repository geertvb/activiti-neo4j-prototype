package be.jdevit.activiti.neo4j.manager;

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
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(HistoricProcessInstanceEntity entity) {

    }
}
