package com.trainBooking.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.*;

public interface DBService<T> {
    List<T> readAll(File path, TypeReference<List<T>> typeReference) throws IOException;
    void writeAll(File path,List<T> items) throws IOException;

}