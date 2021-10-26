package cn.xzxy.lewy.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * java的型变
 */
public class TestGeneric {

    // Java数组满足协变特性
    Integer[] nums = new Integer[]{};
    // 可以由 Object > Integer 得到 Object[] > Integer[]
    Object[] objArray = nums; // 不会编译失败

    //-------------------------------------------------
    // Java 中的泛型是不型变的，这意味着 List<Integer> 并不是 List<Object> 的子类型
    List<Integer> list = new ArrayList<>();
    // 下面编译会报错：
    // required:List<Object>  find:List<Integer>
    // List<Object> objList = list;

    // *************************************************
    // java为了解决泛型的型变问题，提出了泛型的协变和逆变：
    // 协变: <? extends T>
    List<Integer> list2 = new ArrayList<>();
    List<? extends Object> o2 = list2;// 可以通过编译

    //-------------------------------------------------
    // 逆变：<? super T>
    public List<? super Integer> fun() {
        List<Object> list3 = new ArrayList<>();
        return list3;
    }
}
