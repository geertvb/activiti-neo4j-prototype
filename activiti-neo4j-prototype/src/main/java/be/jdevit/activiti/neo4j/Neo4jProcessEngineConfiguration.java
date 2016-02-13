package be.jdevit.activiti.neo4j;

import be.jdevit.activiti.neo4j.transaction.NoopTransactionContextFactory;
import org.activiti.engine.impl.cfg.IdGenerator;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.CommandInterceptor;
import org.activiti.engine.impl.persistence.entity.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Neo4jProcessEngineConfiguration extends ProcessEngineConfigurationImpl {

    @Override
    protected CommandInterceptor createTransactionInterceptor() {
        return null;
    }

    @Override
    protected void initTransactionContextFactory() {
        if (transactionContextFactory == null) {
            transactionContextFactory = new NoopTransactionContextFactory();
        }
    }

    @Autowired
    protected void setNeo4jDeploymentDataManager(DeploymentDataManager neo4jDeploymentDataManager) {
        this.deploymentDataManager = neo4jDeploymentDataManager;
    }

    @Autowired
    protected void setNeo4jResourceDataManager(ResourceDataManager neo4jResourceDataManager) {
        this.resourceDataManager = neo4jResourceDataManager;
    }

    @Autowired
    protected void setNeo4jProcessDefinitionDataManager(ProcessDefinitionDataManager neo4jProcessDefinitionDataManager) {
        this.processDefinitionDataManager = neo4jProcessDefinitionDataManager;
    }

    @Autowired
    protected void setNeo4jIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Autowired
    protected void setNeo4jExecutionDataManager(ExecutionDataManager neo4jExecutionDataManager) {
        this.executionDataManager = neo4jExecutionDataManager;
    }

    @Autowired
    protected void setNeo4jHistoricActivityInstanceDataManager(HistoricActivityInstanceDataManager neo4jHistoricActivityInstanceDataManager) {
        this.historicActivityInstanceDataManager = neo4jHistoricActivityInstanceDataManager;
    }

    @Autowired
    protected void setNeo4jTaskDataManager(TaskDataManager neo4jTaskDataManager) {
        this.taskDataManager = neo4jTaskDataManager;
    }

    @Autowired
    protected void setNeo4jEventSubscriptionDataManager(EventSubscriptionDataManager neo4jEventSubscriptionDataManager) {
        this.eventSubscriptionDataManager = neo4jEventSubscriptionDataManager;
    }

    @Autowired
    void setNeo4jJobDataManager(JobDataManager neo4jJobDataManager) {
        this.jobDataManager = neo4jJobDataManager;
    }

    @Autowired
    void setNeo4jHistoricProcessInstanceDataManager(HistoricProcessInstanceDataManager neo4jHistoricProcessInstanceDataManager) {
        this.historicProcessInstanceDataManager = neo4jHistoricProcessInstanceDataManager;
    }

    @Autowired
    void setNeo4jHistoricTaskInstanceDataManager(HistoricTaskInstanceDataManager neo4jHistoricTaskInstanceDataManager) {
        this.historicTaskInstanceDataManager = neo4jHistoricTaskInstanceDataManager;
    }


    @Override
    protected void initDataManagers() {

    }

    {
        usingRelationalDatabase = false;
    }

}
