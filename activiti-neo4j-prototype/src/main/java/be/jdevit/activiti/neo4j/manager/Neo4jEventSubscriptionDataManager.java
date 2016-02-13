package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.EventSubscriptionQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.*;
import org.activiti.engine.impl.persistence.entity.data.EventSubscriptionDataManager;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static be.jdevit.activiti.neo4j.utils.VertexUtils.setString;

@Component
public class Neo4jEventSubscriptionDataManager extends AbstractNeo4jDataManager<EventSubscriptionEntity> implements EventSubscriptionDataManager {

    public static final Label LABEL = DynamicLabel.label("EventSubscription");

    public static final String ID_ = "id";

    public Neo4jEventSubscriptionDataManager() {
    }

    public Neo4jEventSubscriptionDataManager(ProcessEngineConfiguration processEngineConfiguration) {
    }

    public MessageEventSubscriptionEntity createMessageEventSubscription() {
        return null;
    }

    public SignalEventSubscriptionEntity createSignalEventSubscription() {
        return null;
    }

    public CompensateEventSubscriptionEntity createCompensateEventSubscription() {
        return null;
    }

    public long findEventSubscriptionCountByQueryCriteria(EventSubscriptionQueryImpl eventSubscriptionQueryImpl) {
        return 0;
    }

    public List<EventSubscriptionEntity> findEventSubscriptionsByQueryCriteria(EventSubscriptionQueryImpl eventSubscriptionQueryImpl, Page page) {
        return null;
    }

    public List<MessageEventSubscriptionEntity> findMessageEventSubscriptionsByProcessInstanceAndEventName(String processInstanceId, String eventName) {
        return null;
    }

    public List<SignalEventSubscriptionEntity> findSignalEventSubscriptionsByEventName(String eventName, String tenantId) {
        return null;
    }

    public List<SignalEventSubscriptionEntity> findSignalEventSubscriptionsByProcessInstanceAndEventName(String processInstanceId, String eventName) {
        return null;
    }

    public List<SignalEventSubscriptionEntity> findSignalEventSubscriptionsByExecution(String executionId) {
        return null;
    }

    public List<SignalEventSubscriptionEntity> findSignalEventSubscriptionsByNameAndExecution(String name, String executionId) {
        return null;
    }

    public List<EventSubscriptionEntity> findEventSubscriptionsByExecutionAndType(String executionId, String type) {
        return null;
    }

    public List<EventSubscriptionEntity> findEventSubscriptionsByProcessInstanceAndActivityId(String processInstanceId, String activityId, String type) {
        return null;
    }

    public List<EventSubscriptionEntity> findEventSubscriptionsByExecution(String executionId) {
        return null;
    }

    public List<EventSubscriptionEntity> findEventSubscriptionsByConfiguration(String type, String configuration, String tenantId) {
        // TODO
        return new ArrayList<>();
    }

    public List<EventSubscriptionEntity> findEventSubscriptionsByName(String type, String eventName, String tenantId) {
        return null;
    }

    public List<EventSubscriptionEntity> findEventSubscriptionsByNameAndExecution(String type, String eventName, String executionId) {
        return null;
    }

    public MessageEventSubscriptionEntity findMessageStartEventSubscriptionByName(String messageName, String tenantId) {
        return null;
    }

    public void updateEventSubscriptionTenantId(String oldTenantId, String newTenantId) {

    }

    public void deleteEventSubscriptionsForProcessDefinition(String processDefinitionId) {

    }

    @Override
    public EventSubscriptionEntity create() {
        EventSubscriptionEntityImpl eventSubscription=new CompensateEventSubscriptionEntityImpl();
        eventSubscription.setId(idGenerator.getNextId());
        return eventSubscription;
    }

    @Override
    public EventSubscriptionEntity findById(String entityId) {
//        Node node = graphDatabaseService.findNode(LABEL, ID_, entityId);
//
//        EventSubscriptionEntityImpl result = new EventSubscriptionEntityImpl();
//        result.setId((String) node.getProperty(ID_));
//        return result;
        return null;
    }

    @Override
    public void insert(EventSubscriptionEntity eventSubscription) {
        if (eventSubscription.getId() == null) {
            eventSubscription.setId(idGenerator.getNextId());
        }

        Node node = graphDatabaseService.createNode();
        node.addLabel(LABEL);
        setString(node, ID_, eventSubscription.getId());
    }

    @Override
    public EventSubscriptionEntity update(EventSubscriptionEntity entity) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(EventSubscriptionEntity entity) {

    }
}
