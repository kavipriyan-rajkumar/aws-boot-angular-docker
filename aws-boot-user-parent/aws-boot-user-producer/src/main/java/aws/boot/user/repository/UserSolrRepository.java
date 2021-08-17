package aws.boot.user.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import aws.boot.user.entity.UserDomain;

@Repository @Qualifier("userRepository")
// @ConditionalOnProperty( prefix="database", name="connected",havingValue="solr") // working
// @ConditionalOnProperty( value="database.solr.connected",havingValue="true") // Working
// @ConditionalOnExpression("${database.solr.connected}") // working binary only [true/false]
@ConditionalOnExpression("${feature.database.solr.connected} and '${spring.profile.active}'.equalsIgnoreCase('DEV')")
public interface UserSolrRepository extends SolrCrudRepository<UserDomain, Long>,IUserBaseRepository{

}
