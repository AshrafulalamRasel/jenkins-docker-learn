package com.example.learn.dockerjenkins;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Slf4j
public class Practices {

    public void rt(){

        int [] arrayInt = new int[5];
        arrayInt[0] = 1;
        arrayInt[1] = 2;
        arrayInt[2] = 3;
        arrayInt[3] = 4;

        Arrays.stream(arrayInt).findFirst();

        log.info("Array:" + Arrays.toString(arrayInt));

        OptionalInt optional = OptionalInt.of(Arrays.stream(arrayInt).sum());
        log.info("Array Sum:" + optional.getAsInt());


        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(1);
        list.add(1);
        list.add(10);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(4);
        list.add(-9);
        list.add(6);
        list.add(6);
        list.add(8);
        list.add(3);
        list.add(-1);


        log.info("Array Values:" + Arrays.toString(list.toArray()));

        Set<Integer> setObj = new HashSet<>(list);
        log.info("Array Values In a Set:" + setObj);

        TreeSet<Integer> treeSet = new TreeSet<>(setObj);
        log.info("Set Values In TreeSet:" + treeSet);

        /*Java Stream Start................................................*/

        Stream<List<Integer>> streamObj = Stream.of(list);
        log.info("Array List Values In Stream:" + streamObj.collect(Collectors.toList()));

        //Note:-> Important: Need Unique List or Set Elements
        Map<Object,Integer> integerIntegerMap = treeSet.stream().collect(Collectors.toMap(Integer->Integer,Function.identity()));
        log.info("Array List Values In Stream Map:" + integerIntegerMap.get(5));

        log.info("Array List Values In Stream Map1:" + treeSet.stream().collect(Collectors.toMap(Integer->Integer,Function.identity())));

        log.info("Array List Values In Stream2:"+list.stream().collect(Collectors.toUnmodifiableList()));

        /*Java Stream End................................................*/


    }



}
