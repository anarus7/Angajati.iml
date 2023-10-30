package angajatiiapp.repository;

import angajatiiapp.model.DidacticFunction;
import angajatiiapp.model.Employee;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {


    EmployeeMock employeeMock = new EmployeeMock();

    @Test
    void testAddInvalidNameAndLastname() {
        Employee employee = new Employee(1,"M", "P", "2930907303711", DidacticFunction.ASISTENT, 2.600);
        assertFalse(employeeMock.addEmployee(employee));

    }

    @Test
    void testAddValidCnp() {
        Employee employee = new Employee(1,"Mihaela", "Pacurar", "2930907303711", DidacticFunction.ASISTENT, 2.600);
        assertTrue(employeeMock.addEmployee(employee));

    }


    @Test
    void testAddValidNameAndLastName() {
        Employee employee = new Employee(1,"Mihaela", "Pacurar", "2930907303711", DidacticFunction.ASISTENT, 2.600);
        assertTrue(employeeMock.addEmployee(employee));


    }

    @Test
    void testAddEmployeeInvalidCnp() {
        Employee employee = new Employee(1,"Mihaela", "Pacurar", "29303711M", DidacticFunction.ASISTENT, 2.600);
        assertFalse(employeeMock.addEmployee(employee));
    }



    @Test
    public void testModifyEmployeeFunction() {
        //Arrange
        // Choose an existing employee to modify (you may need to find one in the employeeList)
        int employeeIdToModify = 1; // Adjust this ID as per your data

        // Find the existing employee by ID
        Employee existingEmployee = employeeMock.findEmployeeById(employeeIdToModify);

        // Verify that the existing employee is not null
        assertNotNull(existingEmployee, "Existing employee is null. Employee ID: " + employeeIdToModify);
        assertEquals(DidacticFunction.ASISTENT, existingEmployee.getFunction());

        // Define the new function
        DidacticFunction newFunction = DidacticFunction.LECTURER;

        //Act
        // Modify the function of the existing employee
        employeeMock.modifyEmployeeFunction(existingEmployee, newFunction);

        //Assert=verify
        // Retrieve the modified employee (optional)
        Employee modifiedEmployee = employeeMock.findEmployeeById(employeeIdToModify);

        // Verify that the function of the employee has been updated
        assertNotNull(modifiedEmployee, "Modified employee is null. Employee ID: " + employeeIdToModify);
        assertEquals(newFunction, modifiedEmployee.getFunction());
    }



    @Test
    public void testModifyEmployeeFunctionInvalid(){

        int nonExistingemployee= 30;

        Employee existingEmployee=employeeMock.findEmployeeById(nonExistingemployee);

       assertNull(existingEmployee);

       DidacticFunction newDidacticF=DidacticFunction.TEACHER;

       employeeMock.modifyEmployeeFunction(existingEmployee,newDidacticF);

       Employee notModifiedemployee=employeeMock.findEmployeeById(nonExistingemployee);

       assertNull(notModifiedemployee,"Employee function remains unchanged for non existing ID " + nonExistingemployee);




    }


}





