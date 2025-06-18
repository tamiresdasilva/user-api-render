package br.com.ulbra.user_api_render.repositories;

import br.com.ulbra.user_api_render.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
