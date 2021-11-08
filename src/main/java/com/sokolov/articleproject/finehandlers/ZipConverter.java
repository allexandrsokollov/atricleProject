package com.sokolov.articleproject.finehandlers;

import com.sokolov.articleproject.entities.Article;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
@NoArgsConstructor
public class ZipConverter {

    private Article article;

    private List<StringBuilder> text;


    @Autowired
    public ZipConverter(Article article) {
        this.article = article;
    }

    public Article toArticle(File file) {
        text = ZipFileHandler.getStringListFromZip(file);
        article.setTitle(text.get(0).toString());
        StringBuilder temp = new StringBuilder();

        for(int i = 1; i < text.size(); i++) {
            temp.append(text.get(i));
        }

        article.setBody(temp.toString());

        return article;
    }
}
