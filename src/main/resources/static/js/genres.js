function toggleGenres() {
  let genres = document.getElementById("genres");
  let authors = document.getElementById("authors");
  let books = document.getElementById("books");

  genres.style.display = "block";
  authors.style.display = "none";
  books.style.display = "none";
}

function openGenres() {
  toggleGenres()
  clearGenresTable()
  findAllGenres().done(function (data) {
    fillGenresTable(data)
  })
}

function findAllGenres() {
  return $.ajax({
    type: 'GET',
    url: "/genres"
  });
}

function deleteGenreById(id) {
  $.ajax({
    type: 'DELETE',
    url: "/genres/" + id
  });
}

function clearGenresTable() {
  $("#genres_table").empty();
}

function fillGenresTable(data) {
  $(function() {
    $.each(data, function(i, item) {
      $('<tr>')
      .append(
          $('<td>').text(item.id),
          $('<td>').text(item.name),
      ).appendTo('#genres_table');
    });
  });
}