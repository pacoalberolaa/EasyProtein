function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}

function reedirigirProtRecomendada() {
  window.location.href = 'http://localhost:8081/proteina/1';
}

function reedirigirCreatinaRecomendado() {
  window.location.href = 'http://localhost:8081/creatinas';
}

function reedirigirGlutaminaRecomendado() {
  window.location.href = 'http://localhost:8081/aminoacidos';
}

function reedirigirMultVitRecomendado() {
  window.location.href = 'http://localhost:8081/vitaminas';
}

function reedirigirProdEstrella() {
  window.location.href = 'http://localhost:8081/proteina/3';
}


function obtenerSaborSeleccionado() {
   var selectElement = document.getElementById("sabores");
   var saborSeleccionado = selectElement.options[selectElement.selectedIndex].text;

   var radioButtons = document.getElementsByName("option");
   var cantSeleccionada;

   var sabor = document.getElementById("sabor");
   var cantidad = document.getElementById("cantidad");

   for (var i = 0; i < radioButtons.length; i++) {
       if (radioButtons[i].checked) {
            var spanElement = radioButtons[i].nextElementSibling.nextElementSibling;
            cantSeleccionada = spanElement.textContent;
       break;
       }
   }

   sabor.textContent = saborSeleccionado;
   cantidad.textContent = cantSeleccionada;

}