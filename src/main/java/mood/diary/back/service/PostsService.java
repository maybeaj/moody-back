package mood.diary.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mood.diary.back.posts.domain.PostsRequestDTO;
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
}
