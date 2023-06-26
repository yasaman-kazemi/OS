import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter number of tasks: ");
        int n = scanner.nextInt();
        int id = 0;
        for (int i = 0; i < n; i++) {
            int priority = scanner.nextInt();
            String name = scanner.next();
            int arrival = scanner.nextInt();
            int deadline = scanner.nextInt();
            int cbt = scanner.nextInt();
            Task task = new Task(id++, name, priority, arrival, cbt, deadline);
            scheduler.addTask(task);
        }
        System.out.println("start");
        scheduler.process();
    }
}