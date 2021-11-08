package com.sokolov.articleproject.dao;

import com.sokolov.articleproject.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Article> getAllArticles() {
        return jdbcTemplate.query("SELECT TITLE, BODY FROM ARTICLE", new ArticleMapper());
    }


}
