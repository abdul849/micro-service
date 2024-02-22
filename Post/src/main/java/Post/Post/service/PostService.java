package Post.Post.service;

import Post.Post.config.RestTemplateConfig;
import Post.Post.entity.Post;
import Post.Post.payload.PostDto;
import Post.Post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private RestTemplateConfig restTemplate;
    @Autowired
    private PostRepository postRepository;


    public Post savePost(Post post){
        String postId = UUID.randomUUID().toString();
        post.setId(postId);

        Post save = postRepository.save(post);
        return save;
    }

    public Post findPostById(String postId) {
       Post post = postRepository.findById(postId).get();

        return post;
    }

    public PostDto getPostWithComments(String postId) {
        Post post = postRepository.findById(postId).get();
        ArrayList comments = restTemplate.getrestTemplate().getForObject("http://localhost:8082/api/comments/" + postId, ArrayList.class);
   PostDto postDto=new PostDto();
   postDto.setPostId(post.getId());
   postDto.setTitle(post.getTitle());
   postDto.setDescription(post.getDescription());
   postDto.setContent(post.getContent());
   postDto.setComments(comments);
   return postDto;
    }
}
