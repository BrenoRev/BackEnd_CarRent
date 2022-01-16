package com.dev.rev.prova.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

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
@Table(name = "model")
public class Model implements Serializable {

	@Id
	@SequenceGenerator(name="sequence_model", initialValue = 37)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_model")
	@Column(name = "id", nullable = false)
	private Long id;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@Column(name = "model", nullable = false)
	private String name;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Model model = (Model) o;
		return id != null && Objects.equals(id, model.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
