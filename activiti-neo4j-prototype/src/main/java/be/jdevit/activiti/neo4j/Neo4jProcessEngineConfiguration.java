package be.jdevit.activiti.neo4j;

import be.jdevit.activiti.neo4j.manager.*;
import be.jdevit.activiti.neo4j.transaction.NoopTransactionContextFactory;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.CommandInterceptor;

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

//    protected void initAttachmentDataManager() {
//        if (attachmentDataManager == null) {
//            attachmentDataManager = new Neo4jAttachmentDataManager(this);
//        }
//    }
//
//    protected void initByteArrayDataManager() {
//        if (byteArrayDataManager == null) {
//            byteArrayDataManager = new Neo4jByteArrayDataManager(this);
//        }
//    }
//
//    protected void initCommentDataManager() {
//        if (commentDataManager == null) {
//            commentDataManager = new Neo4jCommentDataManager(this);
//        }
//    }

    protected void initDeploymentDataManager() {
        if (deploymentDataManager == null) {
            deploymentDataManager = new Neo4jDeploymentDataManager(this);
        }
    }

//    protected void initLogEntryDataManager() {
//        if (eventLogEntryDataManager == null) {
//            eventLogEntryDataManager = new Neo4jEventLogEntryDataManager(this);
//        }
//    }

    protected void initEventSubscriptionDataManager() {
        if (eventSubscriptionDataManager == null) {
            eventSubscriptionDataManager = new Neo4jEventSubscriptionDataManager(this);
        }
    }

    protected void initExecutionDataManager() {
        if (executionDataManager == null) {
            executionDataManager = new Neo4jExecutionDataManager(this);
        }
    }

//    protected void initGroupDataManager() {
//        if (groupDataManager == null) {
//            groupDataManager = new Neo4jGroupDataManager(this);
//        }
//    }

    protected void initHistoricActivityInstanceDataManager() {
        if (historicActivityInstanceDataManager == null) {
            historicActivityInstanceDataManager = new Neo4jHistoricActivityInstanceDataManager(this);
        }
    }

//    protected void initHistoricDetailDataManager() {
//        if (historicDetailDataManager == null) {
//            historicDetailDataManager = new Neo4jHistoricDetailDataManager(this);
//        }
//    }
//
//    protected void initHistoricIdentityLinkDataManager() {
//        if (historicIdentityLinkDataManager == null) {
//            historicIdentityLinkDataManager = new Neo4jHistoricIdentityLinkDataManager(this);
//        }
//    }

    protected void initHistoricProcessInstanceDataManager() {
        if (historicProcessInstanceDataManager == null) {
            historicProcessInstanceDataManager = new Neo4jHistoricProcessInstanceDataManager(this);
        }
    }

    protected void initHistoricTaskInstanceDataManager() {
        if (historicTaskInstanceDataManager == null) {
            historicTaskInstanceDataManager = new Neo4jHistoricTaskInstanceDataManager(this);
        }
    }

//    protected void initHistoricVariableInstanceDataManager() {
//        if (historicVariableInstanceDataManager == null) {
//            historicVariableInstanceDataManager = new Neo4jHistoricVariableInstanceDataManager(this);
//        }
//    }
//
//    protected void initIdentityInfoDataManager() {
//        if (identityInfoDataManager == null) {
//            identityInfoDataManager = new Neo4jIdentityInfoDataManager(this);
//        }
//    }

    protected void initIdentityLinkDataManager() {
        if (identityLinkDataManager == null) {
            identityLinkDataManager = new Neo4jIdentityLinkDataManager(this);
        }
    }

    protected void initJobDataManager() {
        if (jobDataManager == null) {
            jobDataManager = new Neo4jJobDataManager(this);
        }
    }

//    protected void initMembershipDataManager() {
//        if (membershipDataManager == null) {
//            membershipDataManager = new Neo4jMembershipDataManager(this);
//        }
//    }
//
//    protected void initModelDataManager() {
//        if (modelDataManager == null) {
//            modelDataManager = new Neo4jModelDataManager(this);
//        }
//    }

    protected void initProcessDefinitionDataManager() {
        if (processDefinitionDataManager == null) {
            processDefinitionDataManager = new Neo4jProcessDefinitionDataManager(this);
        }
    }

//    protected void initProcessDefinitionInfoDataManager() {
//        if (processDefinitionInfoDataManager == null) {
//            processDefinitionInfoDataManager = new Neo4jProcessDefinitionInfoDataManager(this);
//        }
//    }
//
//    protected void initPropertyDataManager() {
//        if (propertyDataManager == null) {
//            propertyDataManager = new Neo4jPropertyDataManager(this);
//        }
//    }

    protected void initResourceDataManager() {
        if (resourceDataManager == null) {
            resourceDataManager = new Neo4jResourceDataManager(this);
        }
    }

    protected void initTaskDataManager() {
        if (taskDataManager == null) {
            taskDataManager = new Neo4jTaskDataManager(this);
        }
    }

//    protected void initUserDataManager() {
//        if (userDataManager == null) {
//            userDataManager = new Neo4jUserDataManager(this);
//        }
//    }

    protected void initVariableInstanceDataManager() {
        if (variableInstanceDataManager == null) {
            variableInstanceDataManager = new Neo4jVariableInstanceDataManager(this);
        }
    }

    @Override
    protected void initDataManagers() {
//        initAttachmentDataManager();
//        initByteArrayDataManager();
//        initCommentDataManager();
        initDeploymentDataManager();
//        initLogEntryDataManager();
        initEventSubscriptionDataManager();
        initExecutionDataManager();
//        initGroupDataManager();
        initHistoricActivityInstanceDataManager();
//        initHistoricDetailDataManager();
//        initHistoricIdentityLinkDataManager();
        initHistoricProcessInstanceDataManager();
        initHistoricTaskInstanceDataManager();
//        initHistoricVariableInstanceDataManager();
//        initIdentityInfoDataManager();
        initIdentityLinkDataManager();
        initJobDataManager();
//        initMembershipDataManager();
//        initModelDataManager();
        initProcessDefinitionDataManager();
//        initProcessDefinitionInfoDataManager();
//        initPropertyDataManager();
        initResourceDataManager();
        initTaskDataManager();
//        initUserDataManager();
        initVariableInstanceDataManager();
    }

}
