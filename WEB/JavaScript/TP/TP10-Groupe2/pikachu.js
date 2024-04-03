//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX = 0;
var posY = 0;
var mouvement = 30;
var pokemon = "pikachu";
var direction = "Down";
imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");
inputName.onkeyup = verifContent;

function verifContent(e) {
  if (inputName.value == "") {
    btnStart.disabled = true;
  } else {
    if (e.key == "Enter") {
      partie();
    }
    btnStart.disabled = false;
  }
}
btnStart.onclick = partie;

function partie() {
  formStart.style.display = "none";
  grass.style.display = "block";
  document.body.onkeydown = deplacement;
  imgPikachu.title = inputName.value;
}

function deplacement(event) {
  if (event.key == "ArrowDown" || event.key == "s") {
    if (posY <= 630) {
      posY += mouvement;
    }

    direction = "Down";
  } else if (event.key == "ArrowRight" || event.key == "d") {
    if (posX <= 630) {
      posX += mouvement;
    }

    direction = "Right";
  } else if (event.key == "ArrowLeft" || event.key == "q") {
    if (posX > 0) {
      posX -= mouvement;
    }

    direction = "Left";
  } else if (event.key == "ArrowUp" || event.key == "z") {
    if (posY > 0) {
      posY -= mouvement;
    }

    direction = "Up";
  }

  pikachu.style.top = posY + "px";
  pikachu.style.left = posX + "px";
  imgPikachu.setAttribute("src", "assets/img/" + pokemon + direction + ".png");

  if (posX == 330 && posY == 330) {
    themePokemon.play();
    setTimeout(function () {
      themePokemon.pause();
    }, 10000);
    imgPikachu.setAttribute("src", "assets/img/pikachuGros.jpg");
    imgPikachu.setAttribute("width", "100%");
    imgPikachu.setAttribute("height", "100%");
    cross.style.display = "none";
  }
}
