package Seminar_2;
import java.lang.Math.*;

public class Task5_Weight {
    int[] count;
    int[] weight;

    public Task5_Weight(int[] count, int[] weight) {
        this.count = count;
        this.weight = weight;
    }

    public int RandomWeight() {
        int sumel = sumEl(this.weight);
        int[] buf = new int[sumel];
        int total = 0;
        for (int i = 0; i < this.count.length; i++) {
            while (this.weight[i] != 0) {
                buf[total] = this.count[i];
                this.weight[i]--;
                total++;
            }
        }
        int rand = (int) (Math.random() * sumel);
        return buf[rand];
    }

    public int sumEl(int[] arr) {
        int sumel = 0;
        for (int i = 0; i < arr.length; i++){
            sumel += arr[i];
        }
        return sumel;
    }
}
