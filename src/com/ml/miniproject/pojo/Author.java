package com.ml.miniproject.pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 30, unique = true, updatable = false, nullable = false)
	private long authorId;

	@Column(length = 50, updatable = true, nullable = false)
	private String authorName;

	@Column(length = 60, updatable = false, nullable = false)
	private String email;

	@Column(length = 14, updatable = true, nullable = false)
	private long phone;

	@ElementCollection
	@CollectionTable(name = "mySkills", joinColumns = @JoinColumn(name = "authorId"))
	@Column(nullable = false, unique = false, updatable = true)
	private Set<String> skills;

	@ElementCollection
	@CollectionTable(name = "myQualifications", joinColumns = @JoinColumn(name = "authorId"))
	@OrderColumn(name = "qOrder")
	@Column(name = "qualis", nullable = false, unique = false, updatable = true)
	private List<String> qualifications;

	@ElementCollection
	@CollectionTable(name = "myExperiences", joinColumns = @JoinColumn(name = "authorId"))
	@MapKeyColumn(name = "companyName")
	@Column(name = "yoe", nullable = true, unique = false, updatable = true)
	private Map<String, Integer> myExp;

	@ManyToMany(mappedBy = "myAuthors")
	private Set<Book> myBooks;

	public Author() {
	}

	public Author(String authorName, String email, long phone, Set<String> skills, List qualifications,
			Map<String, Integer> myExp, Set<Book> myBooks) {
		super();
		this.authorName = authorName;
		this.email = email;
		this.phone = phone;
		this.skills = skills;
		this.qualifications = qualifications;
		this.myExp = myExp;
		this.myBooks = myBooks;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Set<String> getSkills() {
		return skills;
	}

	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}

	public List getQualifications() {
		return qualifications;
	}

	public void setQualifications(List qualifications) {
		this.qualifications = qualifications;
	}

	public Map<String, Integer> getMyExp() {
		return myExp;
	}

	public void setMyExp(Map<String, Integer> myExp) {
		this.myExp = myExp;
	}

	public Set<Book> getMyBooks() {
		return myBooks;
	}

	public void setMyBooks(Set<Book> myBooks) {
		this.myBooks = myBooks;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", email=" + email + ", phone=" + phone
				+ ", skills=" + skills + ", qualifications=" + qualifications + ", myExp=" + myExp + ", myBooks="
				+ myBooks + "]";
	}

}
