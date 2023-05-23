function toggleBooks() {
  let books = document.getElementById("books");
  let authors = document.getElementById("authors");
  let genres = document.getElementById("genres");

  books.style.display = "block";
  authors.style.display = "none";
  genres.style.display = "none";
}

function refreshTable() {
  clearBooksTable()
  this.findAllBooks().done(function (data) {
    fillBooksTable(data)
  })
}

function openBooks() {
  toggleBooks()
  refreshTable()
}

function deleteBookAndUpdateTable(id) {
  this.deleteBookById(id).done(function () {
    refreshTable()
  })
}

function findAllBooks() {
  return $.ajax({
    type: 'GET',
    url: "/books"
  });
}

function deleteBookById(id) {
  return  $.ajax({
    type: 'DELETE',
    url: "/books/" + id
  });
}

function clearBooksTable() {
  $("#books_table").empty();
}

function fillBooksTable(data) {
  $(function() {
    $.each(data, function(i, item) {
      $('<tr>')
      .append(
          $('<td>').text(item.id),
          $('<td>').text(item.name),
          $('<td>').text(item.author.name),
          $('<td>').text(item.genre.name),
          $('<button>')
          .text("Delete")
          .on("click", function() {
            deleteBookAndUpdateTable(item.id)
          })
      ).appendTo('#books_table');
    });
  });
}