import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reuniones',
  templateUrl: './reuniones.component.html',
  styleUrls: ['./reuniones.component.css']
})
export class ReunionesComponent implements OnInit {
  
  public reuniones;

  constructor(
    private service: ReunionesService
  ) { }
  

  ngOnInit(): void {
  }

}
