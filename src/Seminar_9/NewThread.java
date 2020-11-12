package Seminar_9;

public class NewThread extends Thread{
    @Override
    public void run() {
        System.out.println(getId() + " is run");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            interrupt();
        }
        System.out.println(getId() + " is closed");
    }

    public static void main(String[] args) {
        NewThread thread;
        for (int i = 0; i < 10; i++) {
            thread = new NewThread();
            thread.start();
            thread.interrupt();
        }
    }
}
