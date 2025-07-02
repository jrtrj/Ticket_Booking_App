package com.trainBooking.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class JsonDBService<T> implements DBService{
  ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public List<T> readAll(File path, TypeReference<List<T>> typeReference) throws IOException {
       List<T> listFromDB = new ArrayList<>();
       listFromDB = objectMapper.readValue(path, typeReference);
       return listFromDB;
    }

    @Override
    public void writeAll(File path, List<T> items) throws IOException {
        objectMapper.writeValue(path,items);
    }
}
