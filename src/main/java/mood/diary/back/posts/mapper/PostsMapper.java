package mood.diary.back.posts.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mood.diary.back.posts.domain.PostsRequestDTO;
import mood.diary.back.posts.domain.PostsResponseDTO;

@Mapper
public interface PostsMapper {

    public void savePost(PostsRequestDTO params);

    public List<PostsResponseDTO> selectPost();
}
