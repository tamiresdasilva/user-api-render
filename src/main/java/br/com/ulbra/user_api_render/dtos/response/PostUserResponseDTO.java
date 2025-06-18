package br.com.ulbra.user_api_render.dtos.response;

public class PostUserResponseDTO {
    private String username;

    public PostUserResponseDTO() {}

    public PostUserResponseDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
