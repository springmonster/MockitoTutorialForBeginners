package com.in28minutes.mockito;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class SpyTest {

    @Test
    public void creatingASpyOnArrayList() {
        List<String> listSpy = spy(ArrayList.class);
        listSpy.add("Ranga");
        listSpy.add("in28Minutes");

        verify(listSpy).add("Ranga");
        verify(listSpy).add("in28Minutes");

        assertEquals(2, listSpy.size());
        assertEquals("Ranga", listSpy.get(0));
    }

    @Test
    public void creatingASpyOnArrayList_overridingSpecificMethods() {
        List<String> listSpy = spy(ArrayList.class);
        listSpy.add("Ranga");
        listSpy.add("in28Minutes");

        doReturn(-1).when(listSpy).size();

        assertEquals(-1, listSpy.size());
        assertEquals("Ranga", listSpy.get(0));

        // @Spy Annotation
    }

}
