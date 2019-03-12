package com.elisity.namehist;

import java.util.ArrayList;
import java.util.List;

public class NameNode {

    private final int histogramValue;
    private final String name;

    private List<NameNode> pointingTo = new ArrayList<>();
    private List<NameNode> pointedBy = new ArrayList<>();

    public NameNode(int histogramValue, String name) {
        this.histogramValue = histogramValue;
        this.name = name;
    }

    public void addPointingTo(NameNode nameNode) {
        pointingTo.add(nameNode);
    }

    public void addPointedBy(NameNode nameNode) {
        pointedBy.add(nameNode);
    }

    public int getHistogramValue() {
        return histogramValue;
    }

    public String getName() {
        return name;
    }

    public List<NameNode> getPointingTo() {
        return pointingTo;
    }

    public List<NameNode> getPointedBy() {
        return pointedBy;
    }
}
