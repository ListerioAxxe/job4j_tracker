package ru.job4j.stream.attestation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * Метод averageScore вычисляет общий средний балл.
     *
     * @param stream принимает поток
     * @return возвращает средний балл
     * для реализации понадобятся методы:
     * <p>
     * - flatMap() для преобразования в поток объектов Subject;
     * <p>
     * - mapToInt() для последующего преобразования в поток оценок по каждому предмету;
     * <p>
     * - average() для расчета среднего бала по предмету;
     * <p>
     * - orElse() для того чтобы вернуть значение по умолчанию.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects().stream())
                .mapToInt(x -> x.getScore()).average().orElse(0);
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     *
     * @param stream принимает поток
     * @return Возвращает список из объекта Tuple (имя ученика и средний балл).
     * - метод map() для преобразования в поток объектов класса Tuple, внутри метода мы
     * будем создавать эти объекты - там будет фигурировать строка new Tuple();
     * <p>
     * - при этом в конструктор первым параметром будет передаваться имя текущего
     * объекта Pupil - используем соответствующий геттер;
     * <p>
     * - вторым параметром рассчитанный средний балл - расчет можно произвести по
     * той же последовательности, что описана для метода averageScore;
     * <p>
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(), x.getSubjects().stream()
                .mapToInt(Subject::getScore).average().orElse(0D))).collect(Collectors.toList());
    }

    /**
     *реализация этого метода несколько сложна, поскольку в данном случае
     * требуется выполнить промежуточный сбор данных в Map(). Опишем вкратце алгоритм:
     * - flatMap() для преобразования в поток объектов Subject;
     * - метод collect() в который мы передаем метод
     * groupingBy() (минимум с двумя параметрами)
     * класса Collectors. При этом карта собирается следующим образом: ключ - это имя предмета,
     * значение - средний балл по этому предмету для каждого ученика.
     * Для расчета среднего балла используйте метод averagingDouble() класса Collectors;
     * - после этого собранную карту мы разбираем с помощью
     * entrySet() и открываем поток спомощью stream();
     * - полученный поток с помощью map() преобразуем
     * в поток объектов класса Tuple, внутри метода мы
     * будем создавать эти объекты - там будет фигурировать строка new Tuple();
     * - в конструктор мы будем передавать параметры с помощью методов
     * getKey() и getValue() интерфейса Entry;
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     */

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(subj -> subj.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)
        )).entrySet().stream().map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .collect(Collectors.toList());
    }

    /**
     *для реализации данного метода можно использовать метод averageScoreBySubject
     *  за исключением следующих особенностей:
     * - в данном методе мы рассчитываем суммарный балл, а не средний - поэтому вместо average()
     * нужно использовать метод sum();
     * - терминальной операцией будет не метод collect(), а
     * использование метода max(), в который будем
     * передавать компаратор. При этом компаратор определит объект Tuple,
     * у которого значение Score будет максимальным;
     * - orElse() для того чтобы вернуть значение по умолчанию.
     * @param stream
     * @return
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(tuple -> new Tuple(tuple.getName(), tuple.getSubjects()
                .stream().mapToInt(y -> y.getScore()).sum()))
                .max(Comparator.comparing(x -> x.getScore())).orElse(new Tuple("Ivan", 5));
    }

    /**
     для реализации данного метода можно использовать
     метод averageScoreByPupil за исключением следующих особенностей:
     - в данном методе мы рассчитываем суммарный балл, а не средний -
     поэтому вместо averagingDouble() нужно использовать метод summingDouble();
     - терминальной операцией будет не метод collect(), а использование метода
     max(), в который будем передавать компаратор. При этом компаратор определит объект Tuple,
     у которого значение Score будет максимальным;
     - orElse() для того чтобы вернуть значение по умолчанию.
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(subj -> subj.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName,
                        Collectors.summingInt(Subject::getScore)))
                .entrySet().stream()
                .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(new Tuple("Ivan", 0));
    }
}