package mood.diary.back.posts.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import mood.diary.back.posts.domain.PostsRequestDTO;
import mood.diary.back.posts.domain.PostsResponseDTO;
import mood.diary.back.service.PostsService;

@RestController
@RequestMapping("mood")
public class PostsController {

    @Autowired
    private PostsService postsService;
    
    // 목록 조회
    @GetMapping("/list")
    @Operation(summary = "게시글 목록 조회", description = "게시글 목록을 조회한다.")
    public ResponseEntity<List<PostsResponseDTO>> getList() {
        System.out.println("debug >>> posts controller client path /list");
        List<PostsResponseDTO> list = postsService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    
    // id 기준 데이터 조회
    @GetMapping("/select/{id}")
    @Operation(summary = "게시글 조회", description = "게시글 키 값(id)을 가지고 조회한다.")
    public ResponseEntity<Object> select(@PathVariable Integer id) {
        System.out.println("debug >>> posts controller client path /select");
        System.out.println("debug >>> id param value " + id);

        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        PostsResponseDTO response = postsService.select(map);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("게시글이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/post")
    @Operation(summary = "게시글 작성", description = "게시글을 작성한다.")
    public ResponseEntity<PostsRequestDTO> save(PostsRequestDTO params) {
        System.out.println("debug>>>> posts controller client path /post");
        System.out.println(">>>>request dto, " + params);
        postsService.save(params);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    @PutMapping("/update")
    @Operation(summary = "게시글 수정", description = "게시글 키 값(id)을 가지고 수정한다.")
    public ResponseEntity<Void> update(PostsRequestDTO params) {
        System.out.println("debug >>> posts controller client path /update");
        System.out.println(">>>>> request dto, " + params);
        postsService.update(params);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "게시글 삭제", description = "게시글 키 값(id)을 가지고 삭제한다.")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        System.out.println("debug >>> posts controller client path /delete");
        System.out.println("debug >>> id param value " + id);

        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        postsService.delete(map);
        return new ResponseEntity<String>(id + "번째 데이터 삭제 ", HttpStatus.OK);
    }
}
