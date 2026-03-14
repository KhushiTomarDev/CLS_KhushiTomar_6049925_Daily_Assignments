////package cg.demo.associationmapping;
////
////import java.util.Set;
////
////import jakarta.persistence.CascadeType;
////import jakarta.persistence.Entity;
////import jakarta.persistence.GeneratedValue;
////import jakarta.persistence.GenerationType;
////import jakarta.persistence.Id;
////import jakarta.persistence.ManyToOne;
////import jakarta.persistence.OneToMany;
////
////@Entity
////public class Employee {
////	
////	@Id
////	@GeneratedValue(strategy = GenerationType.IDENTITY)
////	private int empId;
////	private String empName;
////	private int salary;
////	
////	@ElementCollection
////	private Set<> mn;
////	
////	@ManyToOne(cascade = CascadeType.ALL)
////	private Department dept;
////	
////	public Department getDept() {
////		return dept;
////	}
////	public void setDept(Department dept) {
////		this.dept = dept;
////	}
////	public int getEmpId() {
////		return empId;
////	}
////	public void setEmpId(int empId) {
////		this.empId = empId;
////	}
////	public String getEmpName() {
////		return empName;
////	}
////	public void setEmpName(String empName) {
////		this.empName = empName;
////	}
////	public int getSalary() {
////		return salary;
////	}
////	public void setSalary(int salary) {
////		this.salary = salary;
////	}
////	
////	public void 
////}
////
////
//
//package cg.demo.jpahibernate.entities;
//
//import java.util.Set;
//import jakarta.persistence.*;
//
//@Entity
//public class Employee {
//
//    @Id
//    private int id;
//
//    private String name;
//    private double salary;
//
//    @ElementCollection
//    private Set<String> mobileNumbers;
//
//    @ManyToOne
//    @JoinColumn(name = "dept_id")
//    private Department department;
//
//    public Employee() {}
//
//    public Employee(int id, String name, double salary) {
//        this.id = id;
//        this.name = name;
//        this.salary = salary;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//
//    public Set<String> getMobileNumbers() {
//        return mobileNumbers;
//    }
//
//    public void setMobileNumbers(Set<String> mobileNumbers) {
//        this.mobileNumbers = mobileNumbers;
//    }
//
//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }
//}
//
//


package cg.demo.associationmapping;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Eid;
	
	private String name;
	
	private int sal;
	
	@ElementCollection
    private Set<Long> phone;
	
	public Set<Long> getPhone() {
		return phone;
	}

	@Override
	public String toString() {
		return "Employee [Eid=" + Eid + ", name=" + name + ", sal=" + sal + ", phone=" + phone + ", dept=" + dept + "]";
	}

	public void setPhone(Set<Long> phone) {
		this.phone = phone;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Department dept;
	
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public int getEid() {
		return Eid;
	}

	public void setEid(int eid) {
		Eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}
	
	

}