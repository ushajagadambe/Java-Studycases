package com.nacre.phs.dto;

public class MedicineDto {
String name;
String md;
int power;
String ed;
String company;
int qunatity;
public void SetName(String name)
{
	this.name=name;
}
public String getName()
{
	return name;
}
public String getMd() {
	return md;
}
public void setMd(String md) {
	this.md = md;
}
public int getPower() {
	return power;
}
public void setPower(int power) {
	this.power = power;
}
public String getEd() {
	return ed;
}
public void setEd(String ed) {
	this.ed = ed;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ed == null) ? 0 : ed.hashCode());
	result = prime * result + ((md == null) ? 0 : md.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + power;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	MedicineDto other = (MedicineDto) obj;
	if (ed == null) {
		if (other.ed != null)
			return false;
	} else if (!ed.equals(other.ed))
		return false;
	if (md == null) {
		if (other.md != null)
			return false;
	} else if (!md.equals(other.md))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (power != other.power)
		return false;
	return true;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public int getQunatity() {
	return qunatity;
}
public void setQunatity(int qunatity) {
	this.qunatity = qunatity;
}
}
