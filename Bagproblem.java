package hhuc.Dynamicplanning;

import java.util.Random;

/*
 * 背包问题
 * 动态规划
 * 转换方程f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ),  f[i-1,j] },  f[i,j]表示在前i件物品中选择若干件放在承重为 j 的背包中，可以取得的最大价值。Pi表示第i件物品的价值。
 * 没有递归而是放在了‘备忘录’中
 */

public class Bagproblem {

	public int maxvalue(int[] w, int[] v, int t) {
		int[][] wv = new int[t+1][w.length];
		
		//容量为0时总价值都设为0
		for(int i = 0; i < w.length; i++) {
			wv[0][i] = 0;
		}
		
		for (int i = 1; i <= t; i++) {//i为1到T
			for(int j = 0; j < w.length; j++) {//j是物品ni			
				
				if(j == 0) {
					if(w[0] <= i) {
						wv[i][0] = v[0];
//						continue;
					}else {
						wv[i][0] = 0;
//						continue;
					}
				}
				
//				if(i == 1) {//容量为1时的价值总量
//					for(int k = 1; k < w.length; k++) {
//						if(w[k] == 1 && v[k] > v[k-1]) {
//							wv[0][k] = v[k];
//						}else {
//							wv[0][k] = 0;
//						}
//					}
//				}
//				
				
				//转换方程
				if(j != 0) {
					int wv1 = 0, wv2 = 0;
					if(i >= w[j])
						wv1 = wv[i-w[j]][j-1] + v[j];
					wv2 = wv[i][j-1];
					if(wv1 >= wv2)
						wv[i][j] = wv1;
					else if(wv1 < wv2)
						wv[i][j] = wv2;
				}
			}
		}
		
		return wv[t][w.length-1];
	}

	public static void main(String[] args) {
		int[] w = new int[100];// 质量
		int[] v = new int[100];// 价值
		int T = 1000;// 背包容量
		Random random = new Random();
		for (int i = 0; i < w.length; i++) {
			w[i] = random.nextInt(100);
			System.out.print(w[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < v.length; i++) {
			v[i] = random.nextInt(100);
			System.out.print(v[i] + " ");
		}
		
		Bagproblem bagproblem = new Bagproblem();
		System.out.println("\n" + bagproblem.maxvalue(w, v, T));

	}

}
