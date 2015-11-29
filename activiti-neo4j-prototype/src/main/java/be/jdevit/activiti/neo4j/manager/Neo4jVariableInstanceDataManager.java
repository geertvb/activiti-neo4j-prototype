package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntity;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.VariableInstanceDataManager;

import java.util.Collection;
import java.util.List;

public class Neo4jVariableInstanceDataManager extends AbstractNeo4jDataManager<VariableInstanceEntity> implements VariableInstanceDataManager {

    public Neo4jVariableInstanceDataManager() {
    }

    public Neo4jVariableInstanceDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(VariableInstanceEntityImpl.class);
    }

    public List<VariableInstanceEntity> findVariableInstancesByTaskId(String taskId) {
        return null;
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
}
