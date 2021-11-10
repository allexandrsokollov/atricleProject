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
        return jdbcTemplate.query("SELECT TITLE, BODY FROM ARTICLE ORDER BY ID DESC", new ArticleMapper());
    }

    public void cleanUpDB() {
        jdbcTemplate.update("Drop table IF EXISTS ARTICLE");
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS ARTICLE (" +
                "id int primary key auto_increment," +
                "title varchar, body varchar )");
    }

    public void addNewArticle(Article article) {
        jdbcTemplate.update("INSERT INTO ARTICLE (title, body) VALUES (?, ?)",
                article.getTitle(), article.getBody());
    }

    public void testAddition() {

        List<Article> testData = new ArrayList<>();

        testData.add(new Article("Twitter poll calls on Elon Musk to sell 10% stake in Tesla", "Voters in a Twitter poll have urged Elon Musk to sell 10% of his stake in Tesla in order to pay tax.\n" +
                "\n" +
                "More than 3.5 million Twitter users voted in the poll, launched by Mr Musk on Saturday, with nearly 58% voting in favour of the share sale.\n" +
                "\n" +
                "The vote could see him dispose of nearly $21bn (£16bn) of stock in the electric carmaker.\n" +
                "\n" +
                "He has promised to abide by the result, in response to a \"billionaires tax\" proposed by US Democrats.\n" +
                "\n" +
                "But Mr Musk, one of the world's richest men, has yet to comment publicly on the verdict, or how and when he would sell his stake.\n" +
                "\n" +
                "Should he go ahead with the sale, it could leave him with a huge tax bill."));

        testData.add(new Article("Thousands of phone boxes to be saved from closure", "Ofcom, the UK telecoms regulator, said it will stop BT from closing down 5,000 phone boxes in areas with poor mobile signals or high accident rates, if they are still needed by local communities.\n" +
                "\n" +
                "The watchdog said that without such protection, some - which are considered \"vital\" - would still have been closed.\n" +
                "\n" +
                "For the past few years BT has been decommissioning unused payphones.\n" +
                "\n" +
                "Now a phone box will be saved if:\n" +
                "\n" +
                "It is located at an accident or suicide hotspot.\n" +
                "More than 52 calls have been made from it over the past 12 months.\n" +
                "Exceptional circumstances mean there is a need for a public call box.\n" +
                "Its location is not already covered by all four mobile networks.\n" +
                "At their peak, there were around 92,000 phone boxes in the UK, but now 96% of UK adults own a mobile phone."));
        for(Article a : testData) {
            jdbcTemplate.update("INSERT INTO ARTICLE (title, body) VALUES (?, ?)",
                    a.getTitle(), a.getBody());
        }

    }
}
