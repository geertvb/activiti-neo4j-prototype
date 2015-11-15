package be.jdevit.activiti.neo4j;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.IdGenerator;
import org.activiti.engine.impl.persistence.StrongUuidGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Neo4jConfig {

    @Bean
    public IdGenerator neo4jIdGenerator() {
        StrongUuidGenerator result = new StrongUuidGenerator();
        return result;
    }

    @Bean
    public ProcessEngineConfiguration neo4jProcessEngineConfiguration() {
        Neo4jProcessEngineConfiguration result = new Neo4jProcessEngineConfiguration();
        result.setUsingRelationalDatabase(false);
        result.setIdGenerator(neo4jIdGenerator());
        return result;
    }

}
