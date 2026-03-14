////package cg.demo.associationmapping;
////
////import java.util.List;
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
////public class Department {
////	
////	@Id
////	@GeneratedValue(strategy = GenerationType.IDENTITY)
////	private int deptId;
////	private String deptName;
////	private String managerName;
////	
////	@OneToMany(cascade = CascadeType.ALL)
////	private List<Employee> employee;
////	
////	public List<Employee> getEmployee() {
////		return employee;
////	}
////	public void setEmployee(List<Employee> employee) {
////		this.employee = employee;
////	}
////	public int getDeptId() {
////		return deptId;
////	}
////	public void setDeptId(int deptId) {
////		this.deptId = deptId;
////	}
////	public String getDeptName() {
////		return deptName;
////	}
////	public void setDeptName(String deptName) {
////		this.deptName = deptName;
////	}
////	public String getManagerName() {
////		return managerName;
////	}
////	public void setManagerName(String managerName) {
////		this.managerName = managerName;
////	} 
////	
////}
//
//package cg.demo.associationmapping;
//
//import java.util.List;
//import jakarta.persistence.*;
//
//@Entity
//public class Department {
//
//    @Id
//    private int id;
//
//    private String name;
//    private String managerName;
//
//    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//    private List<Employee> employees;
//
//    public Department() {}
//
//    public Department(int id, String name, String managerName) {
//        this.id = id;
//        this.name = name;
//        this.managerName = managerName;
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
//    public String getManagerName() {
//        return managerName;
//    }
//
//    public void setManagerName(String managerName) {
//        this.managerName = managerName;
//    }
//
//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }
//}

package cg.demo.associationmapping;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Did;
	
	private String name;
	
	private String managername;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "dept")
	private List<Employee> emp;

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
	    this.emp = emp;
	}

	public int getDid() {
		return Did;
	}

	public void setDid(int did) {
		Did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}
	
	

}