import { Component, OnInit } from '@angular/core';
import { catchError, map, Observable, of, startWith } from 'rxjs';
import { DataState } from './enum/data-state-enum';
import { AppState } from './interface/app-state';
import { CustomResponse } from './interface/custom-response';
import { TravelService } from "./service/travel.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  appState$!: Observable<AppState<CustomResponse>>;
  readonly DataState = DataState;

  constructor(private travelService: TravelService) { }

  ngOnInit(): void {
    this.appState$ = this.travelService.travels$.pipe(
      map(response => {
        return { dataState: DataState.LOADED_STATE, appData: response }
      }
      ),
      startWith({ dataState: DataState.LOADING_STATE }),
      catchError((error: string) => {
        return of({ dataState: DataState.ERROR_STATE, error: error })
      })
    );
  }
}
