package basic;

class Table{  
	void printTableNotSynchronized(int n){
		for(int i=1;i<=5;i++){  
			System.out.println("NotSynchronized: " + n*i);  
			try{  
				Thread.sleep(400);  
			}catch(Exception e){
				System.out.println(e);
			}  
		}  
	}
	
	synchronized void printTableSynchronized(int n){
		for(int i=1;i<=5;i++){  
			System.out.println("Synchronized: " + n*i);  
			try{  
				Thread.sleep(400);  
			}catch(Exception e){
				System.out.println(e);
			}  
		}  
	}
	
	void printTableSynchronizedBlock(int n){
		synchronized(this) {
			for(int i=1;i<=5;i++){  
				System.out.println("SynchronizedBlock: " + n*i);  
				try{  
					Thread.sleep(400);  
				}catch(Exception e){
					System.out.println(e);
				}  
			}  
		}
	}
}  
  
class MyThread1 extends Thread{  
	Table t;  

	MyThread1(Table t){  
		this.t=t;  
	}  

	public void run(){  
		t.printTableNotSynchronized(5);
		t.printTableSynchronized(5);
		t.printTableSynchronizedBlock(5);
	}  
}  

class MyThread2 extends Thread{  
	Table t;  

	MyThread2(Table t){  
		this.t=t;  
	}  

	public void run(){  
		t.printTableNotSynchronized(5);
		t.printTableSynchronized(5);
		t.printTableSynchronizedBlock(5);
	}  
}  
  
public class SynchronizedDemo{  
	public static void main(String args[]){  
		Table obj = new Table();//only one object  
		MyThread1 t1=new MyThread1(obj);  
		MyThread2 t2=new MyThread2(obj);  
		t1.start();  
		t2.start();  
	}  
}  