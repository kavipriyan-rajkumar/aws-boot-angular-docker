package aws.boot.user.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aws.boot.user.entity.UserDomain;

@Repository @Qualifier("userRepository")
@ConditionalOnProperty(name="connected.database", havingValue="mysql")
public interface UserJPARepository extends JpaRepository<UserDomain, Long>, UserJPARepositoryCustom, IUserBaseRepository {

}