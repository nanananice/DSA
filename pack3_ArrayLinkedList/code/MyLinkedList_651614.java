package code;

public class MyLinkedList_651614 {
    public class Node {
        int data;
        Node next;
        public Node(int d) {
        data = d;
        }
    }

    Node head = null;

    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while(p!=null) {
        sb.append("--> [");
        sb.append(p.data);
        sb.append("] ");
        p = p.next;
        }
        sb.append("-> null");
        return new String(sb);
    }

    public int getAt(int i) {
        Node p = head;
        while(i>0) {
        p = p.next;
        i--;
        }
        return p.data;
        }
        public void setAt(int d, int i) {
        Node p = head;
        while(i>0) {
        p = p.next;
        i--;
        }
        p.data = d;
    }

    public void add(int d) {
        Node p = new Node(d);
        p.next = head;
        head = p;
    }

    public void delete(int d) {
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while( (p.next!=null) && (p.next.data!=d) ) {
        p = p.next;
        }
        if(p.next!=null) {
        p.next = p.next.next;
        }
        head = t.next;
    }

    public int insert(int d) {
        Node p = new Node(d);
        p.next = head;
        head = p;
    
        Node current = head, index = null;
        int temp;
        int count = 0;
    
        if (head == null) {
            return count;
        } else {
            while (current != null) {
                index = current.next;
    
                while (index != null) {
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
    
                    index = index.next;
                }
                current = current.next;
                count++;
            }
        }
    
        return count;
    }

    public int find(int d) {
        int index = 0;
        Node p = head;
        while(p!=null) {
        if(p.data==d) return index;
        p = p.next;
        index += 1;
        }
        return index;
    }

    private int size() {
        int index = 0;
        Node p = head;
        while(p!=null) {
            p = p.next;                   
            index +=1;
        }
        return index;
    }
    
    public void add(int[] d) {
        for (int i = d.length - 1; i >= 0; i--) {
            add(d[i]);
        }
    }

    public void insert(int [] d) {
        for (Integer value:d) {
            insert(value);
        }
    }

    public void append(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void q1_rotate_counter_clockwise(int k) {
        if (k>size()){
            return;
        }
        for (int i = 0; i < k; i++) {
            Node a = head;
            Node b = head;
            append(b.data);
            while (a.next != null) {
                a = a.next;
            }

            head = head.next;

        }
    }

    public void q2_reverse() {
        int size = size();
        int[] reversedArray = new int[size];
        Node p = head;
        for (int i = size - 1; i >= 0; i--) {
            reversedArray[i] = p.data;
            p = p.next;
        }
        head = null;
        add(reversedArray);
    }

    public void q3_remove_dup(){
        Node first = head; 
        Node index,replace = null;
        if(head == null) {  
            return;  
        }  
        else {  
            while(first != null){  
           
                replace = first;  
     
                index = first.next;  
  
                while(index != null) {  
  
                    if(first.data == index.data) {  

                        replace.next = index.next;  
                    }  
                    else {  

                        replace = index;  
                    }  
                    index = index.next;  
                }  
                first = first.next;  
            }  
        }  
    }

    public void q4_increment_digits() {
        Node a = head;
        Node lastNonNine = null;

        while (a != null) {
            if (a.data != 9) {
                lastNonNine = a;
            }
            a = a.next;
        }

        if (lastNonNine != null) {
            lastNonNine.data++;
            a = lastNonNine.next;

            while (a != null) {
                a.data = 0;
                a = a.next;
            }
        } else {

            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
    }

    public boolean q5_isPalindrome() {
        int size = size();
        int[] array = new int[size];
        Node p = head;

        for (int i = 0; i < size; i++) {
            array[i] = p.data;
            p = p.next;
        }

        for (int i = 0, j = size - 1; i < j; i++, j--) {
            if (array[i] != array[j]) {
                return false;
            }
        }
    
        return true;
    }
    
    
}
