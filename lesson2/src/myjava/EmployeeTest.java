package myjava;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee emp = new Employee ();
        emp.setEmpId(101);
        emp.setName("Jane Smith");
        emp.setSsn ("012-34-5678");
        emp.setSalary(120_345.27);
        System.out.println ("Employee id:         " + emp.getEmpId());
        System.out.println ("Employee name:       " + emp.getName());
        System.out.println ("Employee Soc Sec #:  " + emp.getSsn());
        System.out.println ("Employee salary:     " + emp.getSalary());
        raiseSalary(emp, 0.2); 
        System.out.println ("Employee salary after raise:     " + emp.getSalary());
    }
    public static void raiseSalary(Employee e, double percent){
        //e = new Employee();
        e.setSalary(e.getSalary()*(1+percent));
    }
}