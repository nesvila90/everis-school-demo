import { Routes } from '@angular/router';
import { ProfessorComponent } from './components/professor/professor.component';

export const routes: Routes = [
    { path: '', component: ProfessorComponent },
    { path: '**', redirectTo: '' }
  ];
