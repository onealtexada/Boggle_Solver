package com.rstudio.boggle.controllers;

import static org.springframework.http.HttpStatus.OK;

import com.rstudio.boggle.dto.BoggleResult;
import com.rstudio.boggle.service.BoggleScorer;
import com.rstudio.boggle.service.BoggleSolverService;
import com.rstudio.boggle.service.impl.BoggleScorer4x4Board;
import com.rstudio.domain.type.BoggleBoard;
import com.rstudio.domain.type.BoggleResults;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("/boggle")
public class BoggleController {

    private final BoggleSolverService solverService;

    @Inject
    public BoggleController(final BoggleSolverService solverService) {
        this.solverService = solverService;
    }

    @PostMapping()
    public ResponseEntity<BoggleResults> getBoggleBoardResults(
        @RequestBody final BoggleBoard boggleBoard) {
        BoggleScorer scorer = new BoggleScorer4x4Board();

        Set<String> finalWordList =
            solverService.solve(boggleBoard.getBoard());

        BoggleResult result;
        Set<BoggleResult> sortedList = new TreeSet<>();

        int points = 0, score = 0;
        for (String word : finalWordList) {
            score = scorer.score(word);
            result = new BoggleResult(word, score);
            sortedList.add(result);
            points += score;
        }

        final BoggleResults boggleResults =
            new BoggleResults(sortedList, points);

        return new ResponseEntity<>(boggleResults, OK);
    }
}
