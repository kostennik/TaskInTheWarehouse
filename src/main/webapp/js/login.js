import {writeCookie} from "./index.js";
import {selectCSS} from "./index.js";
import {readCookie} from "./index.js";
import {preloadAnimation} from "./index.js";

function redirectLastPage() {
  if (readCookie('userType') != null && readCookie('userName')) {
    window.location.href = readCookie('userType') + '.html';
  }
}

$(document).ready(() => {

  preloadAnimation();
  //change style
  selectCSS();

  //Redirect to the last page.
  redirectLastPage();

  //only focus in text input
  document.onclick = (event) => {
    document.getElementById("name").focus();
  };

  //write to text input User's name from Cookies
  if (readCookie('userName')) {
    $("#name").val(readCookie('userName'));
  }

  //send data, redirect in page
  $("form").submit(function () {
    writeCookie('userName', $("#name").val(), 30);
    writeCookie('userType', $('input[name=iam]:checked').val(), 30);
    if (readCookie('userType') != null) {
      window.location.href = readCookie('userType') + '.html';
    }
    //disable standard form`s behavior
    return false;
  });
});