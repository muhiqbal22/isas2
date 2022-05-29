/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map_project;

/**
 *
 * @author Ahmed
 */
public class Node {
        String name;
    int value;
	int pixelX;
	int pixelY;
    Node [] neighbors = new Node[10];
    public Node()
    {
    	
    }
	public Node(String name,int value,int pixelX,int pixelY){
		this.name = name;
		this.value  = value;
		this.pixelX = pixelX;
		this.pixelY  = pixelY;
	}
}
