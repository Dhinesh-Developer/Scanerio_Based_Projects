package com.dk;

import java.util.*;

public class EmployeeManagement {

    Map<Integer,Employee> map = new HashMap<>();

    public void addEmployee(int id,String name,int age,String department,double salary){
        if(map.containsKey(id)){
            System.out.println("Employee with ID already exists");
        }

        Employee emp = new Employee(id,name,age,department,salary);
        map.put(id,emp);
        System.out.println("Employee added successfully!");
    }

    public void viewEmployee(){
        if(map==null){
            System.out.println("No Employee details Found");
        }else{
            System.out.println("Employee details: ");
            for(Employee x : map.values()){
                System.out.println(x);
            }
        }
    }

    public void searchEmployee(int id){
        Employee emp = map.get(id);
        if(emp == null){
            System.out.println("No Employee found with the ID: "+id);
        }else{
            System.out.println(emp);
        }
    }

    public void deleteEmployee(int id){
        Employee emp = map.get(id);
        if(emp == null){
            System.out.println("No suitable Employee with ID: "+id);
        }else{
            map.remove(id);
            System.out.println("Employee deleted successfully!");
        }
    }

    public void updateEmployee(int id,String name,int age,String department,double salary){
        Employee emp = map.get(id);
        if(emp == null){
            System.out.println("No Employee Found with the ID: "+id);
        }else{
            Employee newEmployee = new Employee(id,name,age,department,salary);
            map.put(id,newEmployee);
            System.out.println("Employee updated successfully!");
        }
    }


}
