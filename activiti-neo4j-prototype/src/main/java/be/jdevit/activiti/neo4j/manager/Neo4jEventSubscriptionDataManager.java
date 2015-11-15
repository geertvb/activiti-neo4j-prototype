package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.EventSubscriptionQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.*;
import org.activiti.engine.impl.persistence.entity.data.EventSubscriptionDataManager;

import java.util.List;

public class Neo4jEventSubscriptionDataManager extends AbstractNeo4jDataManager<EventSubscriptionEntity> implements EventSubscriptionDataManager {

    public Neo4jEventSubscriptionDataManager() {
    }

    public Neo4jEventSubscriptionDataManager(ProcessEngineConfiguration processEngineConfiguration) {
        super(EventSubscriptionEntityImpl.class, processEngineConfiguration);
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
        return null;
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
}
