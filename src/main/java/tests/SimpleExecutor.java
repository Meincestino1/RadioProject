package tests;

import java.time.LocalTime;
import java.util.concurrent.Executor;
import java.util.stream.IntStream;

public class SimpleExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }

    public static void main(String[] args) {
        Executor simpleExecutor = new SimpleExecutor();
        simpleExecutor.execute(() -> System.out.println(LocalTime.now()));
        simpleExecutor.execute(() -> System.out.println("Fuck you hard"));
        IntStream.range(0, 20).forEach(System.out::println);
    }
}
