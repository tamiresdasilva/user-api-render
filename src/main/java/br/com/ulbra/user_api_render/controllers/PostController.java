package br.com.ulbra.user_api_render.controllers;

import br.com.ulbra.user_api_render.dtos.request.PostRequestDTO;
import br.com.ulbra.user_api_render.dtos.response.PostResponseDTO;
import br.com.ulbra.user_api_render.entities.Post;
import br.com.ulbra.user_api_render.services.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostResponseDTO> getAllPosts() {
        return this.postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return this.postService.getPostById(id);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequestDTO postRequest) {
        Post post = this.postService.createPost(postRequest);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(uri).body(post);
    }
}
