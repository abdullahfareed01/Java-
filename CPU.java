import java.util.Scanner;

public class CpuScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Getting number of processes
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        int[] processID = new int[n];
        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        // Getting process details
        for (int i = 0; i < n; i++) {
            processID[i] = i + 1;
            System.out.print("Enter arrival time for process " + processID[i] + ": ");
            arrivalTime[i] = sc.nextInt();
            System.out.print("Enter burst time for process " + processID[i] + ": ");
            burstTime[i] = sc.nextInt();
        }

        // Calculating waiting and turnaround times
        waitingTime[0] = 0;
        for (int i = 1; i < n; i++) {
            waitingTime[i] = burstTime[i - 1] + waitingTime[i - 1];
            waitingTime[i] -= arrivalTime[i]; // Adjust for arrival time
            totalWaitingTime += waitingTime[i];
        }

        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = burstTime[i] + waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        double avgWaitingTime = (double) totalWaitingTime / n;
        double avgTurnaroundTime = (double) totalTurnaroundTime / n;

        // Displaying results
        System.out.println("\nProcess\tArrival Time\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println(processID[i] + "\t\t" + arrivalTime[i] + "\t\t" + burstTime[i] + "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i]);
        }
        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
        System.out.print("Commit changes");
        sc.close();
    }
}
