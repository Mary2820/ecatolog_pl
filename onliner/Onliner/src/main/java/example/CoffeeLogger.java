package example;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public final class CoffeeLogger {
    private final List<String> logs = new ArrayList<>();

    @Inject
    CoffeeLogger() {}

    public void log(String msg) {
        logs.add(msg);
    }

    public List<String> logs() {
        return new ArrayList<>(logs);
    }
}
