package oncall.domain;

import java.util.*;

public class Workers {
    Deque<Worker> workers;

    public Workers(List<String> workers) {
        this.workers = new LinkedList<>(workers.stream().map(Worker::new).toList());
    }

    public boolean empty() {
        return workers.isEmpty();
    }

    public Worker top() {
        return workers.peekFirst();
    }

    public void pop() {
        workers.poll();
    }

    public void pushFront(Worker worker) {
        workers.addFirst(worker);
    }
}
