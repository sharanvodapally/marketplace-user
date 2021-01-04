package com.marketplace.marketplaceuser.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5337783468236492296L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CITY")
	private String city;

	@Column(name = "DOB")
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	@Column(name = "CREATED_DATE")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdDate;

	@Column(name = "LAST_UPDATED_DATE")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdatedDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

}

