package org.cip;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.exceptions.CombinedException;
import org.knowledge_base.KnowledgeBase;
import org.variable.Variable;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class CIPUtil {
    public static KnowledgeBase knowledgeBaseFromFile(Path path) throws IOException, CombinedException {
        CharStream stream = CharStreams.fromPath(path);
        CIPLexer lexer = new CIPLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CIPParser parser = new CIPParser(tokenStream);
        ParseTree tree = parser.knowledgeBase();
        return createKnowledgeBase(tree);
    }

    private static KnowledgeBase createKnowledgeBase(ParseTree tree) throws CombinedException {
        KnowledgeBase kb = new KnowledgeBase();
        Map<String, Variable> kbState = kb.stateCopy();
        ParseTreeWalker walker = new ParseTreeWalker();
        CIPTreeListener listener = new CIPTreeListener(kb);
        while (true) {
            walker.walk(listener, tree);
            listener.ensureNoErrors();
            Map<String, Variable> newKbState = kb.stateCopy();
            if (kbState.equals(newKbState)) {
                break;
            }
            kbState = newKbState;
        }

        return kb;
    }
}
