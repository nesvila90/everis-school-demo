import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfessorService } from '../../services/professor.service';
import { SubjectService } from '../../services/subject.service';

@Component({
  selector: 'app-professor',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './professor.component.html'
})
export class ProfessorComponent implements OnInit {
  professors: any[] = [];
  subjects: any[] = [];
  students: any[] = [];
  selectedProfessorId: number | null = null;
  selectedSubjectId: number | null = null;

  constructor(private professorService: ProfessorService, private subjectService: SubjectService) {}

  ngOnInit(): void {
    this.loadProfessors();
  }

  loadProfessors(): void {
    this.professorService.getAllProfessors().subscribe((data: any[]) => {
      this.professors = data;
    });
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