package com.ml.miniproject.pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="authorId")
	private long authorId;
	@Column(name="authorName")
	private String authorName;
	@Column(name="authorEmail")
	private String email;
	@Column(name="authorPhone")
	private long phone;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "authorSkills", joinColumns = @JoinColumn(name = "authorId"))
	private Set<String> skills;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "authorQual", joinColumns = @JoinColumn(name = "authorId"))
	@OrderColumn(name = "qOrder")
	@Column(name = "qualis")
	private List<String> qualifications;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "authorExp", joinColumns = @JoinColumn(name = "authorId"))
	@MapKeyColumn(name = "companyName")
	@Column(name = "yoe")
	private Map<String, Integer> myExp;

	@ManyToMany(mappedBy = "myAuthors", fetch = FetchType.EAGER)
	private Set<Book> myBooks;

	public Author() {
	}

	public Author(String authorName, String email, long phone, Set<String> skills, List<String> qualifications,
			Map<String, Integer> myExp) {
		this.authorName = authorName;
		this.email = email;
		this.phone = phone;
		this.skills = skills;
		this.qualifications = qualifications;
		this.myExp = myExp;
	}

	public Author(String authorName, String email, long phone, Set<String> skills, List<String> qualifications,
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

	public List<String> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<String> qualifications) {
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
