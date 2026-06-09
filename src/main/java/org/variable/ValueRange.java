package org.variable;

import org.exceptions.InvalidConstraintException;

import java.math.BigInteger;

/**
 * Represents a range of values used for variables.
 */
public class ValueRange {
    private BigInteger minValue;
    private BigInteger maxValue;


    public void add(ValueRange range) {
        if (this.minValue == null || range.minValue == null) {
            this.minValue = null;
        } else {
            this.minValue = this.minValue.add(range.minValue);
        }
        if (this.maxValue == null || range.maxValue == null) {
            this.maxValue = null;
        } else {
            this.maxValue = this.maxValue.add(range.maxValue);
        }
    }

    public void sub(ValueRange range) {
        if (this.minValue == null || range.minValue == null) {
            this.minValue = null;
        } else {
            this.minValue = this.minValue.subtract(range.minValue);
        }
        if (this.maxValue == null || range.maxValue == null) {
            this.maxValue = null;
        } else {
            this.maxValue = this.maxValue.subtract(range.maxValue);
        }
    }

    public BigInteger min() {
        return minValue;
    }

    public BigInteger max() {
        return maxValue;
    }

    /**
     * Restricts the range if newMin is more restrictive.
     *
     * @param newMin The new min value.
     * @throws InvalidConstraintException When the min is bigger than the max.
     */
    public void updateMinConstraint(BigInteger newMin) throws InvalidConstraintException {
        if (this.minValue == null || this.minValue.compareTo(newMin) < 0) {
            this.minValue = newMin;
            validateConstraint();
        }
    }

    /**
     * Restricts the range if newMax is more restrictive.
     *
     * @param newMax The new max value.
     * @throws InvalidConstraintException When the max is bigger than the min.
     */
    public void updateMaxConstraint(BigInteger newMax) throws InvalidConstraintException {
        if (this.maxValue == null || this.maxValue.compareTo(newMax) > 0) {
            this.maxValue = newMax;
            validateConstraint();
        }
    }

    private void validateConstraint() throws InvalidConstraintException {
        if (this.minValue != null && this.maxValue != null && this.minValue.compareTo(this.maxValue) > 0) {
            throw new InvalidConstraintException("Min value of range is bigger than the max value.");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (this.minValue == null) {
            builder.append("(-inf");
        } else {
            builder.append('[').append(this.minValue);
        }
        builder.append(", ");
        if (this.maxValue == null) {
            builder.append("inf)");
        } else {
            builder.append(this.maxValue).append(']');
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ValueRange range) {
            return this.minValue.equals(range.minValue) && this.maxValue.equals(range.maxValue);
        }
        return false;
    }

    public void mult(ValueRange right) {
        if (this.minValue == null || right.minValue == null) {
            this.minValue = null;
        } else {
            this.minValue = this.minValue.multiply(right.minValue);
        }
        if (this.maxValue == null || right.maxValue == null) {
            this.maxValue = null;
        } else {
            this.maxValue = this.maxValue.multiply(right.maxValue);
        }
    }
}
