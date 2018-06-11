package com.rstudio.domain.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.rstudio.boggle.dto.BoggleResult;

import javax.annotation.concurrent.Immutable;

import java.util.Set;

@Immutable
public class BoggleResults {

    private final Set<BoggleResult> words;
    private final Integer totalWords;
    private final Integer totalPoints;

    @JsonCreator
    public BoggleResults(final Set<BoggleResult> words, final Integer totalPoints) {
        this.words = words;
        this.totalWords = words.size();
        this.totalPoints = totalPoints;
    }

    public Set<BoggleResult> getWords() {
        return words;
    }

    public Integer getTotalWords() {
        return totalWords;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        final BoggleResults that = (BoggleResults) o;

        return Objects.equal(words, that.words)
            && Objects.equal(totalWords, that.totalWords)
            && Objects.equal(totalPoints, that.totalPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(words, totalWords, totalPoints);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("words", words)
            .add("totalWords", totalWords).add("totalPoints", totalPoints)
            .toString();
    }
}
