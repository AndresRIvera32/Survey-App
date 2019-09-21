import { Injectable } from '@angular/core';
import { HOST_BACKEND } from '../_shared/constants';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Survey } from '../_model/Survey';

@Injectable({
  providedIn: 'root'
})
export class SurveyService {

  urlSurvey: string = `${HOST_BACKEND}/api/survey`;
  //urlNegocio: string = `https://zj1s896pui.execute-api.us-east-1.amazonaws.com/prod/api/negocio`;

  mensajeRegistro = new Subject<string>();

  constructor(private httpClient: HttpClient) { }

  obtenerTodosLosRegistros() {
    return this.httpClient.get<Survey[]>(`${this.urlSurvey}/listar`);
  }

  guardarSurvey(survey: Survey) {
    return this.httpClient.post(`${this.urlSurvey}/registrar`, survey);
  }
}
