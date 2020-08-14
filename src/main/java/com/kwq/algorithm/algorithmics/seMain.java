package com.kwq.algorithm.algorithmics;

import com.kwq.algorithm.event.SalaryEvent;
import com.kwq.algorithm.listener.impl.SalaryListenerImpl;
import com.kwq.algorithm.model.Person;
import com.kwq.algorithm.algorithmics.search.Binary;

/**
 * @auther : kongweiqiang
 * @DATE : 2019/7/5
 * @DESC :
 */
public class seMain {

//    final static Logger logger= LoggerFactory.getLogger(seMain.class);

    public static void main(String ... s){
        /*int [] nums={7,8,5,25,2,0,44,9};
        seMain seMain = new seMain();
        seMain.testBinarySearch(nums,44);*/

        Person person = new Person();
        person.setSalary(256);
        SalaryEvent salaryEvent = new SalaryEvent(person);
        SalaryListenerImpl salaryListener = new SalaryListenerImpl();
        person.setSalaryListener(salaryListener);
        person.work(salaryEvent);
        salaryEvent.down(20);
    }

    public void testBinarySearch(int [] nums,int key){
        Binary binary = new Binary();
        final int binarySearch = binary.BinarySearch(nums, key);
//        logger.info("二分查找结果: "+binarySearch);
    }

}
