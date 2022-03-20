/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nailing.app.unya;

import com.nailing.app.decoracion.Decoracion;
import com.nailing.app.acabado.Acabado;
import com.nailing.app.disenyo.Disenyo;
import com.nailing.app.tipo.Tipo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.nailing.app.base.Base;

/**
 *
 * @author Jacgarvel
 */
@Entity
@Table(name = "unya")
@EntityListeners(AuditingEntityListener.class)
public class Unya {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "dedo")
    private Dedo dedo;
    
    @Column(name = "tiempo")
    private Double tiempo;
    
    @Column(name = "coste")
    private Double coste;
    
    @ManyToOne
    @JoinColumn(name = "decoracion_id")
    private Decoracion decoracion;

    @ManyToOne
    @JoinColumn(name = "acabado_id")
    private Acabado acabado;

    @ManyToOne
    @JoinColumn(name="base_id")
    private Base base;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "disenyo_id")
    private Disenyo disenyo;

    public Disenyo getDisenyo(){
        return disenyo;
    }

    public Tipo getTipo(){
        return tipo;
    }
    
    public Long getId() {
        return id;
    }

    public Dedo getDedo() {
        return dedo;
    }

    public Double getTiempo() {
        return tiempo;
    }

    public Double getCoste() {
        return coste;
    }
    
    public Acabado getAcabado() {
        return acabado;
    }

    public Decoracion getDecoracion() {
        return decoracion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDedo(Dedo dedo) {
        this.dedo = dedo;
    }

    public void setTiempo(Double tiempo) {
        this.tiempo = tiempo;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }

    public void setDecoracion(Decoracion decoracion) {
        this.decoracion = decoracion;
    }
    
    public void setAcabado(Acabado acabado) {
        this.acabado = acabado;
    }
    
     public void setDisenyo(Disenyo disenyo){
        this.disenyo = disenyo;
    }
  
    public void setTipo(Tipo tipo){
        this.tipo = tipo;
    }

    public Base getBase() {
	return base;
    }

    public void setBase(Base base) {
	this.base = base;
    }
    
}