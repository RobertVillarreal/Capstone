package employee;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
 
@Stateless
public class EmployeeDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new employee:
    public void persist(Employee employee) {
        em.persist(employee);
    }
 
    // Retrieves all the employee:
    public List<Employee> getAllGuests() {
        TypedQuery<Employee> query = em.createQuery(
            "SELECT g FROM Employee g ORDER BY g.id", Employee.class);
        return query.getResultList();
    }
}