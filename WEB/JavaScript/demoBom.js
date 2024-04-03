parag.innerText="Text";

btnStart.onclick=demo;



function demo()
{
  //NAZE
  console.log(navigator.appName);
  //Pas fou
    console.log(screen.width);
    console.log(screen.height);
    console.log(window.innerWidth);
    console.log(window.innerHeight);

  //  var fenetre = window.open("https://www.ajc-formation.fr/");
  //  setTimeout(function(){fenetre.close();},3000);

  //PAS MAL
  //  location.reload();
  //  location.href="https://www.google.fr";

    console.log(history.length);
    history.back(1);
    history.go(2);
}
