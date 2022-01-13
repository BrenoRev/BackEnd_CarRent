package com.dev.rev.prova.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.Hibernate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "Brand")
public class Brand implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "car_models")
	@OneToMany(mappedBy = "brand", cascade = CascadeType.MERGE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Model> models = new ArrayList<>();

	@NotNull(message = "The brand's name can't be null")
	@Column(name = "brand", unique = true)
	private String name;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Brand brand = (Brand) o;
		return id != null && Objects.equals(id, brand.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
