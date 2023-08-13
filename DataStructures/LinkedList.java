package DataStructures;
//single Linked List
public class LinkedList {
    Node head;             //head of the list
    private int size;

    LinkedList(){
        size = 0;
    }

    public class Node{    //a node consists of data and reference
        int data;         //data can be integer or any type
        Node next;        //next is pointing to next node so its type is also node
        
        Node(int data){    //constructor of node
            this.data=data;
            this.next=null;
            size++;

        }
    }

    //inserting element at first
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //insert in the middle at given index
    public void addMiddle(int index, int data){
        Node newNode= new Node(data);
            if(index > size || index < 0){
                System.out.println("invalid index");
            }
            if( head==null || index == 0){
                newNode.next=head;
                head = newNode;
                return; 
            }
             Node currNode = head;
             for(int i=1; i<size; i++){
                if(i==index){
                    Node nextNode = currNode.next;
                    currNode.next = newNode;
                    newNode.next = nextNode;
                    break;
                }
                currNode = currNode.next;
             }
    }

    //inserting element in the last aka append
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node lastNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    //deleting the first node
    public void deleteFirst(){
        if(head==null){
            System.out.println("nothing to delete");
            return;
        }
        head = this.head.next;
        size--;
    }

    //deleting the last node
    public void deleteLast(){
         if(head==null){
            System.out.println("nothing to delete");
            return;
        }
        size--;
        if(head.next ==null){
            head = null;
            return;
        }
        Node currNode = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            currNode = currNode.next;
            lastNode = lastNode.next;
        }
        currNode.next = null;
    }

    //get the size of linkedlist
    public int getSize(){
        return size;
    }

    //reversing a linkedlist using recursion
    public Node reverseRec(Node head){        //as a new head is retured its return type is Node
        if(head == null ||head.next == null){
            return head; //as we're passing head as parameter, if list is empty it'll return head 
        }
        Node newHead = reverseRec(head.next); //at every recursion a new head is returned so we store it in newhead
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //reversing a linkedlist using iteration
    public void reverseIterative(){ //we need three pointers prev,curr,next
        if(head == null || head.next == null){
            return ;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }


    //printing the linkedlist
    public void printList(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "-->");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

public static void main(String args[]){
    LinkedList list = new LinkedList();
    list.addFirst(50);
    list.addFirst(40);
    list.addFirst(30);
    list.addFirst(20);
    list.printList();
    System.out.println("inserting 10 at front");
    list.addFirst(10);
    list.printList();
    System.out.println("size is " +list.getSize());
    System.out.println("inserting 70 in the last");
    list.addLast(70);
    list.printList();
    System.out.println("size is " +list.getSize());
    System.out.println("inserting 60 at index 5");
    list.addMiddle(5,60);
    list.printList();
    System.out.println("size is " +list.getSize());
    System.out.println("deleting first element");
    list.deleteFirst();
    list.printList();
    System.out.println("size is " +list.getSize());
    System.out.println("deleting last element");
    list.deleteLast();
    list.printList();
    System.out.println("size is " + list.getSize());
    System.out.println("reversing the list using recursion");
    list.head = list.reverseRec(list.head);
    list.printList();
    System.out.println("reversing the list using iteration");
    list.reverseIterative();
    list.printList();


}
}
