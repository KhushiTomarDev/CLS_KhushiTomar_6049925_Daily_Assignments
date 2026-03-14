//package cg.demo.associationmapping;
//
//import java.util.List;
//import jakarta.persistence.*;
//import cg.demo.jpahibernate.entities.*;
//
//public class EmployeeDao {
//
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
//    EntityManager em = emf.createEntityManager();
//
//
//    // 1 Insert Employee
//    public void insertEmployee(Employee emp, int deptId) {
//
//        Department dept = em.find(Department.class, deptId);
//
//        emp.setDepartment(dept);
//
//        em.getTransaction().begin();
//        em.persist(emp);
//        em.getTransaction().commit();
//
//        System.out.println("Employee Inserted");
//    }
//
//
//    // 2 Fetch all Employees with department name
//    public void fetchEmployees() {
//
//        String jpql = "SELECT e FROM Employee e";
//
//        List<Employee> list = em.createQuery(jpql, Employee.class).getResultList();
//
//        for(Employee e : list)
//        {
//            System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary()
//            +" Dept:"+e.getDepartment().getName()
//            +" Manager:"+e.getDepartment().getManagerName());
//        }
//    }
//
//
//    // 3 Number of employees in each department
//    public void employeeCountByDept() {
//
//        String jpql =
//        "SELECT e.department.name, COUNT(e) FROM Employee e GROUP BY e.department.name";
//
//        List<Object[]> list = em.createQuery(jpql).getResultList();
//
//        for(Object[] obj : list)
//        {
//            System.out.println("Department: "+obj[0]+" Count:"+obj[1]);
//        }
//    }
//
//
//    // 4 Employees under given department name
//    public void employeesByDept(String deptName) {
//
//        String jpql =
//        "SELECT e FROM Employee e WHERE e.department.name = :dname";
//
//        List<Employee> list = em.createQuery(jpql,Employee.class)
//                .setParameter("dname", deptName)
//                .getResultList();
//
//        for(Employee e : list)
//        {
//            System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());
//        }
//    }
//
//
//    // 5 Find employee by mobile number
//    public void findByMobile(String mobile) {
//
//    	
//    	
//        String jpql =
//        "SELECT e FROM Employee e JOIN e.mobileNumbers m WHERE m = :mob";
//
//        List<Employee> list = em.createQuery(jpql,Employee.class)
//                .setParameter("mob", mobile)
//                .getResultList();
//
//        for(Employee e : list)
//        {
//            System.out.println(
//            e.getId()+" "+e.getName()
//            +" Dept:"+e.getDepartment().getName());
//        }
//    }
//}

package cg.demo.associationmapping;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * Hello world!
 *
 */
