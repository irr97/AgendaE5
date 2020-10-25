package com.ae5.sige.Controller;

import java.util.List;

import com.ae5.sige.Documents.Usuarios;
import com.ae5.sige.Repository.UsuarioRepository;
import com.ae5.sige.Service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RestController
@RequestMapping("/Usuarios")
@CrossOrigin()
public class UsuarioController {

    private static final Log LOG = LogFactory.getLog(UsuarioController.class);
    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;

    @GetMapping("/Usuarios")
    public List<Usuarios> findAll(){
        return usuarioRepository.finaAll();
    }


    @PostMapping("/Usuarios")
    public Usuarios save(@RequestBody Usuarios usuario){
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/Usuarios/{DNI}")
    public Usuarios find(@PathVariable("DNI") String DNI){
        return usuarioRepository.findByDNI(DNI);

    }
    
    @RequestMapping(method = RequestMethod.GET)

    public ResponseEntity<Usuarios> getUserPassword(@RequestParam("Usuario") final String Usuario,
        @RequestParam("contrasena") final String Contrasena) {
    
      final Usuarios usuario = usuarioService.getUserByDniAndPassword(Usuario, Contrasena);
      if (usuario != null) {
        LOG.info("[SERVER] Usuario encontrado: " + usuario.getNombre());
        return ResponseEntity.ok(usuario);
      } else {
        LOG.info("[SERVER] No se ha encontrado ningún usuario con esos datos.");
        return ResponseEntity.badRequest().build();
      }
    }

   
}
