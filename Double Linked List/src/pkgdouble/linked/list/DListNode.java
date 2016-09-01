/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgdouble.linked.list;

/**
 *
 * @author Raúl
 */

public class DListNode {
    //attributes
    int data;
    DListNode next;
    DListNode prev;
    
/*constructor starts next and prev in Null,receives "d" that 
    is the value of the element cotained in a new Node*/
    public DListNode(int d){    
        set_data(d);
        //next = null;
        set_next(null);
        set_prev(null);
    }
    
//This method gets the Data inside a Node
    int get_data(){
        return data;
    }
    
//This method gets the "Next" reference Node 
    DListNode get_next(){
        return next;
    }
    
//This method sets the data of an element in a node
    void set_data(int d){
        data = d;
    }
    
//This method sets the Next node reference, receives an object of type DListNode
    void set_next(DListNode n){
        next = n;
    }
    
//This method get the "previous" reference Node
    DListNode get_prev(){
        return prev;
    }
    
//This method sets the previous Node reference, receives an element of type DListNode
    void set_prev(DListNode m){
        prev = m;
    }
}

