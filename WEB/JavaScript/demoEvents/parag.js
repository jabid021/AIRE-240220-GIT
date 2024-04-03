
    var couleur = "black"

  //Fonction en attente d'un event => Listner / Ecouteur
  paragPrinci.onclick=demoEvent;
  //paragPrinci.ondblclick=function(){console.log("dblclick sur p");}
  paragPrinci.onmousedown=demoEvent;
  paragPrinci.onmouseup=demoEvent;

  paragPrinci.onmouseover = demoEvent;
  paragPrinci.onmouseout = demoEvent;
  paragPrinci.onmousemove = vague;


  couleurText.onchange = demoCouleur;

  resetCouleur.onclick=resetCouleurFunction;


  function resetCouleurFunction()
  {
    couleur="black";
    parag2.style.color=couleur;
    couleurText.value = "#000000";
  }


  function demoCouleur()
  {

    couleur = couleurText.value;
    parag2.style.color=couleur;


  }
  function demoEvent(event)
  {
    if(event.type=="click")
    {
      console.log("click");
    }
    else if(event.type=="mousedown")
    {
      console.log("mouse down");
    }
    else if(event.type=="mouseup")
    {
      console.log("mouse up");
    }
    else if(event.type=="dblclick")
    {
      console.log("dblclick");
    }
    else if(event.type=="mouseover")
    {
      console.log("mouse over");
      parag2.style.color="red";
    }
    else if(event.type=="mouseout")
    {
      console.log("mouse out");
      parag2.style.color=couleur;
      this.style.transform = 'none';
    }
  }

  function vague(e)
  {
    const { offsetX, offsetY } = e;

    const { offsetWidth: width, offsetHeight: height } = this;

    const moveX = offsetX / width - 0.5;
    const moveY = offsetY / height - 0.5;

    const degrees = 10;

    this.style.transform = `translate(${moveX * degrees}px, ${moveY * degrees}px)`;

  }
