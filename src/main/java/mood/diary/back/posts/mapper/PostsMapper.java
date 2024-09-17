package mood.diary.back.posts.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import mood.diary.back.posts.domain.PostsRequestDTO;
import mood.diary.back.posts.domain.PostsResponseDTO;

@Mapper
public interface PostsMapper {

    public void savePost(PostsRequestDTO params);

    public List<PostsResponseDTO> getPost(); //모든 포스트들 불러오기

    public void updatePost(PostsRequestDTO params);

    public PostsResponseDTO selectPost(Map<String, Integer> map); // id로 포스트 가져오기

    public void deletePost(Map<String, Integer> map); 
}
