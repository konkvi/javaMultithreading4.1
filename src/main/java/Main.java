public class Main {

    static int operatorsCount = 5;

    public static void main(String[] args){
        CallCenter callCenter = new CallCenter();

        runCallCenter(callCenter);
        runOperatorsWork(callCenter, operatorsCount);
    }

    public static void runOperatorsWork(CallCenter callCenter, int operatorsCount) {
        Runnable operatorWork = new Operator(callCenter);
        for (int i = 0; i < operatorsCount; i++) {
            new Thread(operatorWork).start();
        }
    }

    public static void runCallCenter(CallCenter callCenter) {
        Runnable pbx = new Pbx(callCenter);
        new Thread(pbx).start();
    }

}
