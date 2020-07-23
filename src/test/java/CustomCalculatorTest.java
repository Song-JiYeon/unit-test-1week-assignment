
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    //더하기 테스트 작성
    @Test
    public void add() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(10,15);
        /* 이곳에 테스트 코드를 작성하세요. */

        assertTrue(result==25);
        assertThat(result, is(25));
        assertThat(result, equalTo(25));

        System.out.println("result :: " + result);
    }
    //더하기 테스트 작성 추가
    @Test
    public void addTest() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(10,15);

        assertFalse(result == 20);

        System.out.println("result :: " + result);
    }

    //빼기 테스트 작성
    @Test
    public void subtract() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        /* 이곳에 테스트 코드를 작성하세요. */

        assertTrue(result == 13);
        assertThat(result, is(13));
        assertThat(result, equalTo(13));

        System.out.println("result :: " + result);
    }

    //빼기 테스트 작성 추가
    @Test
    public void subtractTest(){
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(10,5);

        assertFalse(result == 2);

        System.out.println("result :: " + result);
    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        /* 이곳에 테스트 코드를 작성하세요. */

        assertTrue(result==45);
        assertThat(result,is(45));
        assertThat(result, equalTo(45));

        System.out.println("result :: " + result);
    }

    //곱하기 테스트 작성 추가
    @Test
    public void multiplyTest() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(4,5);

        assertFalse(result==30);

        System.out.println("result :: " + result);
    }

    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        /* 이곳에 테스트 코드를 작성하세요. */

        assertTrue(result==5);
        assertThat(result,is(5));
        assertThat(result, equalTo(5));

        System.out.println("result :: " + result);
    }
    //나누기 테스트 작성 추가
    @Test
    public void divideTest() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(10,5);

        assertFalse(result==5);

        System.out.println("result :: " + result);
    }

    @Test(timeout = 4000)
    public void timeInMethodTest() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test(timeout = 4000)
    public void 시간제한체크() throws InterruptedException {
        Thread.sleep(2000);
    }

    //추가
    @Test(timeout = 5000)
    public void 시간제한체크1() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsEmptyOutofBoundException(){

        new ArrayList<Object>().get(0);
    }

    //추가
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsEmptyOutofBoundException1(){

        new ArrayList<Object>().get(1);
    }

    @Test
    public void isEmptyArray(){
        ArrayList<Object> myList = new ArrayList<>();
        assertThat(myList, is(empty()));

        ArrayList<Object> testList = new ArrayList<>();
        assertThat(testList, is(empty()));
    }

    //void 사용 이유 = test method는 return 값이 없다.

}