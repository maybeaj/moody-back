package mood.diary.back;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mood.diary.back.posts.domain.PostsRequestDTO;
import mood.diary.back.service.PostsService;

@SpringBootTest
public class ServiceApplicationTests {
    
    @Autowired
    private PostsService postsService;

        @Test
        public void saveService() {
        System.out.println("debug >>> junit service save " + postsService);
        PostsRequestDTO request = PostsRequestDTO.builder().content("easypeasylemonsqueezy").mood("happy").date("2024-09-17").build();
        postsService.save(request);
        System.out.println("debug >>> save!");
    }

        @Test
        public void updateService() {
        System.out.println("debug >>> junit service update " + postsService);
        PostsRequestDTO request = PostsRequestDTO.builder().id(2).content("hungry").mood("insane").date("2024-09-17").build();
        postsService.update(request);
        System.out.println("debug >>> update!");
    }
}
