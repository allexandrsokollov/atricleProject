package com.sokolov.articleproject.finehandlers;

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

    static  List<StringBuilder> getStringListFromZip(MultipartFile file) throws IOException {

        List<StringBuilder> dataToReturn = new ArrayList<>();

        InputStream is = new ByteArrayInputStream(file.getBytes());

        try(ZipInputStream zin = new ZipInputStream(is)) {

            ZipEntry entry;
            StringBuilder temp = new StringBuilder();


            while ((zin.getNextEntry()) != null) {

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
