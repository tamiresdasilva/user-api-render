package br.com.ulbra.user_api_render.services;

import br.com.ulbra.user_api_render.dtos.request.PostRequestDTO;
import br.com.ulbra.user_api_render.dtos.response.PostResponseDTO;
import br.com.ulbra.user_api_render.dtos.response.PostUserResponseDTO;
import br.com.ulbra.user_api_render.entities.Post;
import br.com.ulbra.user_api_render.entities.User;
import br.com.ulbra.user_api_render.repositories.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public Post getPostById(Long id){
        return this.postRepository.findById(id).orElseThrow();
    }

    public List<PostResponseDTO> getAllPosts(){
        return this.postRepository.findAll()
                .stream()
                .map(item ->
                        new PostResponseDTO(
                                item.getContent(),
                                new PostUserResponseDTO(item.getUser().getUsername()))).toList();
    }

    public Post createPost(PostRequestDTO postRequest){
        User user = userService.getUserById(postRequest.getUserId());
        Post post = new Post();
        post.setContent(postRequest.getContent());
        post.setUser(user);
        return this.postRepository.save(post);
    }

    public Post updatePost(Post postRequest, Long id){
        Post post = this.postRepository.getReferenceById(id);
        post.setContent(postRequest.getContent());

        return this.postRepository.save(post);
    }

    public void deletePost(Long id){
        Post post = this.postRepository.findById(id).orElseThrow();
        this.postRepository.delete(post);
    }
}
