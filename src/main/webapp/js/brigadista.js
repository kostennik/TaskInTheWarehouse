import {getDBTasks} from "./index.js";
import {showUserName} from "./index.js";
import {readCookie} from "./index.js";
import {checkUserName} from "./index.js";
import {preloadAnimation} from "./index.js";


function clearInputs() {
  $("#description_task").val('');
  $("#checkboxscale").removeAttr("checked");
}

function postData() {
  let datetime ={name: "datetime", value: new Date().getTime()} ;
  let data = $("#addTasks").serializeArray();
  data.push(datetime);
  console.log(data);

  $.post("api/addTasks", data, (res) => {
    console.log(res);
    getDBTasks();
    clearInputs();
  }, "json");


}

$(document).ready(() => {
  preloadAnimation();
  checkUserName();
  showUserName();
  $("#userNameForm").val(readCookie('userName'));
  $("#addTasks").submit(() => {
    return false;
  });
  $('#btnSave').click(postData);
  $('input').keydown((e) => {
    if (e.keyCode === 13) {
      console.log("push enter!");
      postData();
    }
  }); // enter brigadista
  document.onclick = (event) => {
    document.getElementById("description_task").focus();
  }; //only focus in textinput
});






