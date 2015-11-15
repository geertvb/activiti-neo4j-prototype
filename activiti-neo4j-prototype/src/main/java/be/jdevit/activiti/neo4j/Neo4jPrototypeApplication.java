package be.jdevit.activiti.neo4j;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Neo4jPrototypeApplication implements CommandLineRunner {

    @Autowired
    ProcessEngineConfiguration configuration;

    public void run(String... args) {
        ProcessEngine processEngine = configuration.buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        HistoryService historyService = processEngine.getHistoryService();

        Deployment deployment = repositoryService
                .createDeployment()
                .addClasspathResource("diagrams/oneTaskProcess.bpmn20.xml")
                .deploy();

        System.out.println("Process deployed! Deployment id is " + deployment.getId());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("oneTaskProcess");
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
        System.out.println("Got " + tasks.size() + " tasks!");

        taskService.complete(tasks.get(0).getId());
        System.out.println("Number of process instances = " + historyService.createHistoricProcessInstanceQuery().count());
        System.out.println("Number of active process instances = " + historyService.createHistoricProcessInstanceQuery().finished().count());
        System.out.println("Number of finished process instances = " + historyService.createHistoricProcessInstanceQuery().unfinished().count());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Neo4jPrototypeApplication.class, args);
    }

}
