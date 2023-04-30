package ru.otus.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.library.dto.comment.CommentDtoRq;
import ru.otus.library.facade.book.BookFacade;
import ru.otus.library.facade.comment.CommentFacade;

@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

  private final CommentFacade commentFacade;
  private final BookFacade bookFacade;

  @PostMapping(params="action=save")
  public String create(
      @ModelAttribute CommentDtoRq rq,
      Model model
  ){
    commentFacade.create(rq);
    model.addAttribute("book", bookFacade.findById(rq.getBookId()));

    return "book";
  }

  @PostMapping(params="action=delete")
  public String deleteById(
      @ModelAttribute CommentDtoRq rq,
      Model model
  ){
    commentFacade.deleteById(rq.getId());
    model.addAttribute("book", bookFacade.findById(rq.getBookId()));

    return "book";
  }
}
