import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

public class Demo {

    public static int doubleIt(int n){
        int answer = n*2 ;
        System.out.println("Inside doubleIt with n =" + n + " with thread = " + Thread.currentThread().getName() );

        try {
            Thread.sleep(100);
        } catch (Exception ignore){

        }
        return answer;
    }

    public static void main(String[] args) {
        Instant before = Instant.now();
        int answer = IntStream.of(1,3,2,6,9)
                .parallel()
                .map(Demo::doubleIt) //doubles each value
                //.sequential() // serial -> set to whatever last thing is set to
                .sum(); // need to be separate streams if you ant it to be serial in some parts + parallel others
        Instant after = Instant.now();

        Duration duration = Duration.between(before,after);
        System.out.println(answer);
        System.out.println("time: "+  duration.toMillis() + "ms");


        
        //.reduce()
    }
}
