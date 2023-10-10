package com.ml.miniproject.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 20, unique = true, updatable = false, nullable = false)
	long authorId;
	@Column(length = 50, updatable = true, nullable = false)
	String authorName;
	@ElementCollection
	@Column(length = 50, nullable = false, unique = false, updatable = true)
	Set<String> skills;
	

}
