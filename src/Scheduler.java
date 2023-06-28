import java.util.*;

public class Scheduler {
    private final LinkedList<Task> tasks = new LinkedList<>();
    private LinkedList<Task> inProgressTasks = new LinkedList<>();
    private ArrayList<Task> finalTasks = new ArrayList<>();
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
                finalTasks.add(task);
                currentTime--;
            } else {
                task.remainingTime--;
                if (task.remainingTime == 0) {
                    task.isFinished = true;
                    task.finishedTime = currentTime;
                    System.out.println(task);
                    finishedTasks.add(task);
                    finalTasks.add(task);
                } else {
                    inProgressTasks.addFirst(task);
                }
            }
        }
    }

    public LinkedList<Task> getTasks() {
        return tasks;
    }

    public LinkedList<Task> getInProgressTasks() {
        return inProgressTasks;
    }

    public void setInProgressTasks(LinkedList<Task> inProgressTasks) {
        this.inProgressTasks = inProgressTasks;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public ArrayList<Task> getFinalTasks() {
        return finalTasks;
    }

    public void setFinalTasks(ArrayList<Task> finalTasks) {
        this.finalTasks = finalTasks;
    }
}
