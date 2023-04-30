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
import ru.otus.library.dto.genre.GenreDtoRq;
import ru.otus.library.dto.genre.GenreDtoRs;
import ru.otus.library.facade.genre.GenreFacade;

@Controller
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

  private final static String GENRES_PAGE = "genres";
  private final GenreFacade genreFacade;

  @PostMapping(params="action=save")
  public String save(
      @ModelAttribute GenreDtoRq rq,
      Model model
  ){
    genreFacade.create(rq);
    model.addAttribute("genres", genreFacade.findAll());
    return GENRES_PAGE;
  }

  @GetMapping
  public String findAll(Model model) {
    List<GenreDtoRs> genres = genreFacade.findAll();
    model.addAttribute("genres", genres);
    return GENRES_PAGE;
  }

  @PostMapping(value = "{id}", params="action=delete")
  public String delete(
      @PathVariable Long id,
      Model model
  ){
    genreFacade.deleteById(id);
    model.addAttribute("genres", genreFacade.findAll());
    return GENRES_PAGE;
  }
}
