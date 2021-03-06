﻿package ex;
/*
 * Topic: 輸入一整數 N 及 N 個整數，請依照十進位中各位數字和由小到大排序輸出。如果各位數字和相等則比較數值由小到大排列。
 例如: 9122 的各位數字和為 9+1+2+2=14、3128 的各位數字和為 3+1+2+8=14 而 5112 的各位數字和為 5+1+1+2=9。
 所以輸入 9122 3128 5112 需輸出 5112 3128 9122 ，這是因為 5112(9) < 3128(14) < 9122(14)，其中又因為 3128 與 9122 兩者的各位數字和都是 14，所以將 數值小的 3128 放前面。則經由計算可得其識別碼為 165 ，乃是 11 之倍數，故此為一合法之 ISBN 碼。輸入一串 ISBN 碼，以空格隔開。
 * Date: 2016/12/26
 * Author: 103051089 林冠磊
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ex01_103051089 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Num> list = new ArrayList<Num>();
		for(int i = 0 ; i < n;i++){
			list.add(new Num(sc.nextInt()));
		}
		Num temp;
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.size(); j++){
				if(list.get(i).GetTotal() < list.get(j).GetTotal()){
					temp = list.get(j);
					list.set(j,list.get(i));
					list.set(i, temp);
				}else if(list.get(i).GetTotal() == list.get(j).GetTotal()){
					if(list.get(i).GetNum() < list.get(j).GetNum()){
						temp = list.get(j);
						list.set(j,list.get(i));
						list.set(i, temp);
					}
				}
			}
		}
		for(Num data : list){
			System.out.print(data.GetNum()+"\t");
		}
		System.out.println();	
	}
}
class Num{
	private int num;
	public Num(int val){
		num = val;
	}
	public void SetNum(int val){
		num = val;
	}
	public int GetNum(){
		return num;
	}
	public int GetTotal(){
		int sum = 0;
		String[] data = String.valueOf(num).split("");
		for(String val : data){
			//ystem.out.println(val);
			sum += Integer.valueOf(val);
		}
		return sum;
	}
}
