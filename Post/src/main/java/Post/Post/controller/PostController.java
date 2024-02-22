package Post.Post.controller;

import Post.Post.entity.Post;
import Post.Post.payload.PostDto;
import Post.Post.repository.PostRepository;
import Post.Post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/post")
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> savePost(@RequestBody Post post){

        Post newPost = postService.savePost(post);
        return  new ResponseEntity<>(newPost, HttpStatus.CREATED);

    }
    //http://localhost:8081/api/post/{postId}
@GetMapping("/{postId}")
    public Post getPostByPostId(@PathVariable String postId){
    Post post =   postService.findPostById(postId);
    return post;
    }

    //http://localhost:8081/api/post/{postId}/comment
    @GetMapping("/{postId}/comment")
    public ResponseEntity<?> getPostWithComments(@PathVariable String postId){
     PostDto postDto=   postService.getPostWithComments(postId);
     return new ResponseEntity<>(postDto,HttpStatus.OK);
    }




}
