package br.com.jonathan.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "produto")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 150, name = "nome")
	@NotBlank(message = "Nome é uma informação obrigatória.")
	private String name;

	@Column(nullable = false, name = "quantidade")
	@NotNull(message = "Quantidade é uma informação obrigatória.")
	private Integer quantity;

	@Column(nullable = false, name = "valorVenda")
	@NotNull(message = "Valor de venda é uma informação obrigatória.")
	private Double saleValue;

	@Column(nullable = false, name = "dataValidade")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data de validade é uma informação obrigatória.")
	private Date expirationDate;

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(Double saleValue) {
		this.saleValue = saleValue;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}