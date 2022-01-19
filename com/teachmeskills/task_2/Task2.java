package com.teachmeskills.task_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create an ArrayList class collection with the name values of all the students in the group
 * With Streams:
 * - Return the number of people with your name (regardless of upper/lower case letters)
 * - Select all names starting with "a" (regardless of upper/lower case letters)
 * - Sort and return the first element of the collection or "Empty@" if the collection is empty
 */

public class Task2 {
    public static void main(String[] args) {
        List<String> students = getStudentsFromFile("src/student_names/C11-onl-student-names.txt");
        System.out.println("List of students: " + students);
        String name = "iVaN";
        System.out.println("Number of students with name 'Ivan': " + getNumberOfStudentWithName(students, name));
        String start = "a";
        System.out.println("Names start with 'a': " + getNamesStartWith(students, start));
        System.out.println("First name in sorted list: " + getFirstName(students));
    }

    private static List<String> getStudentsFromFile(String filePath) {
        Path path = Path.of(filePath);
        try {
            List<String> students = Files.readAllLines(path);
            return students;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private static int getNumberOfStudentWithName(List<String> students, String name) {
        return (int) students.stream()
                .filter(el -> el.equalsIgnoreCase(name))
                .count();
    }

    private static List<String> getNamesStartWith(List<String> students, String start) {
        return students.stream()
                .filter(el -> el.toLowerCase().startsWith(start.toLowerCase()))
                .collect(Collectors.toList());
    }

    private static String getFirstName(List<String> students) {
        return students.stream()
                .sorted()
                .findFirst()
                .orElseGet(() -> "Empty@");
    }
}