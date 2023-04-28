package ru.otus.library.controller.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class BookController {

  @GetMapping("test")
  public String createUserView() {

    return "book";
  }
}
