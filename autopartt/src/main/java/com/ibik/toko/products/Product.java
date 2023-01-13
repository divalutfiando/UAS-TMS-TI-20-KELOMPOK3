package com.ibik.toko.products;

import java.util.Set;

import javax.persistence.*;

import com.ibik.toko.order.Orders;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "price")
	private String price;

	@Column(name = "published")
	private boolean published;

	@ManyToMany
  @JoinTable(
		name = "order_rel_product",
		joinColumns = @JoinColumn(name = "id_product"),
		inverseJoinColumns = @JoinColumn(name = "id_order")
	)
	private Set<Orders> orders;

	public Product() {

	}

	public Product(long id, String title, String description, String image, String price, boolean published) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.published = published;
		this.price = price;
	}	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", desc=" + description + ", image=" + image + " , published=" + published + "]";
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}