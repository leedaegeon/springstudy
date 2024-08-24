package tobyspring.hellospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {
    Sort sort;
    @BeforeEach
    void beforeEach() {
//        테스트 준비(given)
        sort = new Sort();
    }

    @Test
    void sort() {

//        실행(when)
//        list.of()로 리스트 생성시 immutable이어서 정렬이 안됨
//        좀더 전통적인 Arrays.asList()로 리스트 생성
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));
//        검증(then)
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
    }

    @Test
    void sort3Items() {

//        실행(when)
        List<String> list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));
//        검증(then)
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }

    @Test
    void sortAlreadySorted() {
//        실행(when)
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "ccc"));
//        검증(then)
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }
}
