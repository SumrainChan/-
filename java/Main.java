/*
 * ���������
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalJudgeSystem animalJudgeSystem = new AnimalJudgeSystem();
		animalJudgeSystem.loadRuleBase("./rules.txt");
		System.out.println("-----��ӭʹ�ö���ʶ��ר��ϵͳ-----");
		while(true){
			System.out.println("��������Ҫִ�еĹ��ܱ�ţ�");
			System.out.println("	[1] ����ʶ��");
			System.out.println("	[2] ��ʾ����");
			System.out.println("	[3] �������");
			System.out.println("	[4] ɾ������");
			System.out.println("	[5] �˳�ϵͳ");
			Scanner scanner = new Scanner(System.in);
			int choose = scanner.nextInt();
			if(choose == 1)animalJudgeSystem.recognizeAnimal("", "console");
			else if(choose == 2)animalJudgeSystem.displayRules();
			else if(choose == 3)animalJudgeSystem.insertRule();
			else if(choose == 4)animalJudgeSystem.deleleRule();
			else break;
			System.out.println("-------------------------");
		}
	}


}

