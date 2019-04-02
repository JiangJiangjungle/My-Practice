package com.jsj.data_structure.graph;

/**
 * 数据结构之---图
 */
public class Graph {

    /**
     * 邻接矩阵实现：
     * <p>
     * 缺点：空间浪费
     */
    private int[][] matrix;

    /**
     * 邻接表实现：
     * <p>
     * 缺点：不容易判断两个顶点是有关系（边），顶点的出度容易，但是求入度需要遍历整个邻接表
     */
    private Node[] table;


    private class Node {
        private int index;
        private int val;
        private Node next;
    }
}
