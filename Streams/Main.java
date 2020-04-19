import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Person> people = getPeople();

        // Imperative approach ❌
      /* List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }
        females.forEach(System.out::println);
      */
        // Declarative approach ✅

        //Filter
        //This function will get the just female persons.
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

         females.forEach(System.out::println);


        //Sort
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge))     // Comparator.comparing(Person::getAge).reverse(), "reverse()" will be reverse the sorted stream.
                .collect(Collectors.toList());

          // sorted.forEach(person -> System.out.println(person)); can use as well as for output.
            sorted.forEach(System.out::println);

        //All match, it matches the given condition is true for all Persons and if it is then return true else false.
        boolean isMatched =  people.stream()
                .allMatch(person -> person.getAge() > 5);

        System.out.println(isMatched);

        // Any match,it matches the given condition if there is a person which is proper for the condition then true else false.

        boolean isAnyMatch =  people.stream()
                .anyMatch(person -> person.getAge() > 120);

        System.out.println(isAnyMatch);

        // None match,its reverse of anymatch logics.
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Cengiz"));

         System.out.println(noneMatch);

        // Max, It's find out the max value.
         people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // Min, It's find out the min value.
          people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // Group

        Map<Gender,List<Person>> groupByGender =  people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people1) -> {
                    System.out.println(gender);
                    people1.forEach(System.out::println);
                }
        );

        // Gets the name of the oldest female person and if exists give output.
        Optional<String> oldestFameAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

      //  oldestFameAge.ifPresent(System.out::println);

       // 1. Integer Stream
        IntStream.range(1,10).forEach(System.out::print);
        System.out.println();

       // 2. Integer Stream with skip,so output will start from 5 until seen the 5 It will not the print the output.
       IntStream
                .range(1,10)
                .skip(5)
                .forEach( x -> System.out.println(x));

       // 3. Integer Stream with sum
        System.out.println(
                IntStream
                .range(1,5)
                .sum());
        System.out.println();

        // 4.Stream.of, sorted and findFirst
        Stream.of("Ava","Aneri","Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        // 5.Stream from Array,sort,filter and print
        String [] names = {"Ali","Ankit","Brent","Sarika","Amanda","Hans","Shivika","Tayyip"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

        // 6. average of squares of an int array
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(x -> x * x)
                .average()
                 .ifPresent(System.out::println);

        // 7. Stream form List,filter and print
         List<String> peoples = Arrays.asList("Ali","Ankit","Brent","Sarika","Amanda","Hans","Shivika","Tayyip");
         peoples
                 .stream()
                 .map(String::toLowerCase)
                 .filter(x -> x.startsWith("a"))
                 .forEach(System.out::println);

         // 8. Stream rows from text file,sort.filter, and print
        Stream <String> bands = Files.lines(Paths.get("bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();

        // 9. Stream rows from text file and save to List.
        List<String> bands2 = Files.lines(Paths.get("bands.txt"))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));

        // 10. Stream fows from CSV file and count
        Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
        int rowCount  = (int) rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();
        // 11.Stream rows from CSV file, parse data from rows
        Stream <String> rows2 = Files.lines(Paths.get("data.txt"));
        rows2
                .map( x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15 )
                .forEach(x -> System.out.println(x[0]+ " "+ x[1] + " " + x[2]));
        rows2.close();

    }

    private static List<Person> getPeople(){
        return Arrays.asList(
                new Person("Tayip Barbaros", 20, Gender.MALE),
                new Person("Berkay Kadamli", 33, Gender.MALE),
                new Person("Ömer sefa", 57, Gender.MALE),
                new Person("Cengiz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 220, Gender.FEMALE),
                new Person("Gayduru cubbak cemile", 35, Gender.FEMALE)
        );
    }
}
