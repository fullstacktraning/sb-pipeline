package com.careerit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="laptops")
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double cost;
	private int qty;
	private String image;
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laptop(Long id, String name, Double cost, int qty, String image) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.qty = qty;
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", cost=" + cost + ", qty=" + qty + ", image=" + image + "]";
	}
	
}
