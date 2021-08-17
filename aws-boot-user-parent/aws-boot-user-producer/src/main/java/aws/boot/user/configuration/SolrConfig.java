package aws.boot.user.configuration;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration @ComponentScan
@ConditionalOnProperty(name="feature.database.solr.connected",havingValue = "true", matchIfMissing = false)
@EnableSolrRepositories(basePackages = {"aws.boot.user.repository"},
			namedQueriesLocation = "classpath:solr-named-queries.properties")
public class SolrConfig {
	
	@Value("${spring.data.solr.host}")
	private String solrHost;
	
	@Bean
    public SolrClient solrClient() {
		return new HttpSolrClient.Builder(solrHost).build();
	}
	
	@Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }
}
