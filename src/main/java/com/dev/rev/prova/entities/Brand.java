package com.dev.rev.prova.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.Hibernate;


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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

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
