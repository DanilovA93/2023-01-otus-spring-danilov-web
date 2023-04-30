package ru.otus.library.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.library.dto.author.AuthorDtoRq;
import ru.otus.library.dto.author.AuthorDtoRs;
import ru.otus.library.facade.author.AuthorFacade;

@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

  private final static String AUTHORS_PAGE = "authors";
  private final AuthorFacade authorFacade;

  @PostMapping(params="action=save")
  public String save(
      @ModelAttribute AuthorDtoRq rq,
      Model model
  ){
    authorFacade.create(rq);
    model.addAttribute("authors", authorFacade.findAll());
    return AUTHORS_PAGE;
  }

  @GetMapping
  public String findAll(Model model) {
    List<AuthorDtoRs> authors = authorFacade.findAll();
    model.addAttribute("authors", authors);
    return AUTHORS_PAGE;
  }

  @PostMapping(value = "{id}", params="action=delete")
  public String delete(
      @PathVariable Long id,
      Model model
  ){
    authorFacade.deleteById(id);
    model.addAttribute("authors", authorFacade.findAll());
    return AUTHORS_PAGE;
  }
}
