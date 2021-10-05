package com.john.spring.core.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired(required = false)
    private BookService bookService;

    public void getService(){
        System.out.println(bookService);
    }
}
