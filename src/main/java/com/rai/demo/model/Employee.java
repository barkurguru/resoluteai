package com.rai.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = -5991147123003259781L;

	public Employee() {
		
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull@NotBlank
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="title")
    private String title;
    
    @Column(name="bunit")
    private String bunit;
    
    @Column(name="place")
    private String place;
    
    @Column(name="superid")
    private int superid;
    
    @Column(name="competencies")
    private String competencies;
    
    @Column(name="salary")
    private int salary;

	public Employee(@NotNull @NotBlank String name, String title, String bunit, String place, int superid,
			String competencies, int salary) {
		super();
		this.name = name;
		this.title = title;
		this.bunit = bunit;
		this.place = place;
		this.superid = superid;
		this.competencies = competencies;
		this.salary = salary;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBunit() {
		return bunit;
	}

	public void setBunit(String bunit) {
		this.bunit = bunit;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getSuperid() {
		return superid;
	}

	public void setSuperid(int superid) {
		this.superid = superid;
	}

	public String getCompetencies() {
		return competencies;
	}

	public void setCompetencies(String competencies) {
		this.competencies = competencies;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

    
}