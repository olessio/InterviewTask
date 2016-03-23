package com.alex.datastructure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class ListTestUtils {
    @SafeVarargs
    public static <T> void assertElements(LinkedList<T> list, T... elements) {
        assertThat(list.getSize(), equalTo(elements.length));

        if (elements.length == 0) {
            assertThat("Head should be null for empty list", list.getHead(), nullValue());
            assertThat("Tail should be null for empty list", list.getTail(), nullValue());
        } else if (elements.length == 1) {
            assertThat("Head and tail should be the same if list size is 1", list.getHead() == list.getTail(), is(true));
            assertThat("Head should be null for 1 element list", list.getHead().getNext(), nullValue());
            assertThat("Tail should be null for 1 element list", list.getTail().getNext(), nullValue());
        } else {
            for (T element : elements) {
                assertThat(list.contains(element), is(true));
            }

            assertThat("Head->next can't be null", list.getHead().getNext(), notNullValue());
            assertThat("Tail->next must be null", list.getTail().getNext(), nullValue());
        }
    }
}
