package br.com.ulbra.user_api_render.dtos.response;

public class UserPostResponseDTO {
    private String content;

    public UserPostResponseDTO() {}

    public UserPostResponseDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
