public class Operator implements Runnable {

    final int WORK_TIME = 2000;

    private CallCenter callCenter;

    public Operator(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        while (!callCenter.getCallsQueue().isEmpty()) {
            callCenter.handleCall();
            try {
                Thread.sleep(WORK_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
