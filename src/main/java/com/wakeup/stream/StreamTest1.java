package com.wakeup.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        * 1. 流的常用创建方法
         */

        //1.1 使用Collection下的 stream() 和 parallelStream() 方法
        List<String> l = new ArrayList<>();
        Stream<String> stream = l.stream(); //获取一个顺序流
        Stream<String> parallelStream = l.parallelStream(); //获取一个并行流

        //1.2 使用Arrays 中的 stream() 方法，将数组转成流
        Integer[] nums = new Integer[10];
        Stream<Integer> streamArray = Arrays.stream(nums);

        //1.3 使用Stream中的静态方法：of()、iterate()、generate()
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,6,6,7,7,8,8,9,1,10);
        stream1.forEach(System.out::print);
        System.out.println("\n======================================");

        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(6);
        stream2.forEach(System.out::print); // 0 2 4 6 8 10
        System.out.println("\n======================================");

        Stream<Double> stream3 = Stream.generate(Math::random).limit(2);
        stream3.forEach(System.out::print);
        System.out.println("\n======================================");

        //1.4 使用 BufferedReader.lines() 方法，将每行内容转成流
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/stream/test.txt"));
        Stream<String> lineStream = reader.lines();
        lineStream.forEach(System.out::print);
        System.out.println("\n======================================");

        //1.5 使用 Pattern.splitAsStream() 方法，将字符串分隔成流
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
        stringStream.forEach(System.out::print);
        System.out.println("\n======================================");

        /*
        * 流的中间操作
        * 2.1 筛选与切片
        * filter：过滤流中的某些元素
        * limit(n)：获取n个元素
        * skip(n)：跳过n元素，配合limit(n)可实现分页
        * distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素
         */
        Stream<Integer> stream4 = Stream.of(1,2,3,4,5,6,6,7,7,8,8,9,1,10);

        stream4.filter(n -> n > 5)  // 6,6,7,7,8,8,9,10
                .distinct()   //6,7,8,9,10
                .skip(1 * 2)   // 8,9,10
                .limit(2)   //8,9
                .forEach(System.out::print);
        System.out.println("\n======================================");

        /*
        * 2.2 映射
        * map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        * flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
         */
        List<String> list = Arrays.asList("1,2,3","a,b,c");

        list.stream().map( n -> n.replaceAll(",",""))
                .forEach(System.out::println);   // 123,abc

        System.out.println("\n======================================");
        list.stream().flatMap( s -> {
            String[] strings = s.split(",");
            Stream<String> s1 = Arrays.stream(strings);
            return s1;              //1,2,3,a,b,c
        }).forEach(System.out::println);
        System.out.println("\n======================================");

        /*
        * 2.3 排序
        *  sorted()：自然排序，流中元素需实现Comparable接口
        * sorted(Comparator com)：定制排序，自定义Comparator排序器
         */
        List<String> list1 = Arrays.asList("aa", "ff", "dd");
        //String 类自身已实现Comparable接口
        list1.stream().sorted().forEach(System.out::println);// aa dd ff
        System.out.println("\n======================================");

        class Student {
            String name;
            int age;
            Student(String name, int age){
                this.name = name;
                this.age = age;
            }
            public void setName(String name) {
                this.name = name;
            }

            public void setAge(int age) {
                this.age = age;
            }


            public String getName(){
                return name;
            }
            public int getAge(){
                return age;
            }
        }

        Student s1 = new Student("aa", 10);
        Student s2 = new Student("bb", 20);
        Student s3 = new Student("aa", 30);
        Student s4 = new Student("dd", 40);
        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

        //自定义排序：先按姓名升序，姓名相同则按年龄升序
        studentList.stream().sorted(
                (o1, o2) ->  {
                    if (o1.getName().equals(o2.getName())) {
                        return o1.getAge() - o2.getAge();
                    }
                    else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
        ).forEach(line -> {
            System.out.print(line.getName());
            System.out.println(line.getAge());
        });
        System.out.println("\n======================================");


        List<Student> studentList2 = Arrays.asList(s1, s2);

        studentList2.stream()
                .peek(o -> o.setAge(100))
                .forEach(line -> {
                    System.out.print(line.getName());
                    System.out.println(line.getAge());
                });
        System.out.println("\n======================================");


        /*
        * 3 流的终止
        * 3.1 匹配、聚合操作
        * allMatch：接收一个 Predicate 函数，当流中每个元素都符合该断言时才返回true，否则返回false
        * noneMatch：接收一个 Predicate 函数，当流中每个元素都不符合该断言时才返回true，否则返回false
        * anyMatch：接收一个 Predicate 函数，只要流中有一个元素满足该断言则返回true，否则返回false
        * findFirst：返回流中第一个元素
        * findAny：返回流中的任意元素
        * count：返回流中元素的总个数
        * max：返回流中元素最大值
        * min：返回流中元素最小值
         */
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);

        boolean allMatch = list2.stream().allMatch(e -> e > 10); //false
        boolean noneMatch = list2.stream().noneMatch(e -> e > 10); //true
        boolean anyMatch = list2.stream().anyMatch(e -> e > 4);  //true

        Integer findFirst = list2.stream().findFirst().get(); //1
        Integer findAny = list2.stream().findAny().get(); //1

        long count = list2.stream().count(); //5
        Integer max = list2.stream().max(Integer::compareTo).get(); //5
        Integer min = list2.stream().min(Integer::compareTo).get(); //1

        System.out.println("allMatch:"+ allMatch + "\n"+
                "noneMatch:" + noneMatch + "\n" +
                "anyMatch:" + anyMatch + "\n" +
                "findFirst:" + findFirst + "\n" +
                "findAny:" + findAny + "\n" +
                "count:" + count + "\n" +
                "max:" + max + "\n" +
                "min:" + min + "\n");
        System.out.println("\n======================================");

        /*
        * 3.2 规约操作
        * Optional<T> reduce(BinaryOperator<T> accumulator)：
        *       第一次执行时，accumulator函数的第一个参数为流中的第一个元素，第二个参数为流中元素的第二个元素；
        *       第二次执行时，第一个参数为第一次函数执行的结果，第二个参数为流中的第三个元素；依次类推。
        * T reduce(T identity, BinaryOperator<T> accumulator)：
        *       流程跟上面一样，只是第一次执行时，accumulator函数的第一个参数为identity，而第二个参数为流中的第一个元素。
        * <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)：
        *       在串行流(stream)中，该方法跟第二个方法一样，即第三个参数combiner不会起作用。
        *       在并行流(parallelStream)中,我们知道流被fork join出多个线程进行执行，此时每个线程的执行流程就跟第二个方法reduce(identity,accumulator)一样，
        *               而第三个参数combiner函数，则是将每个线程的执行结果当成一个新的流，然后使用第一个方法reduce(accumulator)流程进行规约。
         */
        //经过测试，当元素个数小于24时，并行时线程数等于元素个数，当大于等于24时，并行时线程数为16
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);

        Integer v = list3.stream().reduce((x1, x2) -> x1 + x2).get();
        System.out.println(v);   // 300

        Integer v1 = list3.stream().reduce(10, Integer::sum);
        System.out.println(v1);  //310

        Integer v2 = list3.stream().reduce(0,
                (x1, x2) -> {
                    System.out.println( "stream accumulator: x1:" + x1 + "  x2:" + x2);
                    return x1 - x2;
                },
                (x1, x2) -> {

                    System.out.println("stream combiner: x1:" + x1 + "  x2:" + x2 );

                    return x1 * x2;
                });
        System.out.println(v2); // -300

        Integer v3 = list3.parallelStream().reduce(0,
                (x1, x2) -> {

                    //System.out.println(Thread.currentThread().getName() + "parallelStream accumulator: x1:" + x1 + "  x2:" + x2);
                    return x1 - x2;
                },
                (x1, x2) -> {

                    System.out.println(Thread.currentThread().getName()+ "parallelStream combiner: x1:" + x1 + "  x2:" + x2);
                    return x1 * x2;
                });

        System.out.println(v3); //197474048

        /*
        * 3.3 收集操作
        * collect：接收一个Collector实例，将流中元素收集成另外一个数据结构。
        * Collector<T, A, R> 是一个接口，有以下5个抽象方法：
        *   Supplier<A> supplier()：创建一个结果容器A
        *   BiConsumer<A, T> accumulator()：消费型接口，第一个参数为容器A，第二个参数为流中元素T。
        *   BinaryOperator<A> combiner()：函数接口，该参数的作用跟上一个方法(reduce)中的combiner参数一样，将并行流中各                                                                 个子进程的运行结果(accumulator函数操作后的容器A)进行合并。
        *   Function<A, R> finisher()：函数式接口，参数为：容器A，返回类型为：collect方法最终想要的结果R。
        *   Set<Characteristics> characteristics()：返回一个不可变的Set集合，用来表明该Collector的特征。有以下三个特征：
        *       CONCURRENT：表示此收集器支持并发。
        *       UNORDERED：表示该收集操作不会保留流中元素原有的顺序。
        *       IDENTITY_FINISH：表示finisher参数只是标识而已，可忽略。
         */
        Student ss1 = new Student("aa", 10);
        Student ss2 = new Student("bb", 20);
        Student ss3 = new Student("cc", 10);
        List<Student> list4 = Arrays.asList(ss1, ss2, ss3);

        //装成list
        List<Integer> ageList = list4.stream().map(Student::getAge).collect(Collectors.toList()); // [10, 20, 10]

        //转成set
        Set<Integer> ageSet = list4.stream().map(Student::getAge).collect(Collectors.toSet()); // [20, 10]

        //转成map,注:key不能相同，否则报错
        Map<String, Integer> studentMap = list4.stream().collect(Collectors.toMap(Student::getName, Student::getAge)); // {cc=10, bb=20, aa=10}

        //字符串分隔符连接
        String joinName = list4.stream().map(Student::getName).collect(Collectors.joining(",", "(", ")")); // (aa,bb,cc)

        //聚合操作
        //1.学生总数
        Long c = list4.stream().collect(Collectors.counting()); // 3
        //2.最大年龄 (最小的minBy同理)
        Integer maxAge = list4.stream().map(Student::getAge).collect(Collectors.maxBy(Integer::compare)).get(); // 20
        //3.所有人的年龄
        Integer sumAge = list4.stream().collect(Collectors.summingInt(Student::getAge)); // 40
        //4.平均年龄
        Double averageAge = list4.stream().collect(Collectors.averagingDouble(Student::getAge)); // 13.333333333333334
        // 带上以上所有方法
        DoubleSummaryStatistics statistics = list4.stream().collect(Collectors.summarizingDouble(Student::getAge));
        System.out.println("count:" + statistics.getCount() + ",max:" + statistics.getMax() + ",sum:" + statistics.getSum() + ",average:" + statistics.getAverage());

        //分组
        Map<Integer, List<Student>> ageMap = list4.stream().collect(Collectors.groupingBy(Student::getAge));
        //多重分组,先根据类型分再根据年龄分
        Map<String, Map<Integer, List<Student>>> typeAgeMap = list4.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getAge)));

        //分区
        //分成两部分，一部分大于10岁，一部分小于等于10岁
        Map<Boolean, List<Student>> partMap = list4.stream().collect(Collectors.partitioningBy(vv1 -> vv1.getAge() > 10));

        //规约
        Integer allAge = list4.stream().map(Student::getAge).collect(Collectors.reducing(Integer::sum)).get(); //40

    }
}
