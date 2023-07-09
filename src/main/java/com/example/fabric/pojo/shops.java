package com.example.fabric.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参构造
@AllArgsConstructor//全参构造
public class shops {
    private Integer id;
    private String shopName;
    private Double price;
    private String shopImage;
    private Integer shopsId;
    private Integer type;
    private Integer number;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
