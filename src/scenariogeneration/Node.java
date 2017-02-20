/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenariogeneration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents a node in a scenario tree structure (@class ScenarioTree).
 * Every node has an univocal id, a probability, an array of realizations (one array for each random variable)
 * @author lct495
 */
public class Node {
    // A counter used to cound the nodes and set an incrementing id
    private static int counter = 0;
    // The univocal id
    private int id;
    // The array of realizations, one for each random variable
    private double[] realizations;    
    // The probability of being in the node
    private double probability;
    // The stage at which the node belongs
    private int stage;
    // The immediate ancestor node
    private Node ancestor;
    // The array of immediate descendants of the node
    private List<Node> descendants;
        
    /**
     * The constructor which receives the array of realizations, the probability, and the stage
     * @param realizations
     * @param probability
     * @param stage 
     */
    public Node(double[] realizations, double probability, int stage) {
        this.id = counter;
        counter++;
        this.realizations = realizations;
        this.probability = probability;
        this.stage = stage;
        this.descendants = new ArrayList();
    }
    // Getters
    public int getId() {
        return id;
    }

    public double[] getRealizations() {
        return realizations;
    }

    public double getProbability() {
        return probability;
    }

    public int getStage() {
        return stage;
    }

    public Node getAncestor() {
        return ancestor;
    }

    public List<Node> getDescendants() {
        return descendants;
    }
    // Setters
    public void setAncestor(Node ancestor) {
        this.ancestor = ancestor;
    }

    public void setDescendants(List descendants) {
        this.descendants = descendants;
    }
    /**
     * This method adds a node to the array of descendants. 
     * Since the size of a java array cannot be modified it creates another
     * array with length+1 (using Arrays.copyOf), and adds in the additional position
     * the node to be added.
     * @param node 
     */
    public void addDescendant(Node node){
        this.descendants.add(node);
    }
    
    
}
