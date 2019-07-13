package sync;

public class U1901Bank {
    int intTo = 0;
    int intFrom = 320;
    
    public synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.println(Thread.currentThread().getName() + String.format(" - before. intFrom: %d, intTo: %d", intFrom, intTo));
        intFrom -= intTransaction;
        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        intTo += intTransaction;
        System.out.println(Thread.currentThread().getName() + String.format(" - after. intFrom: %d, intTo: %d", intFrom, intTo));
    }
}
