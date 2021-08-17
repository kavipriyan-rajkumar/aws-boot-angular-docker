package aws.boot.user.repository;

import org.springframework.data.repository.CrudRepository;

import aws.boot.user.entity.UserDomain;

public interface IUserBaseRepository extends CrudRepository<UserDomain, Long>{

}
