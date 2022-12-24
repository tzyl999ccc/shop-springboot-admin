package com.example.test01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: 天之璎珞
 */
@TableName("product_info")
@Data
public class ProductInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String content;
    private Integer price;
    private Integer number;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date date;
    private String cover;
}
