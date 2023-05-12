function toggleAuthors() {
  let authors = document.getElementById("authors");
  let genres = document.getElementById("genres");
  let books = document.getElementById("books");

  authors.style.display = "block";
  genres.style.display = "none";
  books.style.display = "none";
}

function openAuthors() {
  toggleAuthors()
  clearAuthorsTable()
  this.findAllAuthors().done(function (data) {
    fillAuthorsTable(data)
  })
}

function findAllAuthors() {
  return $.ajax({
    type: 'GET',
    url: "/authors"
  });
}

function deleteAuthorById(id) {
  return  $.ajax({
    type: 'DELETE',
    url: "/authors/" + id
  });
}

function clearAuthorsTable() {
  $("#authors_table").empty();
}

function fillAuthorsTable(data) {
  $(function() {
    $.each(data, function(i, item) {
      $('<tr>')
      .append(
          $('<td>').text(item.id),
          $('<td>').text(item.name),
      ).appendTo('#authors_table');
    });
  });
}