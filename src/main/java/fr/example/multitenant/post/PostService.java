package fr.example.multitenant.post;

import fr.example.multitenant.tenant.TenantContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    public List<Post> getAllPosts() {
        return postRepository.findByTenantId(TenantContextHolder.getCurrentTenant());
    }

}
