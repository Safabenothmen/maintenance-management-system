import { Component, OnInit } from '@angular/core';
import { InterventionService } from '../services/intervention.service';
import { EquipementService } from '../services/equipement.service';
import { TechnicienService } from '../services/technicien.service'; // Tu dois aussi créer ce service si pas encore fait

@Component({
  selector: 'app-intervention',
  templateUrl: './intervention.component.html',
  styleUrls: ['./intervention.component.css']
})
export class InterventionComponent implements OnInit {
  intervention = {
    date: '',
    cout: 0,
    statut: 'Planifiee'
  };

  equipementId: number = 0;
  technicienId: number = 0;

  equipements: any[] = [];
  techniciens: any[] = [];

  constructor(
    private interventionService: InterventionService,
    private equipementService: EquipementService,
    private technicienService: TechnicienService
  ) {}

  ngOnInit(): void {
    this.equipementService.getAllEquipement().subscribe(data => this.equipements = data);
    this.technicienService.getAllTechniciens().subscribe(data => this.techniciens = data);
  }

  onSubmit() {
    this.interventionService.ajouterIntervention(this.equipementId, this.technicienId, this.intervention).subscribe({
      next: (res) => {
        console.log('Intervention ajoutée avec succès', res);
        this.intervention = { date: '', cout: 0, statut: 'Planifiee' };
        this.equipementId = 0;
        this.technicienId = 0;
      },
      error: (err) => {
        console.error('Erreur lors de l’ajout de l’intervention', err);
      }
    });
  }
}
