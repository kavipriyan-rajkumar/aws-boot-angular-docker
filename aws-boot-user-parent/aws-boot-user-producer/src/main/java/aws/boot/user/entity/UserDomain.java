package aws.boot.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
/** Solr **/
@SolrDocument(collection = "userSolrCore")
/** JPA **/
@Entity @Table(name = "USERS")
public class UserDomain implements Serializable{
	private static final long serialVersionUID = -1606890723333666608L;
	
	/** Solr **/
	@Id  @Field @Indexed(name = "userId", type = "long")
	/** JPA **/
	@GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "userId")
	private Long userId;
	
	@Field @Indexed(name = "userName", type = "string")
	@Column(name = "userName")
	private String userName;
}