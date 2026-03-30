package com.example.post.repository;


import com.example.post.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {
    private final JdbcTemplate jdbcTemplate;

    public PostRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Post> postRowMapper = (rs, rowNum) -> {
        Post post = new Post();
        post.setId(rs.getLong("id"));
        post.setTitle(rs.getString("title"));
        post.setContent(rs.getString("content"));
        post.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        post.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
        return post;
    };

    public List<Post> findAll(){
        return jdbcTemplate.query("SELECT * FROM posts",postRowMapper);
    }

    public Post findById(Long id){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM posts WHERE id = ?",postRowMapper, id);
    };

    public int save(Post post){
        return jdbcTemplate.update("\n" +
                "\n" +
                "INSERT INTO posts" +
                " (title, content, created_at, updated_at)" +
                " VALUES (?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)"
                ,post.getTitle(),post.getContent());
    };

    public int update(Long id, Post post){
        return jdbcTemplate.update("UPDATE posts SET title = ?, content = ?," +
                "updated_at = CURRENT_TIMESTAMP WHERE id = ?"
                ,post.getTitle(), post.getContent(), id);
    }

    public int delete(Long id){
        return jdbcTemplate.update("DELETE FROM posts WHERE id = ?",id);
    }
}
