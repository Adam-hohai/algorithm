package hhuc.Divide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * 随机生成含有n个不同元素的数组L（n≥10000），要求找出第k小的元素（k≤n）
 * 阈值=44，规模小于44时直接快速排序，大于44时分治加快排
 */
public class Findkmin {

//	List<Integer> list;
//	int p = 44;// 阈值
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
			int m = array.length/5;//分成五组
			int n = array.length - m*5;//剩下的
			
			//取每组中项
			int[] mid = new int[6];
			for(int i = 0; i < 5; i++) {
				Arrays.sort(array, m*i, (i+1)*m-1);
				mid[i] = array[((2*i+1)*m - 1)/2];
			}		
			Arrays.sort(array, 5*m-1, array.length-1);
			mid[5] = array[(5*m-1+array.length-1)/2];
			
			//从6个中项中再取一次中项
			Arrays.sort(mid);
			int mn = mid[2];
			
			//以这个中项为分隔分成3段,小于等于和大于中项的
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
			
			//递归
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
