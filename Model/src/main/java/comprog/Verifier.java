package comprog;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Verifier implements Cloneable, Serializable {

    private List<SudokuField> numberContainer = new ArrayList<>();

    @Override
    public String toString() {
        ToStringBuilder s = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        for (int i = 0; i < numberContainer.size(); i++) {
            s.append(numberContainer.get(i));
        }
        return s.toString();
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
        Verifier ob = (Verifier) obj;
        EqualsBuilder e = new EqualsBuilder();
        for (int i = 0; i < numberContainer.size(); i++) {
            e.append(this.numberContainer.get(i), ob.numberContainer.get(i));
        }
        return e.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hs = new HashCodeBuilder(17, 37);
        for (int i = 0; i < numberContainer.size(); i++) {
            hs.append(numberContainer.get(i));
        }
        return hs.toHashCode();
    }

    public boolean verify() {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (numberContainer.get(i).getFieldValue() != 0 && numberContainer.get(j).getFieldValue() != 0) {
                    if (numberContainer.get(i).getFieldValue() == numberContainer.get(j).getFieldValue()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void addField(final SudokuField field) {
        numberContainer.add(field);
    }

    @Override
    public Verifier clone() throws CloneNotSupportedException {

        byte[] object;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos);) {
            oos.writeObject(this);
            object = baos.toByteArray();

        } catch (IOException ioe) {
            System.out.println(ioe);
            return null;
        }

        try (ByteArrayInputStream bais = new ByteArrayInputStream(object);
             ObjectInputStream ois = new ObjectInputStream(bais);) {

            Verifier clone = (Verifier) ois.readObject();
            return (Verifier) clone;
        } catch (IOException | ClassNotFoundException cnfe) {
            System.out.println(cnfe);
            return null;
        }
    }

}
