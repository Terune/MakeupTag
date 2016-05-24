package kr.ac.kaist.makeuptag;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Created by BongJin Sohn on 2016-05-23.
 */


public class ItemSet implements Serializable{
    String description;
    ArrayList<Integer> imageList;

    ItemSet(){
        imageList = new ArrayList<>();
    }
}