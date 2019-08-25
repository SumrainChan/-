/*
 * RuleBase�ࣺ�����
 * ������
 * 		void insert() -- ���뵥������
 * 		load(String pathname) -- ���ع����
 * 		void delete() -- ɾ����������
 * 		void display() -- ��ʾ���й���
 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RuleBase {
	public ArrayList<Rule> rules = new ArrayList<Rule>();
	
	// ���뵥������
	public void insert(){
		Rule rule = new Rule();
		Scanner scanner = new Scanner(System.in);
		String content = scanner.nextLine();
		String[] split_content = content.replace(" ", "").split("if|and|then");
		for(int i = 1; i < split_content.length; i++){
			if(i < split_content.length - 1){
				rule.addCondition(split_content[i]);
			}
			else {
				rule.setConclusion(split_content[i]);
			}
		}
		rules.add(rule);
	}
	
	// ���ع����
	public void load(String pathname){
		File file = new File(pathname);
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String content = null;
            while((content = br.readLine()) != null){
            	Rule rule = new Rule();
            	String[] split_content = content.replace(" ", "").split("if|and|then");
        		for(int i = 1; i < split_content.length; i++){
        			if(i < split_content.length - 1){
        				rule.addCondition(split_content[i]);
        			}
        			else {
        				rule.setConclusion(split_content[i]);
        			}
        		}        	
            	rules.add(rule);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	// ɾ����������
	public void delete(){
		display();
		System.out.println("��������Ҫɾ���Ĺ����ţ�");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		rules.remove(i);
	}
	
	// ��ʾ���й���
	public void display(){
		for(int i = 0; i < rules.size(); i++){
			Rule c_rule = rules.get(i);
			ArrayList<String>c_condition = c_rule.getCondition();
			String c_conclusion = c_rule.getConclusion();
			System.out.print("[" + i + "] if ");
			System.out.print(c_condition.get(0) + " ");
			for (int j = 1; j < c_condition.size(); j++){
				String c_String = c_condition.get(j);
				System.out.print("and " + c_String + " ");
			}
			System.out.println(" then " + c_conclusion);
		}
	}
}
