package mood.diary.back.posts.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class PostsRequestDTO {
    
    private int id;
    private String content;
    private String mood;
    private String date;
    private String image_url;
}
