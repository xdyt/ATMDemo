package Atm;

import java.util.Scanner;

import CarBank.Carn;

public class AtmTest {

	private static String name;
	private static Carn car = new Carn();
	private static Carn car2 = new Carn();

	public static void main(String[] args) throws Exception {
		// �������˻���ֵ
		car.setCarid(1001);
		car.setCarname("admin");
		car.setCarpwd("123");
		car.setCarmoney(20000);

		car2.setCarid(1002);
		car2.setCarname("lily");
		car2.setCarpwd("1234");
		car2.setCarmoney(10000);

		denglu();
	}

	// ��ꑷ���
	private static void denglu() throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ոݔ���~̖........");
		name = scanner.next();

		if (name.equals(car.getCarname()) || name.equals(car2.getCarname())) {
			System.out.println("Ոݔ���ܴa........");
			for (int i = 0; i < 3; i++) {
				String carpws = scanner.next();
				if (name.equals(car.getCarname())) {
					if (carpws.equals(car.getCarpwd())) {
						System.out.println("��ꑳɹ�.......");
						fangfa();
					} else {
						if (i > 2) {
							System.out.println("���Ŀ����i������,Ո������ԇ....");
							Thread.sleep(5000);
							denglu();
						} else {
							System.out.println("�ܴa�e�`,Ո����ݔ���ܴa");
						}
					}
				} else {
					if (carpws.equals(car2.getCarpwd())) {
						System.out.println("��ꑳɹ�.......");
						fangfa();
					} else {
						if (i > 2) {
							System.out.println("���Ŀ����i������,Ո������ԇ....");
							Thread.sleep(5000);
							denglu();
						} else {
							System.out.println("�ܴa�e�`,Ո����ݔ���ܴa");
						}
					}
				}
			}
		} else {
			System.out.println("�~̖������,��Ո���µ��....");
			denglu();
		}

	}

	// �ж�ִ��Ӧ��ִ���ĸ�����
	private static void fangfa() throws Exception {
		System.out.println("��ѡ��˵�");
		System.out.println("1 ��ѯ");
		System.out.println("2 ���");
		System.out.println("3 ȡ��");
		System.out.println("4 ת��");
		System.out.println("5 �޸�����");
		System.out.println("6 �˿�");
		Scanner scan = new Scanner(System.in);
		String a = scan.next();

		char charAt = a.charAt(0);
		switch (charAt) {
		case '1':
			chaxun();
			break;
		case '2':
			cunkuan();
			break;
		case '3':
			qukuan();
			break;
		case '4':
			zhuanzhuang();
			break;
		case '5':
			xiugaimima();
			break;
		default:
			tuika();
			break;
		}
	}

	// ȡ���
	private static void qukuan() throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Ոݔ����Ҫ���Ĕ�Ŀ:");
		double money = sc.nextDouble();
		do {
			if (name.equals(car.getCarname())) {
				double mon = car.getCarmoney();
				if (money % 100 == 0 && money > 0) {
					if (money<mon) {
						money = mon - money;
						car.setCarmoney(money);
						fangfa();
					} else {
						System.out.println("ȡ������ڿ��ڵ����");
						fangfa();
					}
				} else {
					System.out.println("ݔ��Ľ��~���І��},Ո����ݔ��.....(ݔ��100�ı���)");
				}
			} else {
				double mon = car2.getCarmoney();
				if (money % 100 == 0 && money > 0) {
					if (money<mon) {
						car2.setCarmoney(mon - money);
						fangfa();
					} else {
						System.out.println("ȡ������ڿ��ڵ����");
						fangfa();
					}
				} else {
					System.out.println("ݔ��Ľ��~���І��},Ո����ݔ��.....(ݔ��100�ı���)");
				}
			}
		} while (true);
	}

	// �޸��ܴa����
	private static void xiugaimima() throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������ľ�����:");
		String pwd = scanner.next();
		if (name.equals(car.getCarname())) {
			if (pwd.equals(car.getCarpwd())) {
				System.out.println("������������....");
				String newpwd = scanner.next();
				car.setCarpwd(newpwd);
				denglu();
			} else {
				System.out.println("�������,�������������ľ�����");
				xiugaimima();
			}
		} else {
			if (pwd.equals(car2.getCarpwd())) {
				System.out.println("������������....");
				car2.setCarpwd(scanner.next());
				denglu();
			} else {
				System.out.println("�������,�������������ľ�����");
				xiugaimima();
			}
		}
	}

	// ת�˷���
	private static void zhuanzhuang() throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("��������ת�˵��˻�:");
			String name1 = scanner.next();
			if (name.equals(car.getCarname())) {
				if (name1.equals(car.getCarname())) {
					System.out.println("������һ�������˻�����ת��");
				} else {
					System.out.println("������Ҫת�˵Ľ��:");
					double mone = scanner.nextDouble();
					double money = car2.getCarmoney();
					if (mone<money) {
						car2.setCarmoney(money + mone);
						System.out.println("��ת����˻������Ϊ" + car2.getCarmoney());
						fangfa();
					} else {
						System.out.println("ת�˽����ڿ��ڵĽ��,ת��ʧ��");
						fangfa();
					}
					
				}
			} else {
				if (name1.equals(car2.getCarname())) {
					System.out.println("������һ�������˻�����ת��");
				} else {
					System.out.println("������Ҫת�˵Ľ��:");
					double mone = scanner.nextDouble();
					double money = car.getCarmoney();
					if (mone<money) {
						car.setCarmoney(money + mone);
						System.out.println("��ת����˻������Ϊ" + car.getCarmoney());
						fangfa();
					} else {
						System.out.println("ת�˽����ڿ��ڵĽ��,ת��ʧ��");
						fangfa();
					}
				}
			}
		} while (true);
	}

	// ��ԃ����
	private static void chaxun() throws Exception {
		// TODO Auto-generated method stub
		if (name.equals(car.getCarname())) {
			System.out.println(car.getCarmoney());
			fangfa();
		} else {
			System.out.println(car2.getCarmoney());
			fangfa();
		}
	}

	// ����
	private static void cunkuan() throws Exception {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Ոݔ����Ҫ���Ĕ�Ŀ:");
			double money = sc.nextDouble();
			if (name.equals(car.getCarname())) {
				double mon = car.getCarmoney();
				if (money % 100 == 0 && money > 0) {
					money = money + mon;
					car.setCarmoney(money);
					fangfa();
				} else {
					System.out.println("ݔ��Ľ��~���І��},Ո����ݔ��.....(ݔ��100�ı���)");
				}
			} else {
				double mon = car2.getCarmoney();
				if (money % 100 == 0 && money > 0) {
					money = money + mon;
					car2.setCarmoney(money);
					fangfa();
				} else {
					System.out.println("ݔ��Ľ��~���І��},Ո����ݔ��.....(ݔ��100�ı���)");
				}
			}
		} while (true);
	}
	
	// �˿�
	private static void tuika() {
		System.out.println("Ոȡ�������y�п�.....");
		System.exit(1);
	}
}
