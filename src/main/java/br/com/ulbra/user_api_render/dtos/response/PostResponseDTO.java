package br.com.ulbra.user_api_render.dtos.response;

public class PostResponseDTO {
    private String content;
    private PostUserResponseDTO user;

    public PostResponseDTO() {}

    public PostResponseDTO(String content, PostUserResponseDTO user) {
        this.content = content;
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostUserResponseDTO getUser() {
        return user;
    }

    public void setUser(PostUserResponseDTO user) {
        this.user = user;
    }
}
