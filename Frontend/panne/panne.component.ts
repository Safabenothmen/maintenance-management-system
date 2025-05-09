import { Component, OnInit } from '@angular/core';
import { PanneService } from '../services/panne.service';
import { EquipementService } from '../services/equipement.service';

@Component({
  selector: 'app-panne',
  templateUrl: './panne.component.html',
  styleUrls: ['./panne.component.css']
})
export class PanneComponent implements OnInit {
  panne = {
    description: '',
    categorie: '',
    date_sign: ''
  };
  equipementId: number = 0;
  equipements: any[] = [];
  pannes: any[] = []; // 👈 Ajouter cette ligne

  constructor(
    private panneService: PanneService,
    private equipementService: EquipementService
  ) {}

  ngOnInit(): void {
    this.equipementService.getAllEquipement().subscribe({
      next: (data) => {
        this.equipements = data;
      },
      error: (err) => {
        console.error('Erreur de récupération des équipements', err);
      }
    });

    // 👇 Charger les pannes au démarrage
    this.chargerPannes();
  }

  onSubmit() {
    this.panneService.ajouterPanne(this.equipementId, this.panne).subscribe({
      next: (res) => {
        console.log('Panne ajoutée avec succès', res);
        this.panne = { description: '', categorie: '', date_sign: '' };
        this.equipementId = 0;
        this.chargerPannes(); // 👈 Recharger la liste après ajout
      },
      error: (err) => {
        console.error('Erreur lors de l’ajout de la panne', err);
      }
    });
  }

  // 👇 Fonction pour charger toutes les pannes
  chargerPannes() {
    this.panneService.getAllPannes().subscribe({
      next: (data) => {
        this.pannes = data;
      },
      error: (err) => {
        console.error('Erreur lors de la récupération des pannes', err);
      }
    });
  }
}
