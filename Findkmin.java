package hhuc.Divide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * ������ɺ���n����ͬԪ�ص�����L��n��10000����Ҫ���ҳ���kС��Ԫ�أ�k��n��
 * ��ֵ=44����ģС��44ʱֱ�ӿ������򣬴���44ʱ���μӿ���
 */
public class Findkmin {

//	List<Integer> list;
//	int p = 44;// ��ֵ
//
//	public Findkmin(List<Integer> list) {
//		list = new ArrayList<>();
//		for (Integer i : list) {
//			this.list.add(i);
//		}
//	}

	public int kmin(int k, List<Integer> a) {
		int[] array = new int[a.size()];
		for(int i = 0; i < array.length; i++)
			array[i] = a.get(i);
		if(array.length <= 44) {
			Arrays.sort(array, 0, array.length-1);
			return array[k-1];
		}
			else {
			int m = array.length/5;//�ֳ�����
			int n = array.length - m*5;//ʣ�µ�
			
			//ȡÿ������
			int[] mid = new int[6];
			for(int i = 0; i < 5; i++) {
				Arrays.sort(array, m*i, (i+1)*m-1);
				mid[i] = array[((2*i+1)*m - 1)/2];
			}		
			Arrays.sort(array, 5*m-1, array.length-1);
			mid[5] = array[(5*m-1+array.length-1)/2];
			
			//��6����������ȡһ������
			Arrays.sort(mid);
			int mn = mid[2];
			
			//���������Ϊ�ָ��ֳ�3��,С�ڵ��ںʹ��������
			List<Integer> a1 = new ArrayList<>();
			List<Integer> a2 = new ArrayList<>();
			List<Integer> a3 = new ArrayList<>();
			
			for(int i = 0; i < array.length; i++) {
				if(array[i] < mn)
					a1.add(array[i]);
				if(array[i] == mn)
					a2.add(array[i]);
				else {
					a3.add(array[i]);
				}
			}
			
			//�ݹ�
			if(k <= a1.size())
				return kmin(k, a1);
			else if(k == a1.size()+1)
				return a2.get(0);
			else 
				return kmin(k, a3);
	}
}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			list.add(random.nextInt(10000));
			System.out.print(list.get(i) + " ");
		}
		Findkmin fkFindkmin = new Findkmin();
		System.out.println("\n" + fkFindkmin.kmin(5, list));
	}

}
