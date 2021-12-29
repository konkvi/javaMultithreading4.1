import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {
    private static int callsCounter;
    private volatile Queue<Call> callsQueue;

    public CallCenter() {
        callsQueue = new ConcurrentLinkedQueue<>();
    }

    public void getCall() {
        Call call = new Call("" + ++callsCounter);
        callsQueue.add(call);
        System.out.printf("Поступил новый звонок:%s%n", callsCounter);
    }

    public void handleCall() {
        if (!callsQueue.isEmpty())
            System.out.printf("Звонок %s обработан%n", callsQueue.poll().getId());
    }

    public Queue<Call> getCallsQueue() {
        return callsQueue;
    }
}
