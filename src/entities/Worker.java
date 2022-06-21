package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Departament department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Departament department) {		
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public void addContract (HourContract contract) {
		contracts.add(contract);
	}
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
	}
	public Double income(int month, int year) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		
		//Percorre todos os contratos e quando encontrar o mes/ano, soma o salario base com o valor total dos contratos
		for (HourContract obj : contracts) {
			cal.setTime(obj.getDate());					//Seta a data para poder pegar o mês e o ano
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);	//Acrescenta +1 pois janeiro começa como 0
			
			if(c_month == month && c_year == year) {
				sum += obj.totalValue();
			}
		}
		return sum;
	}
	
	@Override
	public String toString() {
		return "Worker [name=" + name + ", level=" + level + ", baseSalary=" + baseSalary + ", department=" + department.getName()
				+ ", contracts=" + contracts + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartment() {
		return department;
	}

	public void setDepartment(Departament department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}	
	
}
