package org.knowledge_base;

import org.exceptions.UnknownVariableException;
import org.variable.Variable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class KnowledgeBase {
    private final Map<String, Variable> variables = new HashMap<>();

    public Variable addVariable(String name) {
        Variable x = new Variable(name);
        variables.putIfAbsent(name, x);
        return variables.get(name);
    }

    public Variable getVariable(String name) throws UnknownVariableException {
        Variable x = variables.get(name);
        if (x == null) {
            throw new UnknownVariableException(name);
        }
        return x;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("The knowledge base contains the following:\n");
        Collection<Variable> variables = this.variables.values();
        for (Variable variable : variables) {
            builder.append('\t').append(variable).append("\n");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public Map<String, Variable> stateCopy() {
        return new HashMap<>(this.variables);
    }
}
