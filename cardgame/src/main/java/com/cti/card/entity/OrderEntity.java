package com.cti.card.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entity - Order by base 
 * 
 * @author Bruce LIU
 * @version 1.0
 */
@MappedSuperclass
public abstract class OrderEntity extends BaseEntity implements Comparable<OrderEntity> {

  
	private static final long serialVersionUID = 8802973500978194354L;

 
	public static final String ORDER_PROPERTY_NAME = "order";

	private Integer order;

	/**
	 * get order
	 * 
	 * @return order
	 */
	@JsonProperty
	@Field(store = Store.YES, index = Index.UN_TOKENIZED)
	@Min(0)
	@Column(name = "orders")
	public Integer getOrder() {
		return order;
	}

	/**
	 * set order
	 * 
	 * @param order
	 *            order
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * compareTo
	 * 
	 * @param orderEntity
	 *            object to be compared
	 * @return result
	 */
	public int compareTo(OrderEntity orderEntity) {
		return new CompareToBuilder().append(getOrder(), orderEntity.getOrder()).append(getId(), orderEntity.getId()).toComparison();
	}

}