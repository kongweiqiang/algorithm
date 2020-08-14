package com.kwq.algorithm.event;

import com.kwq.algorithm.model.Person;

/**
 * @auther : kongweiqiang
 * @DATE : 2019/7/8
 * @DESC :
 */
public class SalaryEvent {

    private Person person;

    public SalaryEvent(Person person){
        this.person=person;

    }

    public void add(float salary){
        person.setSalary(person.getSalary()+salary);
        System.out.println(person.getSalary());
    };

    public void down(float salary){
        person.setSalary(person.getSalary()-salary);
        System.out.println(person.getSalary());
    };

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
