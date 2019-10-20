package hhuc.Dynamicplanning;

import java.util.Random;

/*
 * ��������
 * ��̬�滮
 * ת������f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ),  f[i-1,j] },  f[i,j]��ʾ��ǰi����Ʒ��ѡ�����ɼ����ڳ���Ϊ j �ı����У�����ȡ�õ�����ֵ��Pi��ʾ��i����Ʒ�ļ�ֵ��
 * û�еݹ���Ƿ����ˡ�����¼����
 */

public class Bagproblem {

	public int maxvalue(int[] w, int[] v, int t) {
		int[][] wv = new int[t+1][w.length];
		
		//����Ϊ0ʱ�ܼ�ֵ����Ϊ0
		for(int i = 0; i < w.length; i++) {
			wv[0][i] = 0;
		}
		
		for (int i = 1; i <= t; i++) {//iΪ1��T
			for(int j = 0; j < w.length; j++) {//j����Ʒni			
				
				if(j == 0) {
					if(w[0] <= i) {
						wv[i][0] = v[0];
//						continue;
					}else {
						wv[i][0] = 0;
//						continue;
					}
				}
				
//				if(i == 1) {//����Ϊ1ʱ�ļ�ֵ����
//					for(int k = 1; k < w.length; k++) {
//						if(w[k] == 1 && v[k] > v[k-1]) {
//							wv[0][k] = v[k];
//						}else {
//							wv[0][k] = 0;
//						}
//					}
//				}
//				
				
				//ת������
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
		int[] w = new int[100];// ����
		int[] v = new int[100];// ��ֵ
		int T = 1000;// ��������
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
