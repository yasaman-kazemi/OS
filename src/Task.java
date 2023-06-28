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

    public Task(String name, int priority, long arriveTime, long cbt, long deadline) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.arriveTime = arriveTime;
        this.cbt = cbt;
        this.deadline = deadline;
        this.remainingTime = cbt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(long remainingTime) {
        this.remainingTime = remainingTime;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public long getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(long finishedTime) {
        this.finishedTime = finishedTime;
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
