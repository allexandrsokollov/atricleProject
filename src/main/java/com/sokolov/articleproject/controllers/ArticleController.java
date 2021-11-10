package com.sokolov.articleproject.controllers;

import com.sokolov.articleproject.dao.ArticleDAO;
import com.sokolov.articleproject.entities.Article;
import com.sokolov.articleproject.finehandlers.ZipConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipFile;

@Controller
public class ArticleController {

    private final ArticleDAO articleDAO;

    @Autowired
    public ArticleController(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("article", articleDAO.getAllArticles());
        return "index";
    }

    @GetMapping("/add_article")
    public String addArt() {
        return "add_article";
    }

    @PostMapping()
    public String addArticle(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        articleDAO.addNewArticle(ZipConverter.toArticle(file));
        return "redirect:/";
    }


}
