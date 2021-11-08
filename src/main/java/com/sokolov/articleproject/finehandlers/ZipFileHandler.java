package com.sokolov.articleproject.finehandlers;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Component
@NoArgsConstructor
public class ZipFileHandler {

    static  List<StringBuilder> getStringListFromZip(File file) {

        List<StringBuilder> dataToReturn = new ArrayList<>();

        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(file))) {

            ZipEntry entry;
            StringBuilder temp = new StringBuilder();

            while ((zin.getNextEntry()) != null) {

                byte[] bytes = new byte[1];

                while (zin.read(bytes, 0, bytes.length) != -1) {
                    temp.append(new String(bytes, Charset.defaultCharset()));
                }

                dataToReturn.add(new StringBuilder(temp));
                temp.delete(0, temp.length());
            }

            zin.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataToReturn;
    }
}
