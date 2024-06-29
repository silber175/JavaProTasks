package JavaProKruchkovTask2;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaProKruchkovTask2 {


    public static void main(String[] args)   {

        List<Integer> integers = new ArrayList<>();
        integers.add(8);
        integers.add(5);
        integers.add(20);
        integers.add(14);
        integers.add(7);
        integers.add(8);
        integers.add(99);
        integers.add(4);
        integers.add(5);
        integers.add(20);
        integers.add(7);
        integers.add(14);
        integers.add(99);

        // 1
        Stream<Integer> intstream = integers.stream();
        intstream
                .distinct()
                .forEach(System.out::println);


        // 2
        Stream<Integer> intstream2 = integers.stream();
         Integer res1 =
          intstream2
                .sorted(Collections.reverseOrder())
                .limit(3)
                .skip(2)
                  .collect(Collectors.toList())
                  .getFirst() ;

        System.out.println(res1);







        // 3
        Stream<Integer> intstream3 = integers.stream();
        Integer res2 =
                intstream3
                        .distinct()
                        .sorted(Collections.reverseOrder())
                        .limit(3)
                        .skip(2)
                        .toList()
                        .get(0) ;

        System.out.println(res2);


        // 4

        List<Employer> employers = new ArrayList<>() ;
        employers.add(new Employer("Лена",27,"Инженер"));
        employers.add(new Employer("Мария",32,"Инженер"));
        employers.add(new Employer("Сергей",37,"Инженер"));
        employers.add(new Employer("Олег",45,"Инженер"));
        employers.add(new Employer("Александр",50,"Главный инженер"));


        Stream<Employer> emplStream = employers.stream();
        List<Employer> res3 = emplStream
                .filter(x->x.getCasta().equals("Инженер"))
                .sorted(Comparator.comparingDouble(Employer::getAge).reversed())
                .limit(3)
                .toList();
        for (int ii=0;ii<res3.size();ii++) {
            System.out.println(res3.get(ii).getAge());
        }

        // 5
        Stream<Employer> emplStream2 = employers.stream();
        double averAge =emplStream2
               .collect(
                        Collectors.filtering(x->x.getCasta().equals("Инженер"),
                                Collectors.averagingDouble(Employer::getAge)));;
        System.out.println(averAge);

                // 6
        List<String> stringList = new ArrayList<>();
        stringList.add("Синий");
        stringList.add("иней");
        stringList.add("бублики");
        stringList.add("ададжео");
        stringList.add("сопрано");
        stringList.add("оперный");
        stringList.add("дачный");
        stringList.add("ансабль");

        Stream<String> stringStream = stringList.stream();
        String str1 = stringStream
                .sorted(Comparator.comparingLong(String::length).reversed())
                .limit(1)
                .toList()
                .getFirst();
        System.out.println(str1);

        // 7
        String str2="а роза упала на лапу азора а роза упала на лапу";
        Map<String,Long> strMap = Arrays.stream(str2.split(" "))
                .collect(
                        Collectors.groupingBy(x->x, Collectors.counting())
                );
        System.out.println(strMap.toString());

         // 8
        Arrays.stream(str2.split(" "))
                .sorted(Comparator.comparing(String::length).thenComparing(x->x))
                .peek(System.out::println);

        // 9
        String[][] arrStr = new String[][]{
                {"эсминец","высокий","солнце","театральный","мореходный"},
                {"серебряный","музыкальный","городской","колумбийский","фиолетовый"},
                {"искусство","береговой","окружной","царскосельский","полупроводник"},
                {"заезженный","переправа","первоапрельский","радостный","воскресный"},
                {"математика","рыбалка","каникулы","гостиница","управление"},
                {"пролив","воздух","культура","речной","калибр"}
        };
         String str9 = Stream.of(arrStr)
        .flatMap(Stream::of)
                 .sorted(Comparator.comparingLong(String::length).reversed())
                 .toList()
                 .getFirst();
        System.out.println(str9);
    }
}
