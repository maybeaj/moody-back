package mood.diary.back.posts.domain;

import lombok.Data;

@Data
public class PostsResponseDTO {
    private int id;
    private String content;
    private String mood;
    private String date;
    private String image_url;
}
