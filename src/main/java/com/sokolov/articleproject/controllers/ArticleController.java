package com.sokolov.articleproject.controllers;

import com.sokolov.articleproject.dao.ArticleDAO;
import com.sokolov.articleproject.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {

    private final ArticleDAO articleDAO;

    @Autowired
    public ArticleController(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("article", articleDAO.getArts());
        return "index";
    }
}
