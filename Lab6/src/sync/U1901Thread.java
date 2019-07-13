package sync;

public class U1901Thread extends Thread {
    public U1901Bank bankWork;
    public int intTrans;
    public long lngSleep;
    
    
    public U1901Thread(U1901Bank bankWork, int intTrans, long lngSleep) {
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
    }
    
    public void run() {
        
        
        bankWork.calc(intTrans, lngSleep);
        //----
        synchronized (bankWork) {
            bankWork.intFrom -= 100;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bankWork.intTo += 100;
        }
        //----
    }
}
