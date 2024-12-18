import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubjectService {
  private apiUrl = 'http://localhost:8080/api/subject';

  constructor(private http: HttpClient) {}

  getAllSubjects(): Observable<any> {
    return this.http.get<any[]>(`${this.apiUrl}`);
  }

  getStudentsBySubject(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}/asignaturas/estudiantes`);
  }
}