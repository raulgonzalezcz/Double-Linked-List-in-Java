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

/*The Class DLinkedList construct every operation that is going to be selected 
from the Menu bar of the window*/
public class DLinkedList {
    /* atributes */
    DListNode head;
    
    /* this method sets head as null at the start of the program, because 
    the list is empty*/
    public DLinkedList(){
        head = null;
    }
    
    

    /* this method  receives an integer to add to the list
    , creates the node, and it will be placed at the end (Tail) of the list */
/*
   void AddNodeEnd(int d){ // insert a node at the end of a single linked list
       SListNode nuevo, temp;
       nuevo = new SListNode(d);
       if(head == null) 
           head = nuevo; 
       else{
           temp = head; 
           while(temp.sig != null)
               temp = temp.sig;
           temp.sig = nuevo;
       }
   }
*/
    
/*This method Receives an integer with the data that is going to be stored in a new Node,
and this will order the Nodes in ascendant order. But, if there is nothing in the Double linked list,
head is going to equal the new node.
This action will be executed when the user clicks "Add Node"*/
void addNodeOrdered(int d){ 
       DListNode nuevo, temp;
       nuevo = new DListNode(d);
       if(head == null) /* empty list */
           {
               head = nuevo; /* nuevo is the head of the list */
               }
       else{
           temp = head; /* temp strarts its track in head */
           while(temp.next != null && nuevo.data>temp.data)
		{
                    temp = temp.next;
		}
		if (temp == head && nuevo.data<head.data){
                    head = nuevo;
                    temp.prev = nuevo;
                    nuevo.next = temp;
                }
                else if(temp.next == null && temp.data<nuevo.data){
                    nuevo.prev = temp;
                    temp.next = nuevo;
                    nuevo.next = null;
                }
                else{
                    nuevo.prev = temp.prev;
                    temp.prev.next = nuevo;
                    nuevo.next = temp;
                    temp.prev = nuevo;
                }
       }
   }


/*This method receives an integer, it will delete the node that have the number inserted
in the message box after clicking "Delete one element". Also, connects the previous reference of the
deleted Node with the next reference of the same.
*/
   void eliminateNode(int d){ // delete a node in a single linked list
	DListNode temp,aux, aux2;
       
       if(head != null) /* empty list */
       {
           temp = head; /* temp starts his way from head */
	   aux = head;
           aux2= head;
           while(temp != null && temp.data < d)
		{
			aux = temp;
            		temp = temp.next;
		}
		if(temp != null && temp.data == d)
		{
                    if(temp == head){
			head = temp.next;
                    }
                    else{
                        if (temp.next == null){
                        aux.next = null;
                        temp.prev = null;
                        }
                        else{
                          aux2 = temp.next;
                          aux2.prev = aux;
                          aux.next = temp.next;  
                        }
                    }
                        
		}
		else
		{ // do nothing because d is not in the list
		}

       }
   }

/*This method inherits from the DListNode Class. His work is to travel all nodes 
   looking for the one that the user enters, receives an integer, and returns the
   position where it is stored*/
    DListNode searchNode(int d){ // search a node
       DListNode result = null;
       DListNode tem = head;
       
       while(tem != null && tem.get_data() != d){
            tem = tem.get_next();
       }
       if(tem!=null && tem.get_data() == d){
            result = tem;
       }
       return result;
   }

    /*Display the Nodes added in the execution of the program
    in the Text Area connected by "<->". This action is executed when the user clicks 
    "Show contents". To see a new element added is important to click "Show contents " again*/
   String displayList(){ // display the contents of a single linked list
       String contenido = "";
       DListNode tem = head;
       while(tem != null)
       {
           contenido = contenido + tem.data + "<->";
           tem = tem.next;
       }
       return contenido;
   }
}

