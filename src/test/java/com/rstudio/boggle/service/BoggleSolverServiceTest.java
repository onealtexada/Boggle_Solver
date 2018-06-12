package com.rstudio.boggle.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class BoggleSolverServiceTest {
    private final BoggleSolverService boggleSolverService = new BoggleSolverService();

    @Test
    public void testSolve() {
        char[][] board = {{'w', 'i', 'r', 'n'},{'s','i','t','h',},{'t','i','t','l'},{'e','l','l','i'}};
        Set<String> finalWordList = boggleSolverService.solve(board);

        assertNotNull(finalWordList);
        assertTrue(finalWordList.contains("with"));
        assertFalse(finalWordList.contains("elite"));
    }
}
