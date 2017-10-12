package com.kodilla.testing.shape;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> shape = new ArrayList<>();

    public void addFigure(Shape shape) {
        // do nothing
    };

    public boolean removeFigure(Shape shape){
        // do nothing
        return true;
    };

    public Shape getFigure(int n) {
        return null;
    };

    public void showFigures(){
        // do nothing
    };
}
