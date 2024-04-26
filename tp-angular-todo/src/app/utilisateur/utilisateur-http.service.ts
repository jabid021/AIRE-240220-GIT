import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utilisateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurHttpService {

  private utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();

  constructor(private http: HttpClient) {
    this.load();
  }

  load() {
    this.http.get<Utilisateur[]>("http://localhost:8080/api/utilisateur").subscribe(resp => {
      this.utilisateurs = resp;
    });
  }

  findAll(): Utilisateur[] {
    return this.utilisateurs;
  }
}
