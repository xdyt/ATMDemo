package Atm;

import java.util.Scanner;

import CarBank.Carn;

public class AtmTest {

	private static String name;
	private static Carn car = new Carn();
	private static Carn car2 = new Carn();

	public static void main(String[] args) throws Exception {
		// 给两个账户赋值
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

	// 登陸方法
	private static void denglu() throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("請輸入賬號........");
		name = scanner.next();

		if (name.equals(car.getCarname()) || name.equals(car2.getCarname())) {
			System.out.println("請輸入密碼........");
			for (int i = 0; i < 3; i++) {
				String carpws = scanner.next();
				if (name.equals(car.getCarname())) {
					if (carpws.equals(car.getCarpwd())) {
						System.out.println("登陸成功.......");
						fangfa();
					} else {
						if (i > 2) {
							System.out.println("您的卡被鎖定五秒,請稍後再試....");
							Thread.sleep(5000);
							denglu();
						} else {
							System.out.println("密碼錯誤,請重新輸入密碼");
						}
					}
				} else {
					if (carpws.equals(car2.getCarpwd())) {
						System.out.println("登陸成功.......");
						fangfa();
					} else {
						if (i > 2) {
							System.out.println("您的卡被鎖定五秒,請稍後再試....");
							Thread.sleep(5000);
							denglu();
						} else {
							System.out.println("密碼錯誤,請重新輸入密碼");
						}
					}
				}
			}
		} else {
			System.out.println("賬號不存在,清請重新登陸....");
			denglu();
		}

	}

	// 判断执行应该执行哪个方法
	private static void fangfa() throws Exception {
		System.out.println("请选择菜单");
		System.out.println("1 查询");
		System.out.println("2 存款");
		System.out.println("3 取款");
		System.out.println("4 转账");
		System.out.println("5 修改密码");
		System.out.println("6 退卡");
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

	// 取款方法
	private static void qukuan() throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("請輸入你要存款的數目:");
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
						System.out.println("取款金额大于卡内的余额");
						fangfa();
					}
				} else {
					System.out.println("輸入的金額數有問題,請重新輸入.....(輸入100的倍數)");
				}
			} else {
				double mon = car2.getCarmoney();
				if (money % 100 == 0 && money > 0) {
					if (money<mon) {
						car2.setCarmoney(mon - money);
						fangfa();
					} else {
						System.out.println("取款金额大于卡内的余额");
						fangfa();
					}
				} else {
					System.out.println("輸入的金額數有問題,請重新輸入.....(輸入100的倍數)");
				}
			}
		} while (true);
	}

	// 修改密碼方法
	private static void xiugaimima() throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入您的旧密码:");
		String pwd = scanner.next();
		if (name.equals(car.getCarname())) {
			if (pwd.equals(car.getCarpwd())) {
				System.out.println("请输入新密码....");
				String newpwd = scanner.next();
				car.setCarpwd(newpwd);
				denglu();
			} else {
				System.out.println("密码错误,请重新输入您的旧密码");
				xiugaimima();
			}
		} else {
			if (pwd.equals(car2.getCarpwd())) {
				System.out.println("请输入新密码....");
				car2.setCarpwd(scanner.next());
				denglu();
			} else {
				System.out.println("密码错误,请重新输入您的旧密码");
				xiugaimima();
			}
		}
	}

	// 转账方法
	private static void zhuanzhuang() throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("请输入你转账的账户:");
			String name1 = scanner.next();
			if (name.equals(car.getCarname())) {
				if (name1.equals(car.getCarname())) {
					System.out.println("请输入一个其他账户进行转账");
				} else {
					System.out.println("请输入要转账的金额:");
					double mone = scanner.nextDouble();
					double money = car2.getCarmoney();
					if (mone<money) {
						car2.setCarmoney(money + mone);
						System.out.println("您转入的账户的余额为" + car2.getCarmoney());
						fangfa();
					} else {
						System.out.println("转账金额大于卡内的金额,转账失败");
						fangfa();
					}
					
				}
			} else {
				if (name1.equals(car2.getCarname())) {
					System.out.println("请输入一个其他账户进行转账");
				} else {
					System.out.println("请输入要转账的金额:");
					double mone = scanner.nextDouble();
					double money = car.getCarmoney();
					if (mone<money) {
						car.setCarmoney(money + mone);
						System.out.println("您转入的账户的余额为" + car.getCarmoney());
						fangfa();
					} else {
						System.out.println("转账金额大于卡内的金额,转账失败");
						fangfa();
					}
				}
			}
		} while (true);
	}

	// 查詢方法
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

	// 存款方法
	private static void cunkuan() throws Exception {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("請輸入你要存款的數目:");
			double money = sc.nextDouble();
			if (name.equals(car.getCarname())) {
				double mon = car.getCarmoney();
				if (money % 100 == 0 && money > 0) {
					money = money + mon;
					car.setCarmoney(money);
					fangfa();
				} else {
					System.out.println("輸入的金額數有問題,請重新輸入.....(輸入100的倍數)");
				}
			} else {
				double mon = car2.getCarmoney();
				if (money % 100 == 0 && money > 0) {
					money = money + mon;
					car2.setCarmoney(money);
					fangfa();
				} else {
					System.out.println("輸入的金額數有問題,請重新輸入.....(輸入100的倍數)");
				}
			}
		} while (true);
	}
	
	// 退卡
	private static void tuika() {
		System.out.println("請取走您的銀行卡.....");
		System.exit(1);
	}
}
