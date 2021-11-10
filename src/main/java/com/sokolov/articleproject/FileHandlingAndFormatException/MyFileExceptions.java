package com.sokolov.articleproject.FileHandlingAndFormatException;

public class MyFileExceptions extends  Exception{
    public MyFileExceptions() {
    }

    public MyFileExceptions(String message) {
        super(message);
    }

    public MyFileExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public MyFileExceptions(Throwable cause) {
        super(cause);
    }
}
