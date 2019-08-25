/*
 * Rule�ࣺ���������¼
 * ������
 * 		void addCondition(String condition) -- ���ǰ������
 * 		void setConclusion(String conclusion) -- �趨����
 * 		ArrayList<String> getCondition() -- ���������
 * 		String getConclusion() -- ��ý���
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Rule {
	private ArrayList<String> condition = new ArrayList<>();
	private String conclusion = new String();
	
	// ���ǰ������
	public void addCondition(String condition){
		this.condition.add(condition);
	}
	
	// �趨����
	public void setConclusion(String conclusion){
		this.conclusion = conclusion;
	}
	
	// ���������
	public ArrayList<String> getCondition(){
		return condition;
	}
	
	// ��ý���
	public String getConclusion(){
		return conclusion;
	}
}
