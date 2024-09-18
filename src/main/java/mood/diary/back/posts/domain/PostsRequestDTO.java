package mood.diary.back.posts.domain;


import lombok.Data;



@Data
public class PostsRequestDTO {
    
    private Integer id;
    @jakarta.validation.constraints.NotNull(message = "Content cannot be null")
    private String content;
    private String mood;
    private String date;
    private String image_url;
}


