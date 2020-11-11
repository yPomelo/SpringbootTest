package com.yyy.dao;

import com.yyy.pojo.Department;
import com.yyy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer,Employee>();//创建一个部门表
        employees.put(1001,new Employee(1001,"AA","11111111@163.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","22222222@163.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","33333333@163.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","44444444@163.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","55555555@163.com",0,new Department(105,"后勤部")));
    }
    private static Integer initId = 1006;
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    public Collection<Employee> getAll(){
        return employees.values();
    }
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    public void deleteEmployee(Integer id){
        employees.remove(id);
    }
}
