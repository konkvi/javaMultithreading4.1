public class Pbx implements Runnable {

    final int CALLS_COUNT = 40;
    final int CALLS_CADENCE = 500;

    private CallCenter callCenter;

    public Pbx(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        for (int i = 0; i < CALLS_COUNT; i++) {
            callCenter.getCall();
            try {
                Thread.sleep(CALLS_CADENCE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
