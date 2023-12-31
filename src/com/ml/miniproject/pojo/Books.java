package com.ml.miniproject.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookId;
	@Column(name = "bName")
	private String bookName;
	@Column(name = "bCost")
	private double cost;
	@Column(name = "bEdition")
	private int edition;
	@Column(name = "bVolume")
	private float volume;
	@Column(name = "bPubYear")
	private int pubYear;
	@Column(updatable = true, length = 50)
	private String status;

	@ManyToMany
	@JoinTable(name = "books_and_authors", joinColumns = @JoinColumn(name = "myBookId", referencedColumnName = "bookId"), inverseJoinColumns = @JoinColumn(name = "myAuthorId", referencedColumnName = "authorId"))
	Set<Author> myAuthors;

	@OneToMany(mappedBy = "myBook")
	private Set<OrderItem> myOrders;

	public Books() {
	}
	public Books(String bookName, double cost, int edition, float volume, int pubYear, String status,
			Set<Author> myAuthors, Set<OrderItem> myOrders) {
		super();
		this.bookName = bookName;
		this.cost = cost;
		this.edition = edition;
		this.volume = volume;
		this.pubYear = pubYear;
		this.status = status;
		this.myAuthors = myAuthors;
		this.myOrders = myOrders;
	}
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	public Set<Author> getMyAuthors() {
		return myAuthors;
	}

	public void setMyAuthors(Set<Author> myAuthors) {
		this.myAuthors = myAuthors;
	}

	public Set<OrderItem> getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(Set<OrderItem> myOrders) {
		this.myOrders = myOrders;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", cost=" + cost + ", edition=" + edition
				+ ", volume=" + volume + ", pubYear=" + pubYear + ", myAuthors=" + myAuthors + ", myOrders=" + myOrders
				+ "]";
	}
}
