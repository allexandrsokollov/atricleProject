package com.sokolov.articleproject.finehandlers;

import com.sokolov.articleproject.FileHandlingAndFormatException.FileContentException;
import com.sokolov.articleproject.entities.Article;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
@NoArgsConstructor
public class ZipConverter {


    public static Article toArticle(MultipartFile file) throws Exception {
        Article article = new Article();
        List<StringBuilder> text;

        text = ZipFileHandler.getStringListFromZip(file);

        if(text.size() < 2) {
            throw new FileContentException();
        }

        article.setTitle(text.get(0).toString());
        StringBuilder temp = new StringBuilder();



        for(int i = 1; i < text.size(); i++) {
            temp.append(text.get(i));
        }

        article.setBody(temp.toString());

        return article;
    }
}
