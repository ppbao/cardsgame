package com.cti.card.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.groups.Default;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

 
@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, creatorVisibility = Visibility.NONE)
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -67188388306700736L;

	public static final String ID_PROPERTY_NAME = "id";
 
	public interface Save extends Default {

	}

	public interface Update extends Default {

	}

	private Long id;

 
	/**
	 * Retrieve ID
	 * 
	 * @return ID
	 */
	@JsonProperty
	@DocumentId
	@Id
	// MySQL/SQLServer: @GeneratedValue(strategy = GenerationType.AUTO)
	// Oracle: @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * Set ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
 

	/**
	 * rewrite equals
	 * 
	 * @param obj
	 *            
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!BaseEntity.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		BaseEntity other = (BaseEntity) obj;
		return getId() != null ? getId().equals(other.getId()) : false;
	}

	/**
	 * rewrite hashCode
	 * 
	 * @return hashCode
	 */
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += null == getId() ? 0 : getId().hashCode() * 31;
		return hashCode;
	}

}