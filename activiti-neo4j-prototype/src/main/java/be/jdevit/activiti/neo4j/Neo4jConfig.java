package be.jdevit.activiti.neo4j;

import org.activiti.engine.impl.cfg.IdGenerator;
import org.activiti.engine.impl.persistence.StrongUuidGenerator;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseBuilder;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;

@Configuration
@EnableTransactionManagement
public class Neo4jConfig {

    @Value("classpath:config/graph.properties")
    Resource graphProperties;

    @Value("target/neo4j")
    File storeDir;

    @Bean
    public IdGenerator neo4jIdGenerator() {
        StrongUuidGenerator result = new StrongUuidGenerator();
        return result;
    }

    @Bean
    public GraphDatabaseService graphDatabaseService() throws Exception {
        GraphDatabaseFactory graphDatabaseFactory = new GraphDatabaseFactory();
        GraphDatabaseBuilder graphDatabaseBuilder = graphDatabaseFactory.newEmbeddedDatabaseBuilder(storeDir);
        graphDatabaseBuilder.loadPropertiesFromURL(graphProperties.getURL());
        GraphDatabaseService graphDatabaseService = graphDatabaseBuilder.newGraphDatabase();
        return graphDatabaseService;
    }

}
