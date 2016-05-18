package be.jdevit.activiti.neo4j.manager;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.JobQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.JobEntity;
import org.activiti.engine.impl.persistence.entity.MessageEntity;
import org.activiti.engine.impl.persistence.entity.TimerEntity;
import org.activiti.engine.impl.persistence.entity.data.JobDataManager;
import org.activiti.engine.runtime.Job;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Neo4jJobDataManager extends AbstractNeo4jDataManager<JobEntity> implements JobDataManager {

    public static final Label LABEL = DynamicLabel.label("Job");

    public static final String ID_ = "id";

    public Neo4jJobDataManager() {
    }

    public Neo4jJobDataManager(ProcessEngineConfiguration processEngineConfiguration) {
    }

    public TimerEntity createTimer() {
        return null;
    }

    public MessageEntity createMessage() {
        return null;
    }

    public List<JobEntity> findNextJobsToExecute(Page page) {
        return null;
    }

    public List<JobEntity> findNextTimerJobsToExecute(Page page) {
        return null;
    }

    public List<JobEntity> findAsyncJobsDueToExecute(Page page) {
        return null;
    }

    public List<JobEntity> findJobsByLockOwner(String lockOwner, int start, int maxNrOfJobs) {
        return null;
    }

    public List<JobEntity> findJobsByExecutionId(String executionId) {
        return null;
    }

    public List<JobEntity> findExclusiveJobsToExecute(String processInstanceId) {
        return null;
    }

    public List<TimerEntity> findUnlockedTimersByDuedate(Date duedate, Page page) {
        return null;
    }

    public List<TimerEntity> findTimersByExecutionId(String executionId) {
        return null;
    }

    public List<Job> findJobsByQueryCriteria(JobQueryImpl jobQuery, Page page) {
        return null;
    }

    public List<Job> findJobsByTypeAndProcessDefinitionIds(String jobHandlerType, List<String> processDefinitionIds) {
        return null;
    }

    public List<Job> findJobsByTypeAndProcessDefinitionKeyNoTenantId(String jobHandlerType, String processDefinitionKey) {
        return null;
    }

    public List<Job> findJobsByTypeAndProcessDefinitionKeyAndTenantId(String jobHandlerType, String processDefinitionKey, String tenantId) {
        return null;
    }

    public List<Job> findJobsByTypeAndProcessDefinitionId(String jobHandlerType, String processDefinitionId) {
        return null;
    }

    public long findJobCountByQueryCriteria(JobQueryImpl jobQuery) {
        return 0;
    }

    public void updateJobTenantIdForDeployment(String deploymentId, String newTenantId) {

    }

    @Override
    public JobEntity create() {
        throw new UnsupportedOperationException();
    }

    @Override
    public JobEntity findById(String entityId) {
        return null;
    }

    @Override
    public void insert(JobEntity entity) {

    }

    @Override
    public JobEntity update(JobEntity entity) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void delete(JobEntity entity) {

    }

}
