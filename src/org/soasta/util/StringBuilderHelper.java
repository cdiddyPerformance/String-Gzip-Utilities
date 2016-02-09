package org.soasta.util;

import com.soasta.scripting.v1.ResultLevel;
import com.soasta.scripting.v1.ScriptEnvironment;

public class StringBuilderHelper {

	private static ScriptEnvironment environment = null;
    private static StringBuilder stringHelper = null;

    public StringBuilderHelper(ScriptEnvironment vEnvironment) {
		environment = vEnvironment;
		stringHelper = new StringBuilder("");
		environment.getContext().getResult().postMessage(ResultLevel.INFO, "StringBuilderHelper Created ");
	}

    public StringBuilderHelper(ScriptEnvironment vEnvironment, String str) {
		environment = vEnvironment;
		stringHelper = new StringBuilder(str);
		environment.getContext().getResult().postMessage(ResultLevel.INFO, "StringBuilderHeler Created : " + stringHelper.toString());
	}

    public char CharAt(Integer vPos){
    	return stringHelper.charAt(vPos);
    }

    public void Append(String vString){
    	stringHelper.append(vString);
    }

    public int Length(){
    	return stringHelper.length();
    }

    public int IndexOf(String vIndexOf){
    	return stringHelper.indexOf(vIndexOf);
    }

    public int LastIndexOf(String vIndexOf){
    	return stringHelper.indexOf(vIndexOf);
    }

    public String Insert(int vOffset, String vInsert){
    	return stringHelper.insert(vOffset, vInsert).toString();
    }

    public String Replace(int vStart, int vEnd, String vString){
    	return stringHelper.replace(vStart, vEnd, vString).toString();
    }

    public String Reverse(){
    	return stringHelper.reverse().toString();
    }

    public String Delete(int vStart, int vEnd){
    	return stringHelper.delete(vStart, vEnd).toString();
    }

    public String DeleteCharAt(int vPos){
    	return stringHelper.deleteCharAt(vPos).toString();
    }

    public void Clear(){
    	stringHelper = null;
    	stringHelper = new StringBuilder("");
		environment.getContext().getResult().postMessage(ResultLevel.INFO, "StringBuilderHeler Cleared");
    }
    
    public String ToString(){
    	return stringHelper.toString();
    }

}
