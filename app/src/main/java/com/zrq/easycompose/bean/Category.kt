package com.zrq.easycompose.bean

data class Category(
    val code: Int,
    val msg: String,
    val res: Res
)

data class Res(
    val category: List<CategoryX>
)

data class CategoryX(
    val atime: Double,
    val count: Int,
    val cover: String,
    val cover_temp: String,
    val ename: String,
    val filter: List<Any>,
    val icover: String,
    val id: String,
    val name: String,
    val picasso_cover: String,
    val rank: Int,
    val rname: String,
    val sn: Int,
    val type: Int
)