package com.rstudio.boggle.service;

import java.util.Set;

public interface Dictionary {
    boolean validWord(String word, Set<String> validWords);
    
    boolean validPrefix(String prefix);
}
