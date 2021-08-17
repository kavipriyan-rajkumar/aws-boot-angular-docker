package aws.boot.user.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Repository;

import aws.boot.user.entity.UserDomain;

@Repository @Qualifier("userRepository")
// @ConditionalOnProperty(prefix="database", name="connected", havingValue="skeleton", matchIfMissing = true) // working
//this will be default implementation if no value is matching
// @ConditionalOnProperty( value="database.skeleton.connected",havingValue="true") // working
// @ConditionalOnExpression("${database.skeleton.connected}") // working only for binary true/false
@ConditionalOnExpression("${feature.database.skeleton.connected}") // and '${spring.profile.active}'.equalsIgnoreCase('DEV')
public class UserSkeletonRepository implements IUserSkeletonRepository{

	private Map<Long,UserDomain> usersMap = new HashMap<Long,UserDomain>();
	
	@PostConstruct
	private void initializeUsers() {
		UserDomain userDomain = new UserDomain();
		Long userId = Long.valueOf(1);
		userDomain.setUserId(userId);
		userDomain.setUserName("Rajkumar");
		usersMap.put(userId, userDomain);
	}
	@Override
	public Iterable<UserDomain> findAll() {
		return new ArrayList<UserDomain>(usersMap.values());
	}
	
	@Override
	public Optional<UserDomain> findById(Long id) {
		return null;
	}
	@Override
	public boolean existsById(Long id) {
		return false;
	}
	
	@Override
	public Iterable<UserDomain> findAllById(Iterable<Long> ids) {
		return null;
	}
	@Override
	public long count() {
		return 0;
	}
	@Override
	public void deleteById(Long id) {
		
	}
	@Override
	public void delete(UserDomain entity) {
	
	}
	@Override
	public void deleteAll() {
	}
	
	@Override
	public <S extends UserDomain> S save(S entity) {
		return null;
	}
	@Override
	public <S extends UserDomain> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}
	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
	}
	@Override
	public void deleteAll(Iterable<? extends UserDomain> entities) {
	}

}
