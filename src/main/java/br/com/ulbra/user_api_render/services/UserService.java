package br.com.ulbra.user_api_render.services;

import br.com.ulbra.user_api_render.dtos.response.UserPostResponseDTO;
import br.com.ulbra.user_api_render.dtos.response.UserResponseDTO;
import br.com.ulbra.user_api_render.entities.User;
import br.com.ulbra.user_api_render.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id){
        return this.userRepository.findById(id).orElseThrow();
    }

    public Page<UserResponseDTO> getAllUsers(Pageable pageable){
        return this.userRepository.findAll(pageable).map(u ->
                new UserResponseDTO(u.getUsername(),
                        u.getPosts().stream().map(posts -> new UserPostResponseDTO(posts.getContent())).toList()));
    }

    public User createUser(User user){
        return this.userRepository.save(user);
    }

    public User updateUser(User userRequest, Long id){
        User user = this.userRepository.getReferenceById(id);
        user.setUsername(userRequest.getUsername());

        return this.userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = this.userRepository.findById(id).orElseThrow();
        this.userRepository.delete(user);
    }
}
