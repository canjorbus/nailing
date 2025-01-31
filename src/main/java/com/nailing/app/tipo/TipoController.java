/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nailing.app.tipo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CANDELA
 */
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/tipos")
public class TipoController {
    
    @Autowired
    TipoService tipoService;
    
    @GetMapping()
    public ResponseEntity<List<Tipo>> listTipos(){
        List<Tipo> tipos = (List<Tipo>) tipoService.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
	public void deleteTipo(@PathVariable Long id) {
		tipoService.removeTipo(id);
	}
        
     @GetMapping("/{id}")
	public ResponseEntity<Tipo> showTipo(@PathVariable Long id){
		return new ResponseEntity<>(tipoService.findById(id), HttpStatus.OK);
	}
        
    @GetMapping("/centro/{centroId}")
	public  ResponseEntity<List<Tipo>> findByCentro(@PathVariable Long centroId){
		List<Tipo> tipos = tipoService.findByCentro(centroId);
		return new ResponseEntity<>(tipos, HttpStatus.OK);
	}    
}
