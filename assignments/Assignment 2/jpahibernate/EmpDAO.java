package cg.demo.jpahibernate;

import java.util.List;

import cg.demo.jpahibernate.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpDAO{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
    EntityManager em = emf.createEntityManager();

   
    public void insertEmployee(Employee emp) {

        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

   
    public Employee findEmployee(int id) {

        return em.find(Employee.class, id);
    }

   
    public List<Employee> getAllEmployees() {

        return em.createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }

   
    public void updateEmployee(Employee emp){

        em.getTransaction().begin();
        em.merge(emp);
        em.getTransaction().commit();
    }

   
    public void deleteEmployee(int id) {

       Employee emp = em.find(Employee.class, id);
//    	Employee emp1 = new Employee();
//    	emp1.setDepartment("ert");
//    	emp1.setId(1);
//    	emp1.setName("jjj");
//    	emp1.setSalary(234566);
    	
    	
        if (emp != null) {
            em.getTransaction().begin();
            em.remove(emp);
            em.getTransaction().commit();
        }
    }
    public List<Object[]> countEmployeeByDept(){

        return em.createQuery(
            "SELECT e.department, COUNT(e) FROM Employee e GROUP BY e.department",
            Object[].class
        ).getResultList();
    }
 // find all employees
    public List<Employee> findAllEmployees(){

        return em.createQuery(
                "SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }
    public List<Employee> findEmployeeByMobile(String mobile){

        return em.createQuery(
            "SELECT e FROM Employee e JOIN e.mobileNumbers m WHERE m = :mob",
            Employee.class)
            .setParameter("mob", mobile)
            .getResultList();
    }
    
    public List<Employee> employeesWithSameSalary(){

        return em.createQuery(
            "SELECT e FROM Employee e WHERE e.salary IN " +
            "(SELECT e2.salary FROM Employee e2 GROUP BY e2.salary HAVING COUNT(e2) > 1)",
            Employee.class
        ).getResultList();
    }
  
}