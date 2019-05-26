package pl.comprog;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.*;

/**
 * SudokuField class.
 */
public class SudokuField implements Cloneable, Serializable, Comparable<SudokuField> {

    private int value;

    public SudokuField() {
        this.value = 0;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append(value).toString();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        SudokuField ob = (SudokuField) obj;
        return new EqualsBuilder().append(this.value, ob.value).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(value).toHashCode();
    }


    public void setFieldValue(int value) {
        this.value = value;
    }

    public int getFieldValue() {
        return value;
    }

    @Override
    public SudokuField clone() throws CloneNotSupportedException {
        SudokuField clone = (SudokuField) super.clone();
        clone.value = this.value;
        return clone;
    }

    @Override
    public int compareTo(final SudokuField o) {

        int lastNameComparison = this.compareTo(o);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        } else {
            return this.compareTo(o);
        }
    }
}
