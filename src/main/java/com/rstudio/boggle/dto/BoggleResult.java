package com.rstudio.boggle.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.annotation.concurrent.Immutable;

@Immutable
public class BoggleResult implements Comparable<BoggleResult> {

    private final String word;
    private final Integer score;

    @JsonCreator
    public BoggleResult(final String word, final Integer score) {
        this.word = word;
        this.score = score;
    }

    public String getWord() {
        return word;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        final BoggleResult that = (BoggleResult) o;

        return Objects.equal(word, that.word)
            && Objects.equal(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word, score);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("word", word)
            .add("score", score).toString();
    }

    @Override
    public int compareTo(BoggleResult other) {
        return this.word.compareTo(other.word);
    }
}
