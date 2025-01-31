package com.nailing.app.tamanyo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.nailing.app.centro.Centro;
import com.nailing.app.components.Fases;

@Entity
@Table(name = "tamanyo")
public class Tamanyo {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre")
	@NotNull
	private NombreTamanyo nombre;

	@Positive
	@NotNull
	@Column(name = "tiempo")
	private Integer tiempo;

	@PositiveOrZero
	@NotNull
	@Column(name = "coste")
	private Double coste;

	@Column(name = "siguiente_fase")
	@NotNull
	private Fases siguienteFase;

	@ManyToOne
	@JoinColumn(name = "centro_id")
	private Centro centro;

	public Tamanyo() {
		super();
	}

	public Tamanyo(Long id, @NotNull NombreTamanyo nombre, @Positive @NotNull Integer tiempo,
			@PositiveOrZero @NotNull Double coste, @NotNull Fases siguiente_fase, Centro centro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tiempo = tiempo;
		this.coste = coste;
		this.siguienteFase = siguiente_fase;
		this.centro = centro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NombreTamanyo getNombre() {
		return nombre;
	}

	public void setNombre(NombreTamanyo nombre) {
		this.nombre = nombre;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public Double getCoste() {
		return coste;
	}

	public void setCoste(Double coste) {
		this.coste = coste;
	}

	public Fases getSiguiente_fase() {
		return siguienteFase;
	}

	public void setSiguiente_fase(Fases siguiente_fase) {
		this.siguienteFase = siguiente_fase;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(centro, coste, id, nombre, siguienteFase, tiempo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tamanyo other = (Tamanyo) obj;
		return Objects.equals(centro, other.centro) && Objects.equals(coste, other.coste)
				&& Objects.equals(id, other.id) && nombre == other.nombre && siguienteFase == other.siguienteFase
				&& Objects.equals(tiempo, other.tiempo);
	}

	@Override
	public String toString() {
		return "Tamanyo [id=" + id + ", nombre=" + nombre + ", tiempo=" + tiempo + ", coste=" + coste
				+ ", siguiente_fase=" + siguienteFase + "]";
	}

}