public class EmployeeDao
{
    
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
   	 	EntityManager em = emf.createEntityManager();
 


   	 	
   	 	//1. Insert Employees
   	 	public Employee InsertEmployee(Employee e) {
   	 		em.getTransaction().begin();
   	 		em.persist(e);
   	 		em.getTransaction().commit();
   	 		return e;
   	 	}

   	 	
   	 	//2. Find department by name
   	 	public Department findDeptByName(String name) {
//   	 		TypedQuery <Department> tquery = em.createQuery("Select d from Department d where d.name=:name ", Department.class);
//  	 		tquery.setParameter("name", name);
//	   	 	List<Department> list = tquery.getResultList();
//   	 	
//	   	    if(list.isEmpty()) {
//	   	        return null;
//	   	    }
//	
//	   	    return list.get(0);
   	 		

   	     CriteriaBuilder cb = em.getCriteriaBuilder();

   	     CriteriaQuery<Department> cq = cb.createQuery(Department.class);

   	     Root<Department> dept = cq.from(Department.class);

   	     cq.select(dept)
   	       .where(cb.equal(dept.get("name"), name));

   	     TypedQuery<Department> query = em.createQuery(cq);

   	     List<Department> list = query.getResultList();

   	     if(list.isEmpty()) {
   	         return null;
   	     }

   	     return list.get(0);
   	 }
   	 				
   	 	}
   	 	
   	 	// find all employees and with department details
   	 	public List<Employee> viewAllWithDept(){
   	 		//TypedQuery <Employee> tq= em.createQuery("select e  from Employee e JOIN e.dept d ", Employee.class);
   	 		CriteriaBuilder cb = em.getCriteriaBuilder();
	 		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	 		Root<Employee> root = cq.from(Employee.class);
	 		cq.select(root);
	 		TypedQuery<Employee> query = em.createQuery(cq);
	 		List<Employee> list = query.getResultList();
   	 		//List<Employee> list =tq.getResultList();
   	 		return list;
   	 		
   	 	}
   	 	
   	 	//3. number of employees working in each department
	   	 public List<Object[]> employeesInEachDepartment() {
	
	   	    //TypedQuery<Object[]> tq = em.createQuery(
	   	    //    "SELECT d.name, COUNT(e) FROM Employee e JOIN e.dept d GROUP BY d.name" , Object[].class);
	
	   	    //return tq.getResultList();
	   		 
	   		 
	   		CriteriaBuilder cb = em.getCriteriaBuilder();
	 		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
	 		Root<Employee> root = cq.from(Employee.class);
	 		
	 		Join<Employee, Department> deptJoin = root.join("dept");
	 		
	 		cq.multiselect(deptJoin.get("name"), cb.count(root))
	 	      .groupBy(deptJoin.get("name"));

	 		
	 		TypedQuery<Object[]> query = em.createQuery(cq);
	 		List<Object[]> list = query.getResultList();
	   		 
	   		 
	   		 return list;
	   		 
	   	}
	   	 
	   	//4. find employees by department
	   	public List<Employee> findEmployeesByDepartment(String deptName){

//	   	    TypedQuery<Employee> tq = em.createQuery(
//	   	        "SELECT e FROM Employee e JOIN e.dept d WHERE d.name = :deptName",
//	   	        Employee.class
//	   	    );
//
//	   	    tq.setParameter("deptName", deptName);
//
//	   	    return tq.getResultList();
	   		
	   		
	   		CriteriaBuilder cb = em.getCriteriaBuilder();
	 		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	 		Root<Employee> root = cq.from(Employee.class);
	 		
	 		Join<Employee, Department> deptJoin = root.join("dept");
	 		

	 	    cq.select(root)
	 	      .where(cb.equal(deptJoin.get("name"), deptName));

	 	    List<Employee> list = em.createQuery(cq).getResultList();

	 		return list;
	 		
	 		
	   		
	   		
	   	}
	   	 
	   	//5. find employee by mobile
	   	public List<Object[]> findEmployeeByMobile(Long mobile){
//
//	   		TypedQuery<Object[]> tq = em.createQuery(
//	   			    "SELECT e.Eid, e.name, d.name, d.managername FROM Employee e JOIN e.dept d JOIN e.phone p WHERE p = :mobile",Object[].class);
//
//	   	    tq.setParameter("mobile", mobile);
//
//	   	    return tq.getResultList();
	   		
	   		
	   		CriteriaBuilder cb = em.getCriteriaBuilder();
	 		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
	 		Root<Employee> root = cq.from(Employee.class);
	 		
	 		Join<Employee, Department> deptJoin = root.join("dept");	 		
	 	    Join<Employee, Long> phoneJoin = root.join("phone");

   		    cq.multiselect(
   		            root.get("Eid"),
   		            root.get("name"),
   		            deptJoin.get("name"),
   		            deptJoin.get("managername")
   		    );

   		    cq.where(cb.equal(phoneJoin, mobile));
	 		TypedQuery<Object[]> query = em.createQuery(cq);
	 		List<Object[]> list = query.getResultList();
	   		 
	   		return list;
	   	}
	   	
	   	//Get employee by salary
	   	public List<Employee> findEmployeesBySalary(int salary){
	   		CriteriaBuilder cb = em.getCriteriaBuilder();
	 		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	 		Root<Employee> root = cq.from(Employee.class);
	 		
	 		Predicate salaryPredict = cb.gt(root.get("sal"), salary);
	 		
	 		
	 		cq.select(root).where(salaryPredict);
	 		TypedQuery<Employee> query = em.createQuery(cq);
	 		List<Employee> list = query.getResultList();
   
   	 		return list;
	   		
	   	}
   	 	
   	 	
    }