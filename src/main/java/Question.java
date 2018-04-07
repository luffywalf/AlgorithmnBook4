/**
 * 算法书中的问题练习
 * Created by Ding on 06/04/2018.
 *
 * @author Ding
 */
public class Question {

    public interface Datable{
        int month();
        int day();
    }

    public static void main(String[] args){
        System.out.println("a".getBytes().length);
        System.out.println(isPrime(123333));
    }

    private static double sqrt(){
        //  TODO
        return 0.0;
    }

    private static boolean isPrime(int number){
        //  素数 是指 只能被1和她本身整除的数
        for(int i=2; i*i <= number; i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }
}
