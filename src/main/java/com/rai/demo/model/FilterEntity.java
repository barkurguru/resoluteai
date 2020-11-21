package com.rai.demo.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FilterEntity implements Serializable {
	
	private static final long serialVersionUID = -3485373406159552234L;
	@NotBlank  @NotBlank
	private String competency;
	
	@NotNull @Min(0)
	private int salaryfrom;
	
	@NotNull @Max(10000000)
	private int salaryto;
	
	public FilterEntity() {
		
	}
	public FilterEntity(String competency, int salaryfrom, int salaryto) {
		this.competency = competency;
		this.salaryfrom = salaryfrom;
		this.salaryto = salaryto;
	}
	public String getCompetency() {
		return competency;
	}
	public void setCompetency(String competency) {
		this.competency = competency;
	}
	public int getSalaryfrom() {
		return salaryfrom;
	}
	public void setSalaryfrom(int salaryfrom) {
		this.salaryfrom = salaryfrom;
	}
	public int getSalaryto() {
		return salaryto;
	}
	public void setSalaryto(int salaryto) {
		this.salaryto = salaryto;
	}

}
