import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario:string;
  contrasena:string;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  /*public Login(){
    const usuario = {
      "usuario" : this.usuario,
      "contrasena": this.contrasena
    };*/

    /*this.usuarioService.login(this.usuario, this.contrasena)
    .subscribe(response =>
      this.router.navigate['/registro']
    )
  }*/

}
