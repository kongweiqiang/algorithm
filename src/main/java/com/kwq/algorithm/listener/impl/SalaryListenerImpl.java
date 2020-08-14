package com.kwq.algorithm.listener.impl;

import com.kwq.algorithm.event.SalaryEvent;
import com.kwq.algorithm.listener.SalaryListener;

/**
 * @auther : kongweiqiang
 * @DATE : 2019/7/8
 * @DESC :
 */
public class SalaryListenerImpl implements SalaryListener {
    @Override
    public void SalaryUpper(SalaryEvent salaryEvent) {
        salaryEvent.add(10);
        System.out.println("工资增加10");
    }

    @Override
    public void SalaryDowner(SalaryEvent salaryEvent) {
        salaryEvent.down(5);
        System.out.println("工资减少5");
    }
}
