import {getDBTasks} from "./index.js";
import {showUserName} from "./index.js";
import {checkUserName} from "./index.js";

function deleteElementFromServer(parentID) {
  if (confirm("Delete task?")) {
    $('#' + parentID).fadeOut(150).fadeIn(150).fadeOut(150).delay(500); //this code was modified!!

    let elemToRemove = {elemToRemove: parentID};
    console.log("click delete...");
    console.log(elemToRemove);
    console.log(parentID);


    $.post("/api/deleteTask", elemToRemove, (json) => {
        console.log(json.message);
    }, "json");
  }
}

$(document).ready(function () {

  preloadAnimation();
  console.log("fakeloader");
  console.log("pkoekdo");
  checkUserName();
  showUserName();
  console.log("operator");

  $("#table").on('click', function (e) {

    let children = e.target;
    let parent = children.parentNode;
    let parentID = parent.id;
    deleteElementFromServer(parentID);
    // getDBTasks();

  });

});

