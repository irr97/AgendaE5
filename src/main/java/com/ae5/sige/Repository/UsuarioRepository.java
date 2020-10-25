package com.ae5.sige.Repository;

import java.util.List;

import com.ae5.sige.Documents.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class UsuarioRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Usuarios save(Usuarios usuario){
        return mongoTemplate.save(usuario);
        
    }

    public  List<Usuarios> finaAll(){
        return mongoTemplate.findAll(Usuarios.class);
    }

    public Usuarios findByDNI(String DNI){
        return mongoTemplate.find(new Query().addCriteria(Criteria.where("_DNI").is(DNI)),Usuarios.class).get(0);
    }

    public Usuarios findByUsuarioAndContrasena(final String Usuario, final String contrasena) {
      return this.mongoTemplate.findOne(new Query(Criteria.where("Usuario").is(Usuario).and("Contraseña").is(contrasena)), Usuarios.class);
      
    }
    
}
