package com.kwq.algorithm.algorithmics.search;

import com.kwq.algorithm.algorithmics.seMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @auther : kongweiqiang
 * @DATE : 2019/7/5
 * @DESC :
 */
public class Binary {

    final static Logger logger= LoggerFactory.getLogger(seMain.class);

    public int BinarySearch( int [] ts, int key){
        int l=0;
        int s=ts.length-1;
        while(l<=s){
            int h=l+(s-l)/2;
            if(ts[h]==key){
                return ts[l];
            }else if(ts[h]>key){
                s=h-1;
            }else{
                l=h+1;
            }
        }
        return -1;
    }

}
