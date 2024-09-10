package mood.diary.back.posts.mapper;

import org.apache.ibatis.annotations.Mapper;

import mood.diary.back.posts.domain.PostsRequestDTO;

@Mapper
public interface PostsMapper {
    
    public void savePost(PostsRequestDTO params);
}
