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

    //private final JdbcTemplate jdbcTemplate;
    private List<Article>  arts = new ArrayList<>();

    {
        arts.add(new Article("title_title",
                "ArticleBody_ArticleBody_ArticleBody_\nArticleBody_ArticleBody_ArticleBody_"));
        arts.add(new Article("title_title",
                "ArticleBody_ArticleBody_ArticleBody_\nArticleBody_ArticleBody_ArticleBody_"));
        arts.add(new Article("title_title",
                "ArticleBody_ArticleBody_ArticleBody_\nArticleBody_ArticleBody_ArticleBody_"));
        arts.add(new Article("title_title",
                "ArticleBody_ArticleBody_ArticleBody_\nArticleBody_ArticleBody_ArticleBody_"));



    }
//    @Autowired
//    public ArticleDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }


    public List<Article> getArts() {
        return arts;
    }

//    public List<Article> getAllArticles() {
//        return jdbcTemplate.query("SELECT TITLE, BODY FROM ARTICLE", new ArticleMapper());
//    }
}
