package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> shapeList = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapeList.add(shape);
    };

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if (shapeList.contains(shape)){
            shapeList.remove(shape);
            result = true;
        }
        return result;
    };

    public String getFigure(int n) {
        return shapeList.get(n).getShapeName();
    };

    public double getField(int n) {
        return shapeList.get(n).getField();
    };

    public int getPostsQuantity(){
        return shapeList.size();
    }

    public void showFigures(){
        for(Shape myList : shapeList) {
            System.out.println("Name of shape: " + myList.getShapeName() + " field " + myList.getField());
        }
    };
}
