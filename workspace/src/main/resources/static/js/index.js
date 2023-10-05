const genres = document.getElementsByClassName("genre_pop");
const genre_btns = document.getElementsByClassName("genre_button");

for (let i = 0; i < genre_btns.length; i++) {
  genre_btns[i].addEventListener("click", function () {
    if (genres[i].style.display === "block") {
      genres[i].style.display = "none";
    } else {
      genres[i].style.display = "block";
    }
  });
}
