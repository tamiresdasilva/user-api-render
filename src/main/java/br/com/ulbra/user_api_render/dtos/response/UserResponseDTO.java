package br.com.ulbra.user_api_render.dtos.response;

import java.util.List;

public class UserResponseDTO {
    private String username;
    private List<UserPostResponseDTO> posts;

    public UserResponseDTO() {}

    public UserResponseDTO(String username, List<UserPostResponseDTO> posts) {
        this.username = username;
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserPostResponseDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<UserPostResponseDTO> posts) {
        this.posts = posts;
    }
}
