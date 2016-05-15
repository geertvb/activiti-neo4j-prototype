package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntity;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.VariableInstanceDataManager;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class Neo4jVariableInstanceDataManager extends AbstractNeo4jDataManager<VariableInstanceEntity> implements VariableInstanceDataManager {

    public static final Label LABEL = DynamicLabel.label("VariableInstance");

    public static final String ID_ = "id";

    public Neo4jVariableInstanceDataManager() {
    }

    public Neo4jVariableInstanceDataManager(ProcessEngineConfiguration processEngineConfiguration) {
    }

    public List<VariableInstanceEntity> findVariableInstancesByTaskId(String taskId) {
        List<VariableInstanceEntity> result = new ArrayList<>();
        return result;
    }

    public Collection<VariableInstanceEntity> findVariableInstancesByExecutionId(String executionId) {
        return null;
    }

    public VariableInstanceEntity findVariableInstanceByExecutionAndName(String executionId, String variableName) {
        return null;
    }

    public List<VariableInstanceEntity> findVariableInstancesByExecutionAndNames(String executionId, Collection<String> names) {
        return null;
    }

    public VariableInstanceEntity findVariableInstanceByTaskAndName(String taskId, String variableName) {
        return null;
    }

    public List<VariableInstanceEntity> findVariableInstancesByTaskAndNames(String taskId, Collection<String> names) {
        return null;
    }

    @Override
    public VariableInstanceEntity create() {
        VariableInstanceEntityImpl variableInstance = new VariableInstanceEntityImpl();
        variableInstance.setId(idGenerator.getNextId());
        return variableInstance;
    }

    @Override
    public VariableInstanceEntity findById(String entityId) {
        Node node = graphDatabaseService.findNode(LABEL, ID_, entityId);
        if (node == null) {
            return null;
        }

        VariableInstanceEntityImpl result = new VariableInstanceEntityImpl();
        result.setId((String) node.getProperty(ID_));
        return result;
    }

    @Override
    public void insert(VariableInstanceEntity entity) {

    }

    @Override
    public VariableInstanceEntity update(VariableInstanceEntity entity) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(VariableInstanceEntity entity) {

    }
}
