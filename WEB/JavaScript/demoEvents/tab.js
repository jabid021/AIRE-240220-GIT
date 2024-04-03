btnAjouter.onclick=ajouterTableau;
inputPrenom.onkeyup = verifContent;


function verifContent(e)
{

  if(e.key=="Enter")
  {
    ajouterTableau();
  }

  if(inputPrenom.value=="")
  {
    btnAjouter.disabled=true;
    loginStatut.style.backgroundColor="red";
  }
  else
  {
      btnAjouter.disabled=false;
      loginStatut.style.backgroundColor="green";
  }
}


function ajouterTableau()
{
  var prenom = inputPrenom.value;
  tableau.innerHTML+= "<tr><td>"+prenom+"</td></tr>";
  inputPrenom.value="";
  btnAjouter.disabled=true;
  loginStatut.style.backgroundColor="red";
}
