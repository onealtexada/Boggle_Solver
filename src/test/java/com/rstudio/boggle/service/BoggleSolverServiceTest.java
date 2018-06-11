package com.rstudio.boggle.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class BoggleSolverServiceTest {
    private final BoggleSolverService boggleSolverService = new BoggleSolverService();

    @Test
    public void testSolve() {
        char[][] board = {{'a', 'b', 'c', 'd'},{'q','s','t','v',},{'e','f','g','c'},{'t','b','z','r'}};
        Set<String> finalWordList = boggleSolverService.solve(board);

        assertNotNull(finalWordList);
    }
}
