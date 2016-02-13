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

import java.util.List;
import java.util.Map;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.setString;

@Component
public class Neo4jHistoricTaskInstanceDataManager extends AbstractNeo4jDataManager<HistoricTaskInstanceEntity> implements HistoricTaskInstanceDataManager {

    public static final Label LABEL = DynamicLabel.label("HistoricTaskInstance");

    public static final String ID_ = "id";

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
        // TODO
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
