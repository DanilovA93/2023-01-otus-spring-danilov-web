package ru.otus.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.service.book.BookService;
import ru.otus.library.service.comment.CommentService;

@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

  private final CommentService commentService;
  private final BookService bookService;

  @PostMapping(params="action=save")
  public String create(
      @ModelAttribute CommentDtoRq rq,
      Model model
  ){
    commentService.save(rq);
    model.addAttribute("book", bookService.findById(rq.getBookId()));

    return "book";
  }

  @PostMapping(params="action=delete")
  public String deleteById(
      @ModelAttribute CommentDtoRq rq,
      Model model
  ){
    commentService.delete(rq.getId());
    model.addAttribute("book", bookService.findById(rq.getBookId()));

    return "book";
  }
}
