import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  error: string;
  success: string;

  constructor(
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      private UsuarioService: AuthenticationService
  ){

  }
  ngOnInit(): void { 
  }
  // getter para obtener los controles del form
  get f() { 
    return this.loginForm.controls;
  }


 public onSubmit(){
    this.submitted = true;
    this.loading = true;
    this.UsuarioService.login(this.f.dni.value, this.f.password.value)
    .subscribe(
        data => {
           this.router.navigate(['/reuniones']);
        },
            
        error => {
            this.error = "Error: No se ha encontrado ningún usuario con esos datos.";
            this.loading = false;
        });
  }



 /* usuario:string;
  contrasena:string;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  public Login(){
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

