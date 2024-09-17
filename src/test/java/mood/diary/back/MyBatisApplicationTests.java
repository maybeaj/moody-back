package mood.diary.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mood.diary.back.posts.domain.PostsRequestDTO;
import mood.diary.back.posts.domain.PostsResponseDTO;
import mood.diary.back.posts.mapper.PostsMapper;

@SpringBootTest
public class MyBatisApplicationTests {

    @Autowired
    private PostsMapper postsMapper;

    @Test
    public void saveTest() {
        System.out.println("debug mapper >>> " + postsMapper);
        PostsRequestDTO request = PostsRequestDTO.builder().content("easy").mood("sad").date("2024.09.10").build();

        postsMapper.savePost(request);
        System.out.println("dubug >>>>> sucess!");

    }

    @Test
    public void getTest() {
        System.out.println("debug mapper >>> " + postsMapper);
        List<PostsResponseDTO> list = postsMapper.getPost();
        for(PostsResponseDTO dto : list) {
            System.out.println(dto);
        }
    }

    @Test
    public void selectTest() {
        System.out.println("debug mapper >>>" + postsMapper);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", 2);
        PostsResponseDTO response = postsMapper.selectPost(map);
        System.out.println("debug >>> select one post" + response);
    }

    @Test
    public void deleteTest() {
        System.out.println("debug mapper >>> " + postsMapper);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", 2);
        postsMapper.deletePost(map);
        System.out.println("debug >>> delete ok!");
    }
}
