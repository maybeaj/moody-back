package mood.diary.back.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mood.diary.back.posts.domain.PostsRequestDTO;
import mood.diary.back.posts.domain.PostsResponseDTO;
import mood.diary.back.posts.mapper.PostsMapper;

@Service
public class PostsService {
    
    @Autowired
    private PostsMapper postsMapper;

    public void save(PostsRequestDTO params) {
        System.out.println("debug >>> service save" + postsMapper);
        postsMapper.savePost(params);
    }

    public void update(PostsRequestDTO params) {
        System.out.println("debug >>> service update" + postsMapper);
        postsMapper.updatePost(params);    
    }

    public void delete(Map<String, Integer> map) {
        System.out.println("debug >>> service delete" + map.get("id"));
        postsMapper.deletePost(map);    
    }

    public List<PostsResponseDTO> list(){
        System.out.println("debug >>> service list");
        return postsMapper.getPost();
    }

    public PostsResponseDTO select(Map<String, Integer> map){

        PostsResponseDTO result = postsMapper.selectPost(map);
        System.out.println("debug >>>> service result " + result);

        return result; 
    }
}
