package be.jdevit.activiti.neo4j.manager;

import be.jdevit.activiti.neo4j.NotImplementedException;
import be.jdevit.activiti.neo4j.nodemappers.NodeMapper;
import be.jdevit.activiti.neo4j.nodes.HistoricTaskInstanceNode;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.HistoricTaskInstanceQueryImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntity;
import org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntityImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.data.HistoricTaskInstanceDataManager;
import org.neo4j.graphdb.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Neo4jHistoricTaskInstanceDataManager extends AbstractNeo4jDataManager<HistoricTaskInstanceEntity> implements HistoricTaskInstanceDataManager {

    @Autowired
    protected NodeMapper<HistoricTaskInstanceEntity> historicTaskInstanceMapper;

    public Neo4jHistoricTaskInstanceDataManager() {
    }

    public Neo4jHistoricTaskInstanceDataManager(ProcessEngineConfiguration processEngineConfiguration) {
    }

    public HistoricTaskInstanceEntity create(TaskEntity task, ExecutionEntity execution) {
        return new HistoricTaskInstanceEntityImpl(task, execution);
    }

    @Override
    public List<HistoricTaskInstanceEntity> findHistoricTasksByParentTaskId(String s) {
        throw new NotImplementedException();
    }

    public List<HistoricTaskInstanceEntity> findHistoricTaskInstanceByProcessInstanceId(String processInstanceId) {
        throw new NotImplementedException();
    }

    public long findHistoricTaskInstanceCountByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
        throw new NotImplementedException();
    }

    public List<HistoricTaskInstance> findHistoricTaskInstancesByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
        throw new NotImplementedException();
    }

    public List<HistoricTaskInstance> findHistoricTaskInstancesAndVariablesByQueryCriteria(HistoricTaskInstanceQueryImpl historicTaskInstanceQuery) {
        throw new NotImplementedException();
    }

    public List<HistoricTaskInstance> findHistoricTaskInstancesByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new NotImplementedException();
    }

    public long findHistoricTaskInstanceCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new NotImplementedException();
    }

    @Override
    public HistoricTaskInstanceEntity create() {
        HistoricTaskInstanceEntityImpl historicTaskInstance = new HistoricTaskInstanceEntityImpl();
        historicTaskInstance.setId(idGenerator.getNextId());
        return historicTaskInstance;
    }

    @Override
    public HistoricTaskInstanceEntity findById(String entityId) {
        Node node = graphDatabaseService.findNode(HistoricTaskInstanceNode.LABEL, HistoricTaskInstanceNode.ID_, entityId);
        if (node == null) {
            return null;
        }
        return historicTaskInstanceMapper.node2entity(node);
    }

    @Override
    public void insert(HistoricTaskInstanceEntity entity) {
        if (entity.getId() == null) {
            entity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(HistoricTaskInstanceNode.LABEL);

        historicTaskInstanceMapper.entity2node(entity, node);
    }

    @Override
    public HistoricTaskInstanceEntity update(HistoricTaskInstanceEntity entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(String id) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(HistoricTaskInstanceEntity entity) {
        throw new NotImplementedException();
    }
}
