import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfessorService } from '../../services/professor.service';
import { SubjectService } from '../../services/subject.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-professor',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './professor.component.html'
})
export class ProfessorComponent implements OnInit {
  professors: any[] = [];
  filteredProfessors: any[] = [];
  subjects: any[] = [];
  students: any[] = [];
  selectedProfessorId: number | null = null;
  selectedSubjectId: number | null = null;
  searchProfessor: string = '';
  searchSubject: string = '';

  constructor(
    private professorService: ProfessorService,
    private subjectService: SubjectService
  ) {}

  ngOnInit(): void {
    this.loadProfessors();
  }

  loadProfessors(): void {
    this.professorService.getAllProfessors().subscribe((data: any[]) => {
      this.professors = data;
      this.filteredProfessors = data;
    });
  }

  normalizeString(str: string): string {
    return str.normalize('NFD').replace(/[\u0300-\u036f]/g, '').toLowerCase();
  }

  filterProfessors(): void {
    const search = this.normalizeString(this.searchProfessor);
    this.filteredProfessors = this.professors.filter(professor =>
      this.normalizeString(professor.name).includes(search)
    );
  }

  loadSubjects(professorId: number): void {
    this.selectedProfessorId = professorId;
    this.professorService.getSubjectsByProfessor(professorId).subscribe((data: any) => {
      this.subjects = data.content;
    });
  }

  loadStudents(subjectId: number): void {
    this.selectedSubjectId = subjectId;
    this.subjectService.getStudentsBySubject(subjectId).subscribe((data: any) => {
      this.students = data.content;
    });
  }
}
