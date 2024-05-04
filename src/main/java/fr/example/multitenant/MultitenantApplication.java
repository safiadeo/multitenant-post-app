package fr.example.multitenant;

import com.github.javafaker.Faker;
import fr.example.multitenant.post.Post;
import fr.example.multitenant.post.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MultitenantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultitenantApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(final PostRepository postRepository) {
        return args -> {
            final Faker faker = new Faker();
            for (int i = 1; i < 4; i++) {

                final Post post = Post.builder()
                        .title(faker.job().title())
                        .content(faker.company().bs())
                        .tenantId(String.format("TENANT-%s", i))
                        .build();

                postRepository.save(post);
            }
        };
    }
}
