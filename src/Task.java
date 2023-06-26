public class Task implements Comparable<Task> {
    int id;
    String name;
    int priority;
    long arriveTime;
    long cbt;
    long deadline;
    long remainingTime;
    boolean isFinished;
    long finishedTime = 0;

    public Task(int id, String name, int priority, long arriveTime, long cbt, long deadline) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.arriveTime = arriveTime;
        this.cbt = cbt;
        this.deadline = deadline;
        this.remainingTime = cbt;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public long getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(long arriveTime) {
        this.arriveTime = arriveTime;
    }

    public long getCbt() {
        return cbt;
    }

    public void setCbt(long cbt) {
        this.cbt = cbt;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }


    public String toString2() {
        return "Task " + name + ", remaining time: " + remainingTime;
    }

    @Override
    public String toString() {
        return "Task " + "id=" + name + ", arriveTime=" + arriveTime + ", cbt=" + cbt + ", finish at=" + finishedTime +

                ", deadline=" + deadline + ", isFinished.";
    }

    @Override
    public int compareTo(Task o) {
        if (priority == o.priority)
            return Long.compare(deadline, o.deadline);
        else return Long.compare(priority, o.priority);
    }
}
