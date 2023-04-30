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
import ru.otus.library.service.genre.GenreService;

@Controller
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

  private final static String GENRES_PAGE = "genres";
  private final GenreService genreService;

  @PostMapping(params="action=save")
  public String save(
      @ModelAttribute GenreDtoRq rq,
      Model model
  ){
    genreService.save(rq);
    model.addAttribute("genres", genreService.findAll());
    return GENRES_PAGE;
  }

  @GetMapping
  public String findAll(Model model) {
    List<GenreDtoRs> genres = genreService.findAll();
    model.addAttribute("genres", genres);
    return GENRES_PAGE;
  }

  @PostMapping(value = "{id}", params="action=delete")
  public String delete(
      @PathVariable Long id,
      Model model
  ){
    genreService.delete(id);
    model.addAttribute("genres", genreService.findAll());
    return GENRES_PAGE;
  }
}
