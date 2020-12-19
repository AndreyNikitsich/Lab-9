package com.andrey;


import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static public void main(String[] args){
        try(FileInputStream fileInputStream= new FileInputStream("src//main//java//com.andrey//data.txt");
            Scanner fileScanner = new Scanner(fileInputStream)){

            List<Data> films = new ArrayList<>();
            while(fileScanner.hasNextLine()){
                String[] next = fileScanner.nextLine().split(";");
                films.add(new Data(next));
            }
            System.out.println("Grouping by genres: ");
            System.out.println(makeGroups(films));
            System.out.println("Shortest comedy duration:");
            System.out.println(findShortestComedyTime(films));
            System.out.println("Box office hit: :");
            System.out.println(findBoxOfficeHit(films,100));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    static public Integer findShortestComedyTime(List<Data> films){
        return films.stream().filter(p -> p.getGenres().contains("comedy"))
                .map(Data::getDuration)
                .reduce(Integer::min)
                .orElse(-1);
    }

    static public Map<String, List<Data>> makeGroups(List<Data> films){
        return films.stream().collect(Collectors.groupingBy(Data::getGenres));
    }


    static public Data findBoxOfficeHit(List<Data> films, int fees){
        return films.stream().filter(p -> p.getBoxOfficeFees()>fees).findFirst().get();
    }

}


//    Collection<String> collection = Arrays.asList("a1", "a2", "a3");
//    Stream<String> streamFromCollection = collection.stream();

//    Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");

//    String[] array = {"a1","a2","a3"};
//    Stream<String> streamFromArrays = Arrays.stream(array);

//    Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"))

//    IntStream streamFromString = "123".chars()

//    Stream.builder().add("a1").add("a2").add("a3").build()

//    Stream<String> stream = collection.parallelStream();

//    Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1)

//    Stream<String> streamFromGenerate = Stream.generate(() -> "a1")