package oncall.domain;

import java.util.*;

public class Workers {
    Deque<Worker> workers;

    public Workers(List<String> workers) {
        validateDuplication(workers);
        this.workers = new LinkedList<>(workers.stream().map(Worker::new).toList());
    }

    private static void validateDuplication(List<String> workers) {
        Set<String> set = new HashSet<>(workers);
        if(set.size() != workers.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
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
