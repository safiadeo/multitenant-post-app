package fr.example.multitenant.post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // TODO secure retrieving posts (get only tenant posts)
    List<Post> findByTenantId(final String tenantId);
}
