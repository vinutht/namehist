package com.elisity.namehist;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    private Map<String, NameNode> nameToNodeMap = new HashMap<>();

    public Main() {

        buildNameNode();
    }

    private void buildNameNode() {

        NameNode rajNode = new NameNode(5, "Raj");
        nameToNodeMap.put(rajNode.getName(), rajNode);

        NameNode rajaNode = new NameNode(10, "Raja");
        nameToNodeMap.put(rajaNode.getName(), rajaNode);

        NameNode rajanNode = new NameNode(8, "Rajan");
        nameToNodeMap.put(rajanNode.getName(), rajanNode);

        NameNode rajniNode = new NameNode(12, "Rajni");
        nameToNodeMap.put(rajniNode.getName(), rajniNode);

        rajNode.addPointedBy(rajaNode);
        rajNode.addPointedBy(rajniNode);

        rajaNode.addPointedBy(rajanNode);
        rajaNode.addPointingTo(rajNode);

        rajanNode.addPointingTo(rajaNode);
        rajniNode.addPointingTo(rajNode);

        NameNode cathyNode = new NameNode(7, "Cathy");
        nameToNodeMap.put(cathyNode.getName(), cathyNode);

        NameNode kathyNode = new NameNode(9, "Kathy");
        nameToNodeMap.put(kathyNode.getName(), kathyNode);

        kathyNode.addPointingTo(cathyNode);
        cathyNode.addPointedBy(kathyNode);

        NameNode bobNode = new NameNode(3, "Bob");
        nameToNodeMap.put(bobNode.getName(), bobNode);

        NameNode bobbiNode = new NameNode(5, "Bobbi");
        nameToNodeMap.put(bobbiNode.getName(), bobbiNode);

        NameNode bobbyNode = new NameNode(7, "Bobby");
        nameToNodeMap.put(bobbyNode.getName(), bobbyNode);

        bobNode.addPointedBy(bobbiNode);
        bobNode.addPointedBy(bobbyNode);

        bobbiNode.addPointingTo(bobNode);
        bobbyNode.addPointingTo(bobNode);

    }


    public int computeHistValue(String name) {

        Objects.requireNonNull(name, "Name is a mandatory field and should not be null");
        NameNode nameNode = nameToNodeMap.get(name);

        Objects.requireNonNull(nameNode, "Please provide a valid name");

        final int[] value = {nameNode.getHistogramValue()};

        nameNode.getPointedBy().forEach(pointedByNode -> {
            value[0] = value[0] + pointedByNode.getHistogramValue();
        });

        nameNode.getPointingTo().forEach(pointingToNode -> {
            value[0] = value[0] + pointingToNode.getHistogramValue();
        });

        return value[0];
    }


    public static void main(String args[]) {

        Main m = new Main();

        int histValue = m.computeHistValue("Cathy");

        System.out.println(histValue);
    }
}
