package thread;

public class ThreadInJava {

    
    static class ThreadA extends Thread {
      private String name;
      public ThreadA(String name) {
        this.name = name;
      }
      @Override public void run() {
        // Code to be executed in the thread
        for (int i = 0; i <= 10; i++) {
          if(i % 2 == 0){
          System.out.println(" Thread A: " + i);
          try {
            Thread.sleep( 1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
      
          }
        }
      }
      }
    }

    static class ThreadB extends Thread {
      private String name;
      public ThreadB(String name) {
        this.name = name;
      }
      @Override public void run() {
        // Code to be executed in the thread
        for (int i = 0; i <= 10; i++) {
          if(i % 2 != 0){
          System.out.println(" Thread B: " + i);
          try {
            Thread.sleep( 1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
      
          }
        }
      }
      }
    }

      public static void main(String[] args) {
        // Create two threads  
        Thread threadA = new ThreadA("Thread A");
        Thread threadB = new ThreadB("Thread B"); 
    
        threadA.start();
        threadB.start(); 
       
       
        }
      
    }
  