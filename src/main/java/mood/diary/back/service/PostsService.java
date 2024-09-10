package mood.diary.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mood.diary.back.posts.mapper.PostsMapper;

@Service
public class PostsService {
    
    @Autowired
    private PostsMapper postsMapper;
}
