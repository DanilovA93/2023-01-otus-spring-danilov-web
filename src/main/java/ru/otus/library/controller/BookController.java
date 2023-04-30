package ru.otus.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.library.dto.book.BookDtoRq;
import ru.otus.library.facade.author.AuthorFacade;
import ru.otus.library.facade.book.BookFacade;
import ru.otus.library.facade.genre.GenreFacade;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final static String BOOKS_PAGE = "books";
  private final static String BOOK_PAGE = "book";
  private final BookFacade bookFacade;
  private final AuthorFacade authorFacade;
  private final GenreFacade genreFacade;

  @GetMapping("{id}")
  public String findOne(
      @PathVariable Long id,
      Model model
  ){
    model.addAttribute("book", bookFacade.findById(id));
    return BOOK_PAGE;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("books", bookFacade.findAll());
    fillSecondary(model);
    return BOOKS_PAGE;
  }

  @PostMapping(params="action=save")
  public String save(
      @ModelAttribute BookDtoRq rq,
      Model model
  ){
    bookFacade.save(rq);
    model.addAttribute("books", bookFacade.findAll());
    fillSecondary(model);
    return BOOKS_PAGE;
  }

  @PostMapping(params="action=delete")
  public String delete(
      @ModelAttribute BookDtoRq rq,
      Model model
  ){
    bookFacade.deleteById(rq.getId());
    model.addAttribute("books", bookFacade.findAll());
    fillSecondary(model);
    return BOOKS_PAGE;
  }

  private void fillSecondary(Model model) {
    model.addAttribute("authors", authorFacade.findAll());
    model.addAttribute("genres", genreFacade.findAll());
  }
}
