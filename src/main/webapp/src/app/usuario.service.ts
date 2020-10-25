import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private uri = 'http://localhost:9000/AgendaE5';
  private currentUserSubject: BehaviorSubject<any>;
    public currentUser: Observable<any>;

  constructor(
    private http: HttpClient,
    private router : Router
  ) {}

  public save(usuario){
    return this.http.post(this.uri + '/Usuarios', usuario);

  }

  public findAll(){
    return this.http.get(this.uri + '/Usuarios');
  }

  public find(DNI){
    return this.http.get(this.uri + '/Usuarios/' + DNI);
  }

  login(usuario, password) {
    const params = new HttpParams()
        .set('dni', usuario)
        .set('password', password);
    return this.http.get(this.uri+ '/usuarios', { params : params })
        .pipe(map(user => {
            // almacena detalles del usuario y el token jwt en el almacenamiento local para mantener al usuario logueado entre refrescos de página
            localStorage.setItem('currentUser', JSON.stringify(user));
            this.currentUserSubject.next(user);
            return user;
        }));
  }
}
