import { Component, OnInit } from '@angular/core';
import { DetalleComponent } from './detalle/detalle.component';
import { MatDialog } from '@angular/material';
import { Survey } from '../../_model/Survey';
import { SurveyService } from '../../_services/survey.service';
import { SecurityService } from '../../_services/security.service';
import { MatTableDataSource } from '@angular/material';
import { TOKEN_NAME, ACCESS_TOKEN_NAME } from '../../_shared/constants';
import { RespuestaApi } from '../../_model/RespuestaApi';

/**
 * @see https://angular-maps.com/guides/getting-started/
 */ 
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  private survey: Survey = new Survey();
  title = 'mi encuesta'
  isAdmin: boolean = false;
  lsurvey: Survey[] ;

  constructor(public dialog: MatDialog,private surveyService: SurveyService,
    private securityService: SecurityService ) {
         }

  ngOnInit(){
      this.isAdmin = this.securityService.esRoleAdmin();   
      if(this.isAdmin){   
        this.surveyService.obtenerTodosLosRegistros().subscribe((surveys) => this.lsurvey = surveys); 
      }
  }
      

public create(){
  console.log("Clicked!")
  console.log(this.survey);
  this.surveyService.guardarSurvey(this.survey).subscribe(
    response => alert("Encuesta guardada!")
  )
}


}