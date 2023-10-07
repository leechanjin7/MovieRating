//header 장르 고르기버튼
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

//찜하기 버튼
let steamed = document.querySelector("button.steamed");
let opacity = 1;

function handleClick() {
  if (opacity === 1) {
    opacity = 0.5;
  } else {
    opacity = 1;
    alert("장바구니에 영화가 담겼습니다.");
  }
  steamed.style.opacity = opacity;
}

steamed.addEventListener("click", handleClick);

//리뷰쓰기 나타나는 버튼

let reviewWriteButton = document.querySelector("div.review_intro_button > a");
let reviewInputForm = document.querySelector("div.review_input_form");

function toggleReviewInputForm() {
  let currentDisplay = window
    .getComputedStyle(reviewInputForm)
    .getPropertyValue("opacity");

  if (currentDisplay === "1") {
    reviewInputForm.style.opacity = "0";
    reviewWriteButton.textContent = "리뷰 쓰기";
  } else {
    reviewInputForm.style.opacity = "1";
    reviewWriteButton.textContent = "리뷰 닫기";
  }
}
reviewWriteButton.addEventListener("click", toggleReviewInputForm);
