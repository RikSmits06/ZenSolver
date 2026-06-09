package org;

import org.cip.CIPUtil;
import org.exceptions.CombinedException;
import org.knowledge_base.KnowledgeBase;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {

    static void main() throws URISyntaxException, IOException, CombinedException {
        Path path = Paths.get(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("testBase.txt")).toURI());
        KnowledgeBase kb = CIPUtil.knowledgeBaseFromFile(path);
        System.out.println(kb);
    }
}
