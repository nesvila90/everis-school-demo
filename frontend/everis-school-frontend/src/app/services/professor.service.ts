import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {
  private apiUrl = 'http://localhost:8080/api/professor';

  constructor(private http: HttpClient) {}

  getAllProfessors(): Observable<any> {
    return this.http.get<any[]>(`${this.apiUrl}`);
  }

  getSubjectsByProfessor(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}/subjects`);
  }
}