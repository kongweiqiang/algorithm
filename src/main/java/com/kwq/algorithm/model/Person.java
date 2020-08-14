package com.kwq.algorithm.model;

import com.kwq.algorithm.event.SalaryEvent;
import com.kwq.algorithm.listener.SalaryListener;

/**
 * @auther : kongweiqiang
 * @DATE : 2019/7/8
 * @DESC :
 */
public class Person {

    private float salary;

    private SalaryListener salaryListener;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public SalaryListener getSalaryListener() {
        return salaryListener;
    }

    public void setSalaryListener(SalaryListener salaryListener) {
        this.salaryListener = salaryListener;
    }

    public void work(SalaryEvent event){
        salaryListener.SalaryUpper(event);
    }
}
