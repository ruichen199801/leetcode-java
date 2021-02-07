package com.leetcode.ruichen199801;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
	

	    // #155 https://leetcode-cn.com/problems/min-stack/
	    // Stack, Design
	    // TC = O(1) (for all operations), SC = O(n) (NOT optimized!)

	    private Deque<Integer> stack; 
	    private Deque<Integer> minStack; 

	    /** initialize your data structure here. */
	    public MinStack() {
	        stack = new ArrayDeque<>();
	        minStack = new ArrayDeque<>();
	    }
	    
	    public void push(int x) {
	        stack.offerFirst(x);
	        if (minStack.isEmpty() || x <= minStack.peekFirst()) {
	            minStack.offerFirst(x);
	        }
	    }
	    
	    public void pop() {
	        int res = stack.pollFirst();
	        if (res == minStack.peekFirst()) {
	            minStack.pollFirst();
	        }
	    }
	    
	    public int top() {
	        return stack.peekFirst();
	    }
	    
	    public int getMin() {
	        return minStack.peekFirst();
	    }

}


