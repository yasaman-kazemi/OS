import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Scheduler {
    private final LinkedList<Task> tasks = new LinkedList<>();
    private LinkedList<Task> inProgressTasks = new LinkedList<>();
    private int currentTime;

    public void addTask(Task task) {
        tasks.add(task);
    }

    private LinkedList<Task> setInProgressTasks() {
        LinkedList<Task> result = new LinkedList<>();
        while (true) {
            Task task = tasks.poll();
            if (task == null) break;
            if (task.arriveTime <= currentTime) {
                result.add(task);
            } else {
                tasks.addFirst(task);
                break;
            }
        }
        return result;
    }

    private void updateInProgressTasks() {
        inProgressTasks.addAll(setInProgressTasks());
        Collections.sort(inProgressTasks);
    }

    public void process() {
        tasks.sort(Comparator.comparingLong(o -> o.arriveTime));
        List<Task> finishedTasks = new LinkedList<>();
        List<Task> failedTasks = new LinkedList<>();
        while (!(tasks.isEmpty() && inProgressTasks.isEmpty())) {
            updateInProgressTasks();
            Task task = inProgressTasks.poll();
            currentTime++;
            if (task == null) continue;
            if (task.deadline < currentTime) {
                failedTasks.add(task);
                currentTime--;
            } else {
                task.remainingTime--;
                if (task.remainingTime == 0) {
                    task.isFinished = true;
                    task.finishedTime = currentTime;
                    System.out.println(task);
                    finishedTasks.add(task);
                } else {
                    inProgressTasks.addFirst(task);
                }
            }
        }
    }
}
