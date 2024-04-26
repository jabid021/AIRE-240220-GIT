import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utilisateur } from '../model';
import { Observable } from 'rxjs';

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

  findById(id?: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>("http://localhost:8080/api/utilisateur/"+id);
  }

  create(utilisateur: Utilisateur): void {
    this.http.post<Utilisateur>("http://localhost:8080/api/utilisateur", utilisateur).subscribe(resp => {
      this.load();
    });
  }

  update(utilisateur: Utilisateur): void {
    this.http.put<Utilisateur>("http://localhost:8080/api/utilisateur/"+utilisateur.id, utilisateur).subscribe(resp => {
      this.load();
    });
  }

  delete(id?: number): void {
    this.http.delete<void>("http://localhost:8080/api/utilisateur/"+id).subscribe(resp => {
      this.load();
    });
  }
}
