function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
//
//function search() {
//  // Obtener el valor del input de búsqueda
//  var input = document.querySelector('.search-bar input');
//  var searchText = input.value;
//
//  // Obtener todos los elementos divProteins
//  var proteins = document.querySelectorAll('.divProteins');
//
//  // Ocultar todos los elementos divProteins que no coincidan con el texto de búsqueda
//  for (var i = 0; i < proteins.length; i++) {
//    var proteinName = proteins[i].querySelector('p:first-child').innerText;
//    if (proteinName.toLowerCase().includes(searchText.toLowerCase())) {
//      proteins[i].style.display = 'block';
//    } else {
//      proteins[i].style.display = 'none';
//    }
//  }
//}


function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}