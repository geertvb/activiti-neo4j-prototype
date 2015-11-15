package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.persistence.entity.IdentityLinkEntity;
import org.activiti.engine.impl.persistence.entity.data.IdentityLinkDataManager;

import java.util.List;

public class Neo4jIdentityLinkDataManager extends AbstractNeo4jDataManager<IdentityLinkEntity> implements IdentityLinkDataManager {

    public Neo4jIdentityLinkDataManager() {
    }

    public Neo4jIdentityLinkDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(processEngineConfiguration);
    }

    public List<IdentityLinkEntity> findIdentityLinksByTaskId(String taskId) {
        return null;
    }

    public List<IdentityLinkEntity> findIdentityLinksByProcessInstanceId(String processInstanceId) {
        return null;
    }

    public List<IdentityLinkEntity> findIdentityLinksByProcessDefinitionId(String processDefinitionId) {
        return null;
    }

    public List<IdentityLinkEntity> findIdentityLinkByTaskUserGroupAndType(String taskId, String userId, String groupId, String type) {
        return null;
    }

    public List<IdentityLinkEntity> findIdentityLinkByProcessInstanceUserGroupAndType(String processInstanceId, String userId, String groupId, String type) {
        return null;
    }

    public List<IdentityLinkEntity> findIdentityLinkByProcessDefinitionUserAndGroup(String processDefinitionId, String userId, String groupId) {
        return null;
    }

    public void deleteIdentityLinksByProcDef(String processDefId) {

    }
}
