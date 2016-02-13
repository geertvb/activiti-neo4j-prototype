package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.persistence.entity.IdentityLinkEntity;
import org.activiti.engine.impl.persistence.entity.IdentityLinkEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.IdentityLinkDataManager;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import java.util.List;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.setString;

@Component
public class Neo4jIdentityLinkDataManager extends AbstractNeo4jDataManager<IdentityLinkEntity> implements IdentityLinkDataManager {

    public static final Label LABEL = DynamicLabel.label("IdentityLink");

    public static final String ID_ = "id";

    public Neo4jIdentityLinkDataManager() {
    }

    public Neo4jIdentityLinkDataManager(ProcessEngineConfiguration processEngineConfiguration) {
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

    @Override
    public IdentityLinkEntity create() {
        IdentityLinkEntityImpl identityLink = new IdentityLinkEntityImpl();
        identityLink.setId(idGenerator.getNextId());
        return identityLink;
    }

    @Override
    public IdentityLinkEntity findById(String entityId) {
        Node node = graphDatabaseService.findNode(LABEL, ID_, entityId);
        if (node == null) {
            return null;
        }
        IdentityLinkEntityImpl entity = new IdentityLinkEntityImpl();
        entity.setId((String) node.getProperty(ID_, null));
        return entity;
    }

    @Override
    public void insert(IdentityLinkEntity entity) {
        if (entity.getId() == null) {
            entity.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);
        setString(node, ID_, entity.getId());
        // TODO
    }

    @Override
    public IdentityLinkEntity update(IdentityLinkEntity entity) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(IdentityLinkEntity entity) {

    }
}
