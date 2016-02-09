package org.soasta.util;

import com.soasta.scripting.v1.ResultLevel;
import com.soasta.scripting.v1.ScriptEnvironment;

public class JavaStringHelper {

	private static ScriptEnvironment environment = null;
    private static String stringHelper = null;

    public JavaStringHelper(ScriptEnvironment vEnvironment) {
		environment = vEnvironment;
		stringHelper = new String("");
		environment.getContext().getResult().postMessage(ResultLevel.INFO, "StringHelper Created");
	}

    public JavaStringHelper(ScriptEnvironment vEnvironment, String str) {
		environment = vEnvironment;
		stringHelper = new String(str);
		environment.getContext().getResult().postMessage(ResultLevel.INFO, "StringHelper Created: " + str);
	}
    
    public char CharAt(Integer vPos){
    	return stringHelper.charAt(vPos);
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

    public void Replace(String vToFind, String vToReplace){
    	stringHelper = stringHelper.replace(vToFind, vToReplace);
    }

    public void ReplaceAll(String vRegex, String vReplacement){    	
    	stringHelper = stringHelper.replaceAll(vRegex, vReplacement);
    }

    public void ReplaceFirst(String vRegex, String vReplacement){
    	stringHelper = stringHelper.replaceFirst(vRegex, vReplacement);
    }

    public Boolean IsEmpty(){
    	return stringHelper.isEmpty();
    }

    public String SubString(int vStart){
    	return stringHelper.substring(vStart);
    }

    public void SubString(int vStart, int vEnd){
    	stringHelper = stringHelper.substring(vStart, vEnd);
    }

    public void Concat(String str){
    	stringHelper = stringHelper.concat(str);
    }

    public Boolean Contains(String vStr){
    	return stringHelper.contains(vStr);
    }

    public void Trim(){
    	stringHelper = stringHelper.trim();
    }

    public void ToLowerCase(){
    	stringHelper = stringHelper.toLowerCase();
    }

    public void ToUpperCase(){
    	stringHelper = stringHelper.toUpperCase();
    }

    public int HashCode(){
    	return stringHelper.hashCode();
    }

    public Boolean Matches(String vRegex){
    	return stringHelper.matches(vRegex);
    }

    public Boolean EqualsIgnoreCase(String vRegex){
    	return stringHelper.equalsIgnoreCase(vRegex);
    }

    public Boolean Equals(String vRegex){
    	return stringHelper.equalsIgnoreCase(vRegex);
    }

    public String[] Split(String vRegex){
    	return stringHelper.split(vRegex);
    }

    public void Clear(){
    	stringHelper = null;
    	stringHelper = new String("");
		environment.getContext().getResult().postMessage(ResultLevel.INFO, "StringHelper Cleared");
    }
    
    public String Value(){
    	return stringHelper;
    }

    public void Set(String str){
    	stringHelper = str;
    }

}
