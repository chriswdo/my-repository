package org.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 基数排序
 * 从小的位数开始排序。一直拍到大的位数
 * @author wd
 *
 */
public class RadixSort {
	
	@Test
	public void main(){
		int [] nums = {1,2,3,4,32,23223,232,11,225,55};
		nums = sort(nums);
		for(int i:nums){
			System.out.println(i);
		}
	}
	
	public static int[] sort(int [] nums ){
		int j=1;
		//循环排序
		while(true){
			int[] int_ret = sortByBin(nums,j);
			if(int_ret==nums)return int_ret;
			nums=int_ret;
			j=j*10;
		}
		
	}
	/**
	 * 按位排序	如果是1就比较各位，如果是10就比较十位，依此类推 
	 * @param nums
	 * @param bin
	 * @return
	 */
	public static int[] sortByBin(int[]nums,int bin){
		List[] bucket = new ArrayList [10];
		//标志为，用来判断该为是否需要比较， 例如所有的数都是两位数，就没有必要比较千位上的数。
		int flag = 0;
		for(int temp :nums){
			int res = temp/bin;
			if(res!=0)flag=res;
			int remaider = res%10;
			if(bucket[remaider]==null){
				bucket[remaider]=new ArrayList<Integer>();
			}
			bucket[remaider].add(temp);
		}
		if(flag==0)return nums;
		//建立新的数组，如果返回的是该数据，则标识比较继续
		int []int_res = new int[nums.length];
		int j=0;
		for(List li : bucket){
			if(li==null)continue;
			for(Object i : li){
				int_res[j++]=(Integer) i;
			}
		}
		return int_res;
	}

}
