package com.sokolov.articleproject.controllers;

import com.sokolov.articleproject.FileHandlingAndFormatException.AmountOfFilesException;
import com.sokolov.articleproject.FileHandlingAndFormatException.MyFileExceptions;
import com.sokolov.articleproject.dao.ArticleDAO;
import com.sokolov.articleproject.entities.Article;
import com.sokolov.articleproject.finehandlers.ZipConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String mainPage(@RequestParam(value = "addTestData",  required = false, defaultValue = "false") boolean bl,
                           @RequestParam(value = "cleanup", required = false, defaultValue = "false") boolean clUp,
                           Model model) {
        model.addAttribute("article", articleDAO.getAllArticles());

        if (bl) {
            return "redirect:/tadd";
        }
        if (clUp) {
            return "redirect:/clean";
        }
        return "index";
    }

    @GetMapping("/tadd")
    public String testAddi() {
        articleDAO.testAddition();
        return "redirect:/";
    }

    @GetMapping("/clean")
    public String clean() {
        articleDAO.cleanUpDB();
        return "redirect:/";
    }





    @GetMapping("/add_article")
    public String addArt(@RequestParam(value = "error", required = false) String error, Model model) {
        model.addAttribute("error", error);
        return "add_article";
    }

    @PostMapping()
    public String addArticle(@RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            articleDAO.addNewArticle(ZipConverter.toArticle(file));
        } catch (Exception e) {
            return "redirect:/add_article?error=" + e.getMessage();
        }
        return "redirect:/";
    }


}
