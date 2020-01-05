let FREQ = 10000; //interval to update
// let username = readCookie("username");
let repeat = true; //repeat auto-update


export function getDBTasks() {
  console.log("upload page...");
  $.getJSON("/api/tasks", (json) => {
    console.log(json);
    if (json.length > 0) {
      console.log("refresh..(in getDBTasks)");
      $("#table").empty();
      $("div#divInfo").children()
        .html("Aktywne zadania:")
        .attr('id', 'info');
      fillingTable(json); //
    } else {
      $("#table").empty();
      $("div#divInfo").children()
        .html("Brak aktywnych zadań &#9749;")
        .attr('id', 'brak_dokumentow');
    }
  }).fail(function () {
    console.log("error");
  });
}

export function writeCookie(name, value, days) {
// By default, there is no expiration so the cookie is temporary
  let expires = "";
// Specifying a number of days makes the cookie persistent
  if (days) {
    let date = new Date();
    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
    expires = "; expires=" + date.toGMTString();
  }
// Set the cookie to the name, value, and expiration date
  document.cookie = name + "=" + value + expires + "; path=/";
}

export function showUserName() {
  let userName = readCookie('userName');
  let userType = readCookie('userType');
  if (userName != null) {
    $("#welcome").html("Witam, " + userType + '<strong> ' + userName + '</strong>');
  } else {
    $("#welcome").html("Witam, user!");
  }
}

export function readCookie(name) {
// Find the specified cookie and return its value
  let searchName = name + "=";
  let cookies = document.cookie.split(';');
  for (let i = 0; i < cookies.length; i++) {
    let c = cookies[i];
    while (c.charAt(0) == ' ')
      c = c.substring(1, c.length);
    if (c.indexOf(searchName) == 0)
      return c.substring(searchName.length, c.length);
  }
  return null;
}

function fillingTable(json) {
  let timeFromDB;
  let tmp =
    '<tr>' +
    '<th>Opis</th>' +
    '<th id="time_th">Dodano</th>' +
    '<th width="20px">Ilość</th>' +
    '</tr>';
  $("#table").append(tmp);

  $.each(json, function () { //don`t change on =>!
    let tr = '<tr id=' + this.id + '>'; //set id
    timeFromDB = this.datetime;
    if (this.priority === 'yes') {
      tr = '<tr id="' + this.id + '" class="priority">'; //set id $ class
    }
    let tmp =
      tr +
      '<td>' + '<em>' + this.username + ': </em>' + this.descriptionTask + '</td>' +
      '<td class="timeAgo">' + timeAgoShow(this.datetime) + '</td>' +   //time!!!!!!!!!!!!!!!
      '<td>' + this.quantity + '</td>' +
      '</tr>';
    $("#table").append(tmp);

    //hidden time age for brigadista
    if (document.location.pathname.match(/[^\/]+$/)[0] === 'brigadista.html') {
      $('table td:nth-of-type(2),table th:nth-of-type(2)').hide(); //hide time age
    }

  });
}

/**
 * Shows the time in minutes from the start of the task
 * @param datetime the time from server (Data Base)
 * @returns {string} how many time age
 */
function timeAgoShow(datetime) {
  let timeNow = new Date().getTime(); //time from client browser in milliseconds
  console.log(datetime);
  console.log(timeNow);
  let timeServer = datetime; //time from DataBase in milliseconds
  let difference = Math.floor((timeNow - timeServer) / 1000 / 60);
  return difference + ' minut temu';
}

function startAJAXcalls() {
  if (repeat) {
    setTimeout(() => {
        getDBTasks();
        startAJAXcalls();
      }, FREQ //constant
    );
  }
}

function eraseCookie(name) {
  writeCookie(name, "", -1);
}

/**
 * If the username does not exist redirect to index.html.
 */
export function checkUserName() {
  if (readCookie('userName') == null) {
    window.location.href = "index.html";
  }
}

Date.prototype.toString = () => {
  return this.getDate() + "/" + (this.getMonth() + 1) + "/" + this.getFullYear();
};

$(document).ready(() => {
  getDBTasks();
  startAJAXcalls();
  window.onblur = () => {
    repeat = false;
  };
  window.onfocus = () => {
    repeat = true;
    startAJAXcalls();
  };

  //if user click 'logout' - delete cookie
  $("#logout").click(() => {
    eraseCookie('userName');
    eraseCookie('userType');
  })
});

