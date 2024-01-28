public class ArrayList<T> implements List<T>{
private int max;
private int size;
private int currnt;
private T[] nodes;
 int id, parentId;

    
public ArrayList(){
size=0;
nodes=(T[])new Object[1000];
currnt=-1;

}
public boolean full(){
return size==max;
}

public boolean empty(){
return size==0;
}

public boolean last(){
return currnt==size-1;
}

public void findFirst(){
currnt=0;
}

public void findNext(){
currnt++;
}

public T retrieve(){
return nodes[currnt];
}

public void update(T e){
nodes[currnt]=e;}


public void insert(T e){

for(int i=size-1;i> currnt;i--){
nodes[i+1]=nodes[i];
}
currnt++;
nodes[currnt]=e;
size++;
}

public T remove(){
for(int i=currnt+1;i<size;i++){
nodes[i-1]=nodes[i];
}
size--;
if(size==0)
currnt=-1;
else if (currnt==size)
currnt=0;

return nodes[size];
}
}




