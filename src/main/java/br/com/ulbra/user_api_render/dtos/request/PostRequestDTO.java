package br.com.ulbra.user_api_render.dtos.request;

public class PostRequestDTO {
    private Long userId;
    private String content;

    public PostRequestDTO() {}

    public PostRequestDTO(Long userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
