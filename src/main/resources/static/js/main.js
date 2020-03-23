'use strict';

const tableContainer = document.querySelector('#table-container');

const socket = new SockJS("/drt");
const stompClient = Stomp.over(socket);

stompClient.connect({}, onConnected, onError);

function onConnected() {
    stompClient.subscribe('/topic/loc', onMessageReceived);
}

function onError(error) {
    tableContainer.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    tableContainer.classList.add('error-text');
}

function onMessageReceived(payload) {
   
   let content = JSON.parse(payload.body);
   
   let contentUniqueId = content.uniqueId;
   
   let contentPrevLocation = content.prevLocation;
   
   let contentCurrLocation = content.currLocation;
   
   let contentSpeed = content.speed;
   
   let row = document.querySelector("#tr-"+contentUniqueId);
   
   let table = document.querySelector("#loc-table")
   
   if (!row) {
        row = document.createElement('tr');
        row.id = "tr="+contentUniqueId;
        row.insertCell(0).innerHTML = contentUniqueId;
        row.insertCell(1).innerHTML = contentPrevLocation;
        row.insertCell(2).innerHTML = contentCurrLocation;
        row.insertCell(3).innerHTML = contentSpeed;
        table.appendChild(row);
        setTableRowBackgroundColor(contentSpeed, row);
        return;
   }
   
   row.cells[1] = contentPrevLocation;
   row.cells[2] = contentCurrLocation;
   row.cells[3] = contentSpeed;
   setTableRowBackgroundColor(contentSpeed, row);
  
}

function setTableRowBackgroundColor(contentSpeed, row) {
    if (contentSpeed == "0.0") {
        row.classList.add('error');
    } else {
        row.classList.remove('error');
    }
}