package com.sokolov.articleproject.finehandlers;

import com.sokolov.articleproject.FileHandlingAndFormatException.AmountOfFilesException;
import com.sokolov.articleproject.FileHandlingAndFormatException.FileFormatException;
import com.sokolov.articleproject.FileHandlingAndFormatException.FileNameException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Component
@NoArgsConstructor
public class ZipFileHandler {

    static  List<StringBuilder> getStringListFromZip(MultipartFile file) throws Exception {


        if(!file.getOriginalFilename().endsWith(".zip")) {
            throw new FileFormatException("Wrong file format. Zip only allowed");
        }

        List<StringBuilder> dataToReturn = new ArrayList<>();



        InputStream is = new ByteArrayInputStream(file.getBytes());

        try(ZipInputStream zin = new ZipInputStream(is)) {

            ZipEntry entry;
            StringBuilder temp = new StringBuilder();
            boolean isThisFirstEntry = true;

            while (( entry = zin.getNextEntry()) != null) {

                if(!isThisFirstEntry) {
                    throw new AmountOfFilesException("too many files. 1 is max amount");
                }

                isThisFirstEntry = false;

                if(!entry.getName().equals("article.txt")) {
                    throw new FileNameException(entry.getName() + " is Wrong name");
                }


                byte[] bytes = new byte[1];

                while (zin.read(bytes, 0, bytes.length) != -1) {
                    temp.append(new String(bytes, Charset.defaultCharset()));
                }

                StringBuilder tm = new StringBuilder();

                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) == '\r')
                        i++;

                    if (temp.charAt(i) == '\n') {
                        dataToReturn.add(new StringBuilder(tm.append("\r\n")));
                        tm.delete(0, tm.length());
                        continue;
                    }

                    tm.append(temp.charAt(i));
                }

                temp.delete(0, temp.length());
            }

            zin.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataToReturn;
    }
}
