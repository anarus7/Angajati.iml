package angajatiiapp.repository;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import angajatiiapp.model.DidacticFunction;
import angajatiiapp.model.Employee;
import angajatiiapp.validator.EmployeeValidator;

public class EmployeeMock implements EmployeeRepositoryInterface {

    private List<Employee> employeeList;
    private EmployeeValidator employeeValidator;

    public EmployeeMock() {
        employeeValidator = new EmployeeValidator();
        employeeList = new ArrayList<Employee>();

        Employee Ionel = new Employee(1,"Marius", "Pacuraru", "1234567890876", DidacticFunction.ASISTENT, 2500d);
        Employee Mihai = new Employee(2,"Ion", "Dumitrescu", "1234567890876", DidacticFunction.LECTURER, 2500d);
        Employee Ionela = new Employee(3,"Gicu", "Ionescu", "1234567890876", DidacticFunction.LECTURER, 2500d);
        Employee Mihaela = new Employee(4,"Dodel", "Pacuraru", "1234567890876", DidacticFunction.ASISTENT, 2500d);
        Employee Vasile = new Employee(5,"Dorel", "Georgescu", "1234567890876", DidacticFunction.TEACHER, 2500d);
        Employee Marin = new Employee(6,"Larson", "Puscas", "1234567890876", DidacticFunction.TEACHER, 2500d);

        employeeList.add(Ionel);
        employeeList.add(Mihai);
        employeeList.add(Ionela);
        employeeList.add(Mihaela);
        employeeList.add(Vasile);
        employeeList.add(Marin);
    }

    /**
     * adauga un angajat in repository
     *
     * @param employee - un angajat cu atributele id, nlastName, firstName, cnp,
     *                 function, salary;
     * @return boolean - false daca employee nu este valid
     */
    @Override
    public boolean addEmployee(Employee employee) {
        if (employeeValidator.isValid(employee)) {
            employeeList.add(employee);
            return true;
        }
        return false;
    }

    /**
     * Modifica atributul 'functia didactica' pentru un angajat dat
     *
     * @param employee    - anagajtul eptnru care se modifica atributul 'functia didactica'
     * @param newFunction - noua functie didactica (ASISTENT, LECTURER, TEACHER, CONFERENTIAR)
     */
    @Override
    public void modifyEmployeeFunction(Employee employee, DidacticFunction newFunction) {

        if (employee != null) {
            int i = 0;
            while (i < employeeList.size()) {
                if (employeeList.get(i).getId_index() == employee.getId_index())
                    employeeList.get(i).setFunction(newFunction);
                i++;
            }
        }
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeeByCriteria() {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }

    @Override
    public Employee findEmployeeById(int idOldEmployee) {
        return employeeList.stream()
                .filter(e -> e.getId_index() == idOldEmployee)
                .findFirst()
                .orElse(null);
    }

}