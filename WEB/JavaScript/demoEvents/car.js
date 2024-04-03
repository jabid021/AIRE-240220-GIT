
  var posX=0;
  var posY= 0;
  var couleurVoiture="red";


  btnVoiture.onclick=function()
  {
      document.body.onkeydown=deplacementVoiture;
  };


  car.ondblclick=changerVoiture;


  function changerVoiture()
  {
    if(couleurVoiture=="red")
    {
      couleurVoiture="blue";
    }
    else
    {
      couleurVoiture="red";
    }
    typeCar.setAttribute("src",`${couleurVoiture}.gif`);
  }

  function deplacementVoiture(e)
  {

    if(e.key=="ArrowUp" || e.key=="z")
    {
      posY+=30;
      car.style.transform="rotate(90deg)";
    }
    else if(e.key=="ArrowDown" || e.key=="s")
    {
      posY-=30;
      car.style.transform="rotate(-90deg)";
    }
    else if(e.key=="ArrowLeft" || e.key=="q")
    {
      posX+=30;
      car.style.transform="scaleX(1)";
    }
    else if(e.key=="ArrowRight" || e.key=="d")
    {
      posX-=30;
      car.style.transform="scaleX(-1)";
    }

    car.style.right=posX+"px";
    car.style.bottom=posY+"px";
  }
