//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-mouvementpx par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX=0;
var posY=0;
var DposX=90;
var DposY=0;
var maxX=630;
var maxY=630;
var mouvement=30;
var pokemon="pikachu";
var direction="Down";
var Ddirection="Down";
var gameOn = false;
var chrono;
imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

btnStart.onclick = choixNomPkmn;
inputName.onkeyup = verifNomPkmn;
document.onkeyup = everyoneMove;


function starve(){
  grass.style.display = "none";
  blood2.style.display = "block";
  themePokemon.pause();
  gameOn=false;
}

function verifNomPkmn(e)
{
  if(e.key=="Enter") {choixNomPkmn();}
  if(inputName.value=="") { btnStart.disabled=true; }
  else { btnStart.disabled=false; }
}

function choixNomPkmn(){
  var nomPkmn = inputName.value;
  imgPikachu.setAttribute("title",nomPkmn);
  formStart.style.display = "none";
  grass.style.display = "block";
  gameOn = true;
  //themePokemon.play();
  chrono = setTimeout(starve,30000);
}

function everyoneMove(event){
  deplacement(event);
  deplacementDratini(event);
  if(DposX==posX && DposY==posY){
    grass.style.display = "none";
    blood.style.display = "block";
    gameOn=false;
    themePokemon.pause();
    clearTimeout(chrono);
  }
}

function deplacement(event)
{
  if(gameOn==true){
    if(event.key=="ArrowDown")
    {
      if((posY+mouvement)<maxY)
      {
        posY += mouvement;
      }
      else
      {
        posY = maxY;
      }
      direction = "Down";
    }
    else if(event.key=="ArrowRight")
    {
      if((posX+mouvement)<maxX){
        posX += mouvement;
      }
      else{
        posX = maxX;
      }
      direction = "Right";
    }

    else if(event.key=="ArrowLeft")
    {
      if((posX-mouvement)>0){
        posX -= mouvement;
      }
      else {
        posX = 0;
      }
      direction = "Left";
    }
    else if(event.key=="ArrowUp")
    {
      if((posY-mouvement)>0)
      {
        posY -= mouvement;
      }
      else
      {
        posY=0;
      }
      direction = "Up";
    }
    console.log("Pikachu X "+posX+"Y "+posY);
    pikachu.style.top=posY+"px";
    pikachu.style.left=posX+"px";
    imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");
  }
}

function deplacementDratini(event)
{
  if(gameOn==true){
    if(event.key=="s" )
    {
      if((DposY+mouvement)<maxY)
      {
        DposY += mouvement;
      }
      else
      {
        DposY = maxY;
      }
      Ddirection = "Down";
    }
    else if(event.key=="d" )
    {
      if((DposX+mouvement)<maxX){
        DposX += mouvement;
      }
      else{
        DposX = maxX;
      }
      Ddirection = "Right";
    }

    else if(event.key=="q")
    {
      if((DposX-mouvement)>0){
        DposX -= mouvement;
      }
      else {
        DposX = 0;
      }
      Ddirection = "Left";
    }
    else if(event.key=="z")
    {
      if((DposY-mouvement)>0)
      {
        DposY -= mouvement;
      }
      else
      {
        DposY=0;
      }
      Ddirection = "Up";
    }
    console.log("Dratini X "+DposX+"Y "+DposY);
    dratini.style.top=DposY+"px";
    dratini.style.left=DposX+"px";
    imgDratini.setAttribute("src","assets/img/"+"dratini"+Ddirection+".png");
  }
}
