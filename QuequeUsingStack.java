package com.aditya.mlabs.practiceBasics;

import java.util.Stack;

public class QuequeUsingStack {
	public static void main(String[] args){
		Queue sampleQueu = new Queue();
		sampleQueu.printCurrentQueu();
		sampleQueu.enQueue(7);
		sampleQueu.enQueue(23);
		sampleQueu.enQueue(19);
		sampleQueu.enQueue(16);
		sampleQueu.printCurrentQueu();
		sampleQueu.deQueue();
		sampleQueu.printCurrentQueu();
		sampleQueu.enQueue(65);
		sampleQueu.printCurrentQueu();
		sampleQueu.deQueue();
		sampleQueu.printCurrentQueu();
	}
}

class Queue {
	private Stack<Object> firstStack = new Stack<Object>();
	private Stack<Object> secondStack = new Stack<Object>();
	
	public void printCurrentQueu() {
		System.out.println(firstStack);
	}
	
	public void enQueue(Object item) {
		firstStack.push(item);
	}
	
	public Object deQueue() {
		//firstStack.push(item);
		if(firstStack.isEmpty()) {
			throw new RuntimeException("No element to deQueue from Queue");
		} else {
			while(!firstStack.isEmpty()) {
				Object interMediateElem = firstStack.pop();
				secondStack.push(interMediateElem);
			}
			Object deQueuedElem = secondStack.pop();
			firstStack.clear();
			while(!secondStack.isEmpty()) {
				Object interMediateElem = secondStack.pop();
				firstStack.push(interMediateElem);
			}
			secondStack.clear();
			return deQueuedElem;
		}
	}
}
