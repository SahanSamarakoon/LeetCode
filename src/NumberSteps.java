public class NumberSteps {
    public int numberOfSteps(int num) {
        int steps =0;
        return stepsCal(num, steps);
    }

    public int stepsCal(int num, int steps){
        if (num == 0 ){
            return steps;
        }else {
            if (num%2==0){
                num = num/2;
            }else{
                num = num-1;
            }
            return stepsCal(num, steps+1);
        }
    }
}
