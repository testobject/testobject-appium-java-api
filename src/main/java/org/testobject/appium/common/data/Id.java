package org.testobject.appium.common.data;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Preconditions;

public abstract class Id<T> {

    private final T value;

    protected Id(T value) {
        Preconditions.checkNotNull(value);
        this.value = value;
    }

    @JsonValue
    public T value() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        @SuppressWarnings("unchecked")
        Id<T> other = (Id<T>) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}