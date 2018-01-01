package com.aditya.mlabs.structures.Queque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//CONSTRUCTION: with no initializer


public class ArrayBasedQueque {
	
	public static int DEFAULT_SIZE;
	
	private Integer data[];
	
	private int index =0;
	
	public ArrayBasedQueque(int capacity){
		DEFAULT_SIZE = capacity;
		data=new Integer[DEFAULT_SIZE];
	}
	
	public boolean isEmpty(){
		return index==0;
	}
	
	public Integer[] getReplicaOfQueuque() throws Exception{
		if(isEmpty())
			throw new Exception("Queue is empty");
		return data;
	}
	
	public void enqueue(Integer obj) throws Exception{
		if(index== DEFAULT_SIZE){
			throw new Exception("Queue is full. Dequeue some objects");
		}
		this.data[index]=obj;
		this.index++;
		
	}
	
	public Integer dequeue() throws Exception{
		if(isEmpty())
			throw new Exception("Queue is empty");
		
		final Integer obj = this.data[0];
		this.index--;
		Integer newData[] = new Integer[DEFAULT_SIZE];
		for(int i = 0; i<this.index; i++){
			newData[i] = this.data[i+1];
		}
		this.data = new Integer[this.index];
		this.data = newData;
		return obj;
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
        int capacity = s.nextInt();                 // Reading input from STDIN
        ArrayBasedQueque queue = new ArrayBasedQueque(capacity);
        s.nextLine(); // throw away the newline.
        for (int i = 0; i < capacity; i++) {
            if (s.hasNextInt()) {
            	queue.enqueue(s.nextInt());
            } else {
                break;
            }
        }
		System.out.println(queue.dequeue());
	}

}