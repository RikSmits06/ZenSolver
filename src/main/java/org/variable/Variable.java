package org.variable;

import org.exceptions.InvalidConstraintException;

import java.math.BigInteger;

public class Variable {
    private final String name;
    private final ValueRange range;

    public Variable(String name) {
        this.name = name;
        this.range = new ValueRange();
    }


    @Override
    public String toString() {
        return name + " in " + range;
    }

    public void updateMinConstraint(BigInteger value) throws InvalidConstraintException {
        this.range.updateMinConstraint(value);
    }

    public void updateMaxConstraint(BigInteger value) throws InvalidConstraintException {
        this.range.updateMaxConstraint(value);
    }

    public ValueRange getRange() {
        return this.range;
    }

    public void updateRange(ValueRange range) throws InvalidConstraintException {
        this.range.updateMinConstraint(range.min());
        this.range.updateMaxConstraint(range.max());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Variable var) {
            return var.name.equals(this.name) && var.range.equals(this.range);
        }
        return false;
    }
}
