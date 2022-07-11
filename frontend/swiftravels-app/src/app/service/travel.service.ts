import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { CustomResponse } from '../interface/custom-response';
import { Travel } from '../interface/travel';

@Injectable({ providedIn: 'root' })
export class TravelService {
  private readonly apiUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  travels$ = <Observable<CustomResponse>>
    this.http.get<CustomResponse>(`${this.apiUrl}/travel/list`)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      );

  save$ = (travel: Travel) => <Observable<CustomResponse>>
    this.http.post<CustomResponse>(`${this.apiUrl}/travel/save`, travel)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      );

  delete$ = (travelId: number) => <Observable<CustomResponse>>
    this.http.delete<CustomResponse>(`${this.apiUrl}/travel/delete/${travelId}`)
      .pipe(
        tap(console.log),
        catchError(this.handleError)
      );

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    return throwError(() => new Error(`An error occurred - Error code : ${error.status}`));
  }
}
