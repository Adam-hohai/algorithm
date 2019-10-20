package hhuc.Divide;

import java.util.ArrayList;
import java.util.List;

/*
 * 分治算法
 * 数据要严格遵循x1<x2...<xi-1<xi>xi+1...>xn
 */
public class DivideandConquer {

	List<Integer> l;
	int top;

	public DivideandConquer(List<Integer> array) {
		l = new ArrayList<Integer>();
		for (Integer i : array) {
			l.add(i);
		}
		top = ((int) l.size() - 1) / 2;
	}

	public int mtop() {

		if (l.get(top) > l.get(top - 1) && l.get(top) > l.get(top + 1)) {
			return l.get(top);
		} else if (l.get(top) < l.get(top - 1) && l.get(top) > l.get(top + 1)) {
			top = top / 2;
			return mtop();
		} else if (l.get(top) > l.get(top - 1) && l.get(top) < l.get(top + 1)) {
			top = (top + l.size() - 1) / 2;
			return mtop();
		} else {
			return 0;
		}
//		return l.get(top);
	}

	public static void main(String[] args) {

		List<Integer> array = new ArrayList<Integer>();

		array.add(1);
		array.add(2);
		array.add(6);
		array.add(5);
		array.add(4);
		array.add(3);
		array.add(2);
		array.add(1);

		DivideandConquer di = new DivideandConquer(array);
		for (Integer i : di.l) {
			System.out.print(i + " ");
		}

		System.out.println("\n" + di.mtop());
	}

}
