package com.kwq.algorithm.listener;

import com.kwq.algorithm.event.SalaryEvent;

/**
 * @auther : kongweiqiang
 * @DATE : 2019/7/8
 * @DESC :
 */
public interface SalaryListener{

    void SalaryUpper(SalaryEvent salaryEvent);

    void SalaryDowner(SalaryEvent salaryEvent);

}
