/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenariogeneration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides the structure for scenario trees.
 * A scenario tree is essentially an organized collection of nodes (@class Node)
 * @author lct495
 */
public class ScenarioTree {
    
    // This list will contain all the nodes
    private List<Node> nodes;
    // This map associates to each stage a list of nodes
    private Map<Integer,List<Node>> stage_nodes;
    private int stages;

    /**
     * A preliminary constructor with dummy equally-probable nodes
     * @param stages
     * @param branches_per_node 
     */
    public ScenarioTree(int stages, int branches_per_node) {
        // Initializes the necessary structures
        this.nodes = new ArrayList();
        this.stage_nodes = new HashMap();
        this.stages = stages;
        
        // Creates the root node and adds it to the necessary structures
        double[] root_realizations = {0.1,0.2};
        Node root = new Node(root_realizations,1,1);
        root.setAncestor(null);
        nodes.add(root);
        stage_nodes.put(1, new ArrayList());
        stage_nodes.get(1).add(root);
        
        // Creates the rest of the nodes
        for(int t = 1; t < stages; t++){
            stage_nodes.put(t+1, new ArrayList());
            for(Node n : stage_nodes.get(t)){
                for(int b = 1; b <= branches_per_node; b++){
                    double[] dummy_realizations = {0.1,0.2};
                    double probability = 1.0/branches_per_node;
                    Node node = new Node(dummy_realizations,probability,t+1);
                    node.setAncestor(n);
                    n.addDescendant(node);
                    nodes.add(node);
                    stage_nodes.get(t+1).add(node);
                }
            }
        }
    }
    
    public void print(){
        for(int t = 1; t <= this.stages; t++){
            for(Node n : stage_nodes.get(t)){
                System.out.println("Node : "+n.getId()+" probability : "+n.getProbability()+" stage : "+n.getStage());
                if(n.getAncestor() != null){
                    System.out.println("Ancestor : "+n.getAncestor().getId());
                }
                if(n.getDescendants().isEmpty()){
                    System.out.println("No descendants.");
                }else{
                    System.out.println("Descendants :");
                    for(Node d : n.getDescendants()){
                        System.out.println("Node : "+d.getId());
                    }
                }
            }
        }
    }
}
