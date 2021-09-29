public class lab1 {
    public static void main(String[] args){
        System.out.println("---Задание 1---");
        System.out.println(lastNumber(126));

        System.out.println("---Задание 2---");
        System.out.println(sumOfNumbers(126));

        System.out.println("---Задание 3---");
        System.out.println(isPositive(1));
        System.out.println(isPositive(-1));
        System.out.println(isPositive(0));

        System.out.println("---Задание 4---");
        System.out.println(isPosOrNeg(1));
        System.out.println(isPosOrNeg(-1));
        System.out.println(isPosOrNeg(0));

        System.out.println("---Задание 5---");
        System.out.println(minNumber(2, 1,3));

        System.out.println("---Задание 6---");
        System.out.println(numberDescription(2));
        System.out.println(numberDescription(1));
        System.out.println(numberDescription(0));
        System.out.println(numberDescription(-1));
        System.out.println(numberDescription(-2));

        System.out.println("---Задание 7---");
        System.out.println(callPrice(905));
        System.out.println(callPrice(194));
        System.out.println(callPrice(491));
        System.out.println(callPrice(800));
        System.out.println(callPrice(100));

        System.out.println("---Задание 8---");
        System.out.println(massiveOperations(new int[]{1,-10,5,6,45,23, 45,-34,0,32,56,-1,2,-2}));

        System.out.println("---Задание 9---");
        System.out.println(mirrorMassive(new int[]{15,10,51, 6, 5,3, 10,-34,0,32,56, 12,24, 52}));

        System.out.println("---Задание 10---");
        System.out.println(zerosToEnd(new int[]{15,10,0,-6,-5,3,0,-34,0,32,56,0,24,52}));
    }
    //1. Ввести целое число в консоли и вывести на экран последнюю цифру введенного числа.
    static int lastNumber(int number){
        return (number % 10);
    }
    //2. Ввести целое трехзначное число в консоли и найти сумму цифр
    // этого трехзначного числа.
    static int sumOfNumbers(int number){
        /*поделить, прибавить остаток, поделить число, сначала*/
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return (sum);
    }
    //3. Ввести целое число в консоли. Если оно является положительным,
    // то прибавить к нему 1, в противном случае не изменять его. Вывести полученное число.
    static int isPositive(int number){
        if (number > 0){
            number+=1;
        }
        return number;
    }
    //4. Ввести целое число в консоли. Если оно является положительным,
    // то прибавить к нему 1; если отрицательным, то вычесть из него 2;
    // если нулевым, то заменить его на 10. Вывести полученное число.
    static int isPosOrNeg(int number){
        if (number > 0) {
            number+=1;
        }
        else if (number < 0){
            number-=2;
        }
        else{
            number=10;
        }
        return number;
    }
    //5. Ввести три целых числа с консоли. Вывести на экран наименьшее из них.
    static int minNumber(int a, int b, int c){
        int min=a;
        if (min > b){
            min=b;
        }
        if (min > c){
            min=c;
        }
        return min;
    }
    //6. Ввести целое число в консоли. Вывести его строку-описание вида
    // «отрицательное четное число», «нулевое число», «положительное нечетное число» и т. д.
    static String numberDescription(int number){
        String w1;
        String w2="";
        if (number > 0){
            w1="Положительное ";
        }
        else if (number < 0){
            w1="Отрицательное ";
        }
        else{
            w1="Нулевое ";
        }
        if((number % 2) == 0 & number !=0){
            w2="четное ";
        }
        else if ((number % 2) != 0 & number !=0){
            w2="не четное ";
        }
        return(w1 + w2 + "число");
    }
    //7. Написать программу, вычисляющую стоимость 10 минутного междугороднего разговора
    // в зависимости от кода города.
    // (Москва(905) - 4.15 руб. Ростов(194) - 1.98 руб. Краснодар(491) - 2.69 руб. Киров(800) - 5.00руб.).
    // Пользователь в консоли должен ввести код города, а в ответ от программы получить,
    // например, при вводе кода 905, - «Москва. Стоимость разговора: 41.5»
    static  String callPrice(int number){
        double price;
        double fullPrice;
        String city;
        switch (number){
            case (905):
                city="Москва";
                price=4.15;
                break;
            case (194):
                city="Ростов";
                price=1.98;
                break;
            case (491):
                city="Краснодар";
                price=2.69;
                break;
            case (800):
                city="Киров";
                price=5.00;
                break;
            default:
                return "Неверный код города";
        }
        fullPrice=price*10;
        //«Москва. Стоимость разговора: 41.5»
        return (city + ". Стоимость разговора: " + fullPrice);

    }
    //8. Дан массив целых чисел: [1,-10,5,6,45,23, 45,-34,0,32,56,-1,2,-2].
    // Для данного массива найти и вывести на экран: максимальное значение,
    // сумму положительных элементов, сумму четных отрицательных элементов,
    // количество положительных элементов, среднее арифметическое отрицательных элементов.
    static String massiveOperations(int[] numbers){
        int max=numbers[0];
        int sumPos=0;
        int sumChetNeg=0;
        int countPos=0;
        double avgNeg=0;
        double avgNegSum=0;
        int avgCountNeg=1;
        for (int i=0;i<numbers.length; i++){
            if (numbers[i]>max) max=numbers[i];
            if (numbers[i]>0) {
                sumPos+=numbers[i];
                countPos++;
            }
            if (numbers[i]<0){
                if (numbers[i]%2==0) sumChetNeg+=numbers[i];
                avgNegSum+=numbers[i];
                avgNeg=avgNegSum/avgCountNeg;
                avgCountNeg++;
            }
        }
        return("Максимальное значение: " +  max + "\nСумма положительных элементов: " + sumPos +
                "\nСумма четных отрицательных элементов: " + sumChetNeg +
                "\nКоличество положительных элементов: " + countPos +
                "\nСреднее арифметическое отрицательных элементов: " + avgNeg);
    }
    //9. Дан массив целых чисел: [15,10,51, 6, 5,3, 10,-34,0,32,56, 12,24, 52].
    // Переставить элементы массива в обратном порядке. Вывести результат в консоль.
    static String mirrorMassive(int[] numbers){
        int[] resultM = new int[numbers.length];
        String resultS="";
        for (int i=0;i<numbers.length;i++){
            resultM[numbers.length-1-i]=numbers[i];
        }
        for (int i = 0; i< resultM.length; i++){
            resultS=(resultS + resultM[i] + " ");
        }
        return resultS;
    }
    //10. Дан массив целых чисел: [15,10,0,-6,-5,3,0,-34,0,32,56,0,24,52].
    // Переместить нули в конец массива. Вывести результат в консоль.
    static String zerosToEnd(int[] numbers){
        /*если элемент не ноль то поставить на след место если ноль то в конец-переменная*/
        int[] resultM = new int[numbers.length];
        String resultS="";
        int j=0;
        int zerosCount =0;
        for (int i=0;i<numbers.length;i++){
            if (numbers[i] != 0){
                resultM[j]=numbers[i];
                j++;
            }
            else{
                resultM[resultM.length-1-zerosCount]=numbers[i];
                zerosCount++;
            }
        }
        for (int i = 0; i< resultM.length; i++){
            resultS=(resultS + resultM[i] + " ");
        }
        return resultS;
    }
}
