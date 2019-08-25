/*
 * AnimalJudgeSystem�ࣺ����ʶ��ר��ϵͳ
 * ������
 * 		void loadRuleBase(String pathname) -- ���ع����
 * 		void recognizeAnimal(String pathname, String method) -- ʶ����
 * 		String reasonMachine() -- ���������
 * 		void displayRules() -- ��ʾ��������й���
 * 		void deleleRule() -- ɾ����������
 * 		void insertRule() -- ���뵥������
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AnimalJudgeSystem {
	private RuleBase ruleBase; // �����
	private ArrayList<String> factset = new ArrayList<String>(); // ��ʵ��
	private String[] animal_category = {"��", "��", "����", "����¹", "���", "����", "������"}; // ���ս��ۼ�
	public AnimalJudgeSystem(){
		this.ruleBase = new RuleBase();
	}
	
	// ���ع����
	public void loadRuleBase(String pathname){
		ruleBase.load(pathname);
	}
	
	// ʶ�� ����
	/*
	 * ������
	 * 		pathname -- ������ļ�·��
	 * 		method -- 'console'/'file'�� 'console'��ʾ����̨���붯�������� 'file'��ʾ�ļ����붯������
	 */
	public void recognizeAnimal(String pathname, String method){
		if(method == "console"){
			Scanner scanner = new Scanner(System.in);
			System.out.println("������ö�������� ���ԡ�end���������룩��");
			while(true){
				String feature = scanner.next();
				if(feature.equals("end"))break;
				factset.add(feature);
			}
		}
		else if (method == "file"){
			File file = new File(pathname);
	        try{
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            String content = null;
	            while((content = br.readLine()) != null){
	            		factset.add(content);     	
	            }
	            br.close();    
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		}
		else return;
		
		String result = reasonMachine();
		
		if(result == null){
			System.out.println("�޷�ʶ��˶��");
		}
		else {
			System.out.println("���������" + result);
		}
	}
	
	// ���������
	private String reasonMachine(){
		int[] rule_flag = new int[ruleBase.rules.size()];
		for(int i = 0; i < rule_flag.length; i++)rule_flag[i] = 0; 
		int i = 0;
		while(true){
			if(i == rule_flag.length)break;
			if(rule_flag[i] == 1){i++;continue;}
			Rule c_rule = ruleBase.rules.get(i);
			if(!contains(factset, c_rule.getCondition())){
					i++;
					continue;		
			}
			String c_conclusion  = c_rule.getConclusion();
			for(String string: animal_category){
				if(c_conclusion.equals(string))return c_conclusion;
			}
			factset.add(c_conclusion);
			rule_flag[i] = 1;
			i = 0;
		}
		return null;
	}
	
	// ��ʾ��������й���
	public void displayRules(){
		ruleBase.display();
	}
	
	// ɾ����������
	public void deleleRule(){
		ruleBase.delete();
	}
	
	// ���뵥������
	public void insertRule(){
		ruleBase.insert();
	}
	
	// �ж�A���Ƿ����B��
	public static boolean contains(ArrayList<String> a, ArrayList<String> b){
		Iterator<String> bIterator = b.iterator();		
		while(bIterator.hasNext()){
			String bString = bIterator.next();
			Iterator<String> aIterator = a.iterator();
			boolean find = false;
			while(aIterator.hasNext()){
				String aString = aIterator.next();
				if(bString.equals(aString)){find = true; break;}
			}
			if(find == false)return false;
		}
		return true;
	}
		
	
	
}
