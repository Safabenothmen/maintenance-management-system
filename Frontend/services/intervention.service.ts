import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InterventionService {
  private baseUrl = 'http://localhost:8080/intervention';

  constructor(private http: HttpClient) {}

  ajouterIntervention(equipementId: number, technicienId: number, intervention: any) {
    return this.http.post(`${this.baseUrl}/ajouter/${equipementId}/${technicienId}`, intervention);
  }

}
